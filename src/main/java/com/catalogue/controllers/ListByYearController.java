package com.catalogue.controllers;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import com.catalogue.models.Film;
import com.catalogue.models.ItemContainer;
import com.catalogue.models.TitleAndGenre;
import com.catalogue.models.TvSeries;
import com.catalogue.views.ItemDetailsView;
import com.catalogue.views.ListByYearView;

public class ListByYearController {
	private ItemContainer ic;
	private Map<Integer, List<TitleAndGenre>> model;
	private ListByYearView view;
	private String profile;
	private Map<String, Film> filmMap=new HashMap<String, Film>();
	private Map<String, TvSeries> tvSeriesMap= new HashMap<String, TvSeries>();
	public ListByYearController(Map<Integer, List<TitleAndGenre>> m, ListByYearView v, String p, ItemContainer ic, Map<String, Film> filmMap, Map<String, TvSeries> tvSeriesMap) {
		this.model=m;
		this.view=v;
		this.profile=p;
		this.ic=ic;
		this.filmMap=filmMap;
		this.tvSeriesMap=tvSeriesMap;
		view.setLblYear(new ArrayList<JLabel>());
		view.setLblTitle(new ArrayList<JLabel>());
		view.setLblGenre(new ArrayList<JLabel>());
		initView();

	}
	/*Initialize the View As Per Data*/
	public void initView() {
		int i=0;
		int j=0;
		int loc=30;
		for(Integer key:model.keySet()) {
			view.getLblYear().add(new JLabel(key.toString()));
			view.getLblYear().get(i).setFont(new Font("Tahoma", Font.PLAIN, 15));
			view.getLblYear().get(i).setBounds(30, loc, 81, 20); 
			view.getFrame().getContentPane().add(view.getLblYear().get(i));
			List<TitleAndGenre> objList= model.get(key);
			for(TitleAndGenre obj:objList) {
				loc+=30;
				view.getLblTitle().add(new JLabel(obj.getTitle()));
				view.getLblGenre().add(new JLabel(obj.getGenre()));
				view.getLblGenre().get(j).setFont(new Font("Tahoma", Font.PLAIN, 15));
				view.getLblGenre().get(j).setBounds(180, loc, 250, 20); 
				view.getFrame().getContentPane().add(view.getLblGenre().get(j));

				view.getLblTitle().get(j).setFont(new Font("Tahoma", Font.PLAIN, 15));
				view.getLblTitle().get(j).setBounds(30, loc, 81, 20); 
				view.getFrame().getContentPane().add(view.getLblTitle().get(j));
				j++;
			}
			loc+=30;
			i++;
		}
		
		
		for(JLabel label:view.getLblTitle()) {
			Font font = label.getFont();
			Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
			attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			label.setFont(font.deriveFont(attributes));
			label.setForeground(Color.blue);
			label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
	}
	public void initController() {
		/*Title Mapping to ItemDetailsView on MouseClick Event*/
		for(JLabel label:view.getLblTitle()) {
			label.addMouseListener(new MouseAdapter()  
			{  
				public void mouseClicked(MouseEvent e)  
				{

					if(filmMap.containsKey(label.getText())) {
						view.getFrame().dispose();
						ItemDetailsView itemDetailsView= new ItemDetailsView("Item Details");
						ItemDetailsController itemDetailsController= new ItemDetailsController(filmMap.get(label.getText()), itemDetailsView, profile, ic);
						itemDetailsController.InitController();

					}else if(tvSeriesMap.containsKey(label.getText())){
						view.getFrame().dispose();
						ItemDetailsView itemDetailsView= new ItemDetailsView("Item Details");
						ItemDetailsController itemDetailsController= new ItemDetailsController(tvSeriesMap.get(label.getText()), itemDetailsView, profile, ic);
						itemDetailsController.InitController();
					}
				}  
			}); 
		}

	}

}
