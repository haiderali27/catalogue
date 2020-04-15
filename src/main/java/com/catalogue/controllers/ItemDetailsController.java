package com.catalogue.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.catalogue.models.Film;
import com.catalogue.models.ItemContainer;
import com.catalogue.models.TvSeries;
import com.catalogue.views.CatalogueView;
import com.catalogue.views.ItemDetailsView;



public class ItemDetailsController {
	private ItemContainer ic;
	private Object model;
	private ItemDetailsView view;
	private String profileName;
	public ItemDetailsController(Object m, ItemDetailsView v, String profileName, ItemContainer ic) {
		this.model = m;
		this.view = v;
		this.profileName=profileName;
		this.ic=ic;
		initView();
	}
	/*Initialize the View As Per Data*/
	public void initView() {
		if(model instanceof Film) {
		
			view.getLblDirector().setText("Director: ");
			view.getTxtTitle().setEditable(false);
			view.getTxtDescription().setEditable(false);
			view.getTxtYear().setEnabled(false);
			view.getTxtGenre().setEditable(false);
			view.getTxtDirector().setEditable(false);
			view.getTxtCast().setEditable(false);
			
			view.getTxtTitle().setText(((Film) model).getTitle());
			view.getTxtDescription().setText(((Film) model).getDescription());
			view.getTxtYear().setValue(((Film) model).getYear());
			String genre="";
			for(Integer genreId:((Film) model).getGenre()) {
				genre+=((ItemContainer) ic).getGenreMap().get(genreId).getGenre()+ "|";
			}
			view.getTxtGenre().setText(genre);
			
			String director= ic.getPeopleMap().get(((Film) model).getDirector()).getName();
			
			view.getTxtDirector().setText(director);
			String people="";
			for(Integer peopleId:((Film) model).getGenre()) {
				people+=((ItemContainer) ic).getPeopleMap().get(peopleId).getName()+ "\n";
			}
			
			view.getTxtCast().setText(people);
		
		}
		if(model instanceof TvSeries) {
			view.getLblDirector().setText("Creator: ");
			view.getTxtTitle().setEditable(false);
			view.getTxtDescription().setEditable(false);
			view.getTxtYear().setEnabled(false);
			view.getTxtGenre().setEditable(false);
			view.getTxtDirector().setEditable(false);
			view.getTxtCast().setEditable(false);
			
			view.getTxtTitle().setText(((TvSeries) model).getTitle());
			view.getTxtDescription().setText(((TvSeries) model).getDescription());
			view.getTxtYear().setValue(((TvSeries) model).getYear());
			String genre="";
			for(Integer genreId:((TvSeries) model).getGenre()) {
				genre+=((ItemContainer) ic).getGenreMap().get(genreId).getGenre()+ "|";
			}
			view.getTxtGenre().setText(genre);
			
			String director= ic.getPeopleMap().get(((TvSeries) model).getCreator()).getName();
			
			view.getTxtDirector().setText(director);
			String people="";
			for(Integer peopleId:((TvSeries) model).getGenre()) {
				people+=((ItemContainer) ic).getPeopleMap().get(peopleId).getName()+ "\n";
			}
			
			view.getTxtCast().setText(people);
		
		}
		

	}
	public void InitController() {
		/*Back Button Mapping to Main Screen on Click event*/
		view.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getFrame().dispose();
				CatalogueView view= new CatalogueView("Video Catalogue");
				CatalogueController controller = new CatalogueController(ic, view, profileName);
				controller.InitController();
			}
		});
	}
}
