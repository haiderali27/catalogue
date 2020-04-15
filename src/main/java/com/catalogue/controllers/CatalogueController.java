package com.catalogue.controllers;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.swing.JLabel;

import com.catalogue.models.Film;
import com.catalogue.models.ItemContainer;
import com.catalogue.models.TitleAndGenre;
import com.catalogue.models.TitleAndGenreComparator;
import com.catalogue.models.TitleAndYear;
import com.catalogue.models.TitleAndYearComparator;
import com.catalogue.models.TvSeries;
import com.catalogue.views.AddNewItemView;
import com.catalogue.views.CatalogueView;
import com.catalogue.views.ItemDetailsView;
import com.catalogue.views.ListByGenreView;
import com.catalogue.views.ListByYearView;
import com.catalogue.views.SwitchProfileView;

public class CatalogueController {

	private ItemContainer model;
	private CatalogueView view;
	private String profileName;
	//Contains all the preffered films
	private Map<String, Film> filmMap=new HashMap<String, Film>();
	//Contains all the preffered tvSeries
	private Map<String, TvSeries> tvSeriesMap= new HashMap<String, TvSeries>();
	//Contains the year as key sorted in reverse order, and List of TitleAndGenre as List and this is used as model in listByYearView
	private Map<Integer, List<TitleAndGenre>> listByYear= new TreeMap<Integer, List<TitleAndGenre>>(Collections.reverseOrder()); 
	//Contains the genre as key sorted in asc order, and TitleAndYear as List and this is used as model in listByGenreView
	private Map<String, List<TitleAndYear>> listByGenre= new TreeMap<String, List<TitleAndYear>>(); 

	public CatalogueController(ItemContainer model,CatalogueView view, String profileName){
		this.model=model;
		this.view=view;
		this.profileName=profileName;
		initView();
	}
	
	/*Initialize Events Handling as Per View*/
	public void InitController() {
		/*Title Mapping to ItemDetailsView on MouseClick Event*/
		for(JLabel label:view.getVideoLbl()) {
			label.addMouseListener(new MouseAdapter()  
			{  
				public void mouseClicked(MouseEvent e)  
				{

					if(filmMap.containsKey(label.getText())) {
						view.getFrame().dispose();
						ItemDetailsView itemDetailsView= new ItemDetailsView("Item Details");
						ItemDetailsController itemDetailsController= new ItemDetailsController(filmMap.get(label.getText()), itemDetailsView, view.getLblProfileValue().getText(), model);
						itemDetailsController.InitController();

					}else if(tvSeriesMap.containsKey(label.getText())){
						view.getFrame().dispose();
						ItemDetailsView itemDetailsView= new ItemDetailsView("Item Details");
						ItemDetailsController itemDetailsController= new ItemDetailsController(tvSeriesMap.get(label.getText()), itemDetailsView, view.getLblProfileValue().getText(), model);
						itemDetailsController.InitController();
					}
					else {
						System.out.println("dummy");
					}
				}  
			}); 
		}

		/*Mapping to SwitchProfileView on MouseClick Event*/
		view.getSwitchProfileBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.getFrame().dispose();
				SwitchProfileView switchProfileView = new SwitchProfileView("Select User");
				SwitchProfileController switchProfileController = new SwitchProfileController(model, switchProfileView);
				switchProfileController.InitController();
			}
		});
		/*Mapping to AddNewItemView on MouseClick Event*/
		view.getAddNewBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.getFrame().dispose();
				AddNewItemView addNewItemView = new AddNewItemView("Add Item");
				AddNewItemController addNewItemController = new AddNewItemController(model, addNewItemView, view.getLblProfileValue().getText());
				addNewItemController.InitController();

			}
		});
		/*Mapping to ListByGenreView on MouseClick Event*/
		view.getListByGenreButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.getFrame().dispose();
				ListByGenreView listByGenreView = new ListByGenreView("List By Genre");
				ListByGenreController listByGenreController= new ListByGenreController(listByGenre, listByGenreView, view.getLblProfileValue().getText(), model, filmMap, tvSeriesMap);
				listByGenreController.initController();
			}
		});
		/*Mapping to ListByYearView on MouseClick Event*/
		view.getListByYearBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.getFrame().dispose();
				ListByYearView listByYearView = new ListByYearView("List By Year");
				ListByYearController listByYearController= new ListByYearController(listByYear, listByYearView, view.getLblProfileValue().getText(), model, filmMap, tvSeriesMap);
				listByYearController.initController();
			}
		});
	}
	/*Initialize the View As Per Data*/
	public void initView() {
		
		/*Checks whether profile exists in ItemContainer*/
		if(model.getProfileMap().containsKey(this.profileName)) {
			view.getLblProfileValue().setText(profileName);
		}
		else {
			System.exit(0);
		}

		/*Setting the Title Label Blue Underlined*/
		for(JLabel label:view.getVideoLbl()) {
			Font font = label.getFont();
			Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
			attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			label.setFont(font.deriveFont(attributes));
			label.setForeground(Color.blue);
			label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		/*Setting the prefferedFilms and TvSeries According to Profile Preffered Genre*/
		/*
		 * Also, listByView model and listByGenreModel are set here
		 */
		//Rows is set to 0, as there are max 5 rows, so on getting 5 films or tv series, the list will be completed
		int rows=0;
		List<Film> prefferedFilms= new ArrayList<Film>();
		List<TvSeries> prefferedTvSeries= new ArrayList<TvSeries>();
		Integer preferredGenre=this.model.getProfileMap().get(view.getLblProfileValue().getText()).getPreferredGenre();
		for(Film film : model.getFilms()) {
			if(rows>=5) {
				break;
			}
			if(film.getGenre().contains(preferredGenre)) {
				prefferedFilms.add(film);
				rows++;
			}
		}

		if(rows<5) {
			for(TvSeries tvSeries:model.getTvseries()) {
				if(rows>=5) {
					break;
				}
				if(tvSeries.getGenre().contains(preferredGenre)) {
					prefferedTvSeries.add(tvSeries);
					rows++;
				}
			}
		}
		rows=0;
		
		String genreList="";
		/*Getting prefferedFilms from the model*/
		for(Film film:prefferedFilms) {
			this.filmMap.put(film.getTitle(), film);
			view.getVideoLbl()[rows].setText(film.getTitle());
			view.getYearLbl()[rows].setText(film.getYear().toString());
			String genre="";
			for(Integer genreId:film.getGenre()) {
				genre+=model.getGenreMap().get(genreId).getGenre()+ "|";
			}
			genreList+=genre;
			view.getGenreLabel()[rows].setText(genre);
			rows++;

			if(listByYear.containsKey(film.getYear())) {
				List<TitleAndGenre> objList=listByYear.get(film.getYear());
				objList.add(new TitleAndGenre(film.getTitle(), genre));
				listByYear.put(film.getYear(), objList);
			}else {
				List<TitleAndGenre> objList= new ArrayList<TitleAndGenre>();
				objList.add(new TitleAndGenre(film.getTitle(), genre));
				listByYear.put(film.getYear(), objList);
			}
		}

		/*Getting prefferedtvSeries from the model*/
		for(TvSeries tvSeries:prefferedTvSeries) {
			this.tvSeriesMap.put(tvSeries.getTitle(), tvSeries);
			view.getVideoLbl()[rows].setText(tvSeries.getTitle());
			view.getYearLbl()[rows].setText(tvSeries.getYear().toString());
			String genre="";
			for(Integer genreId:tvSeries.getGenre()) {
				genre+=model.getGenreMap().get(genreId).getGenre()+ "|";
			}
			view.getGenreLabel()[rows].setText(genre);
			genreList+=genre;
			rows++;
			if(listByYear.containsKey(tvSeries.getYear())) {
				List<TitleAndGenre> objList=listByYear.get(tvSeries.getYear());
				objList.add(new TitleAndGenre(tvSeries.getTitle(), genre));
				listByYear.put(tvSeries.getYear(), objList);
			}else {
				List<TitleAndGenre> objList= new ArrayList<TitleAndGenre>();
				objList.add(new TitleAndGenre(tvSeries.getTitle(), genre));
				listByYear.put(tvSeries.getYear(), objList);
			}
		}
		
		/*List Contains all the genre from the main catalogue Screen*/
		List<String> prefferedGenre=Arrays.asList(genreList.split("\\|"));
		/*Getting the distinct genre from the list, as two videos can be of one Genre*/
		prefferedGenre=prefferedGenre.stream().distinct().collect(Collectors.toList());

		/*Mapping the list of videos to Genre, by iterating all prefferedMovies and prefferedTvSeries*/
		for(String pG: prefferedGenre) {

			for(Film film:prefferedFilms) {
				for(Integer genreId:film.getGenre()) {
					if(pG.equalsIgnoreCase(model.getGenreMap().get(genreId).getGenre())) {
						if(listByGenre.containsKey(pG)) {
							List<TitleAndYear> objList= new ArrayList<TitleAndYear>();
							objList=listByGenre.get(pG);
							objList.add(new TitleAndYear(film.getTitle(), film.getYear()));
							listByGenre.put(pG, objList);
						}else {
							List<TitleAndYear> objList= new ArrayList<TitleAndYear>();
							objList.add(new TitleAndYear(film.getTitle(), film.getYear()));
							listByGenre.put(pG, objList);
						}
					}
				}
			}

			for(TvSeries tvSeries:prefferedTvSeries) {
				for(Integer genreId:tvSeries.getGenre()) {
					if(pG.equalsIgnoreCase(model.getGenreMap().get(genreId).getGenre())) {
						if(listByGenre.containsKey(pG)) {
							List<TitleAndYear> objList= new ArrayList<TitleAndYear>();
							objList=listByGenre.get(pG);
							objList.add(new TitleAndYear(tvSeries.getTitle(), tvSeries.getYear()));
							listByGenre.put(pG, objList);
						}else {
							List<TitleAndYear> objList= new ArrayList<TitleAndYear>();
							objList.add(new TitleAndYear(tvSeries.getTitle(), tvSeries.getYear()));
							listByGenre.put(pG, objList);
						}
					}
				}
			}
		}
		
		//Sorting the list of TitleAndGenre by Title, which are mapped to year//
		for(Integer key:listByYear.keySet()) {
			List<TitleAndGenre> objList=listByYear.get(key);
			Collections.sort(objList, new TitleAndGenreComparator());               
		}
		//Sorting the list of TitleAndYear by Title, which are mapped to genre//
		for(String key:listByGenre.keySet()) {
			List<TitleAndYear> objList=listByGenre.get(key);
			Collections.sort(objList, new TitleAndYearComparator());
		}
	}

}
