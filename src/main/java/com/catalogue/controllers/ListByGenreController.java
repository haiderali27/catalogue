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
import com.catalogue.models.TitleAndYear;
import com.catalogue.models.TvSeries;
import com.catalogue.views.ItemDetailsView;
import com.catalogue.views.ListByGenreView;

public class ListByGenreController {
	private Map<String, List<TitleAndYear>> model;
	private ItemContainer ic;
	private ListByGenreView view;
	private String profile;
	private Map<String, Film> filmMap=new HashMap<String, Film>();
	private Map<String, TvSeries> tvSeriesMap= new HashMap<String, TvSeries>();
	public ListByGenreController(Map<String, List<TitleAndYear>> m, ListByGenreView v, String p, ItemContainer ic, Map<String, Film> filmMap, Map<String, TvSeries> tvSeriesMap) {
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
	public void initView() {
		int i=0;
		int j=0;
		int loc=5;
		for(String key:model.keySet()) {
			view.getLblGenre().add(new JLabel(key.toString()));
			view.getLblGenre().get(i).setFont(new Font("Tahoma", Font.PLAIN, 15));
			view.getLblGenre().get(i).setBounds(60, loc, 81, 20); 
			view.getContainer().add(view.getLblGenre().get(i));
			List<TitleAndYear> objList= model.get(key);
			for(TitleAndYear obj:objList) {
				loc+=20;
				view.getLblTitle().add(new JLabel(obj.getTitle()));
				view.getLblYear().add(new JLabel(obj.getYear().toString()));

				view.getLblYear().get(j).setFont(new Font("Tahoma", Font.PLAIN, 15));
				view.getLblYear().get(j).setBounds(350, loc, 250, 20); 
				view.getContainer().add(view.getLblYear().get(j));

				view.getLblTitle().get(j).setFont(new Font("Tahoma", Font.PLAIN, 15));
				view.getLblTitle().get(j).setBounds(60, loc, 120, 20); 
				view.getContainer().add(view.getLblTitle().get(j));
				j++;
			}
			loc+=20;
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
