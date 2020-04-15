package com.catalogue.controllers;


import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.catalogue.models.ItemContainer;
import com.catalogue.models.Profile;
import com.catalogue.views.CatalogueView;
import com.catalogue.views.SwitchProfileView;

public class SwitchProfileController {
	private ItemContainer model;
	private SwitchProfileView view;
	public SwitchProfileController(ItemContainer m, SwitchProfileView v) {
		this.model = m;
		this.view = v;
		initView();
	}
	public void initView() {
		/*Shows all profiles in ItemContainer as Buttons*/
		int rows=0;
		for(Profile profile:model.getProfiles()) {
			view.getButton()[rows].setLabel(profile.getName());
			rows++;
		}
	}
	public void InitController() {
		/*Adding Mapping to Main Screen onClick Event*/
		for(Button button: view.getButton()) {
			button.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { 
				view.getFrame().dispose();
				CatalogueView view= new CatalogueView("Video Catalogue");
				CatalogueController controller = new CatalogueController(model, view, button.getLabel());
				controller.InitController();
			} });
		}
	}
}
