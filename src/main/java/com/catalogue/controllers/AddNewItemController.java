package com.catalogue.controllers;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.NumberFormatter;

import com.catalogue.models.Film;
import com.catalogue.models.Genre;
import com.catalogue.models.ItemContainer;
import com.catalogue.models.People;
import com.catalogue.models.TvSeries;
import com.catalogue.views.AddNewItemView;
import com.catalogue.views.CatalogueView;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class AddNewItemController {
	private ItemContainer model;
	private AddNewItemView view;
	private String profileName;
	private List<Integer> genre=new ArrayList<Integer>();
	private List<Integer> cast=new ArrayList<Integer>();
	private Integer director=0;
	public AddNewItemController(ItemContainer m, AddNewItemView v, String profileName) {
		this.model = m;
		this.view = v;
		this.profileName=profileName;
		initView();
	}
	public void initView() {

	}
	public int directorValidation(String director) {
		if(director.isEmpty()) {
			return 1;
		}
		List<People> people= model.getPeople();
		int peopleSize=people.size();
		int count=0;
		for(People peopleObj:people) {
			if(director.contentEquals(peopleObj.getName())) {
				this.director=peopleObj.getPid();
				break;
			}
			count++;
		}
		if(peopleSize-count==0) {
			return 2;
		}
		return 0;
	}

	public int castValidation(String cast) {
		if(cast.isEmpty()) {
			return 1;
		}
		String [] tokens = cast.split("\n");
		List<People> people= model.getPeople();
		int peopleSize=people.size();

		for(int i=0;i<tokens.length;i++) {
			int count=0;
			for(int j=0;j<peopleSize;j++) {
				if(tokens[i].equalsIgnoreCase(people.get(j).getName())) {
					this.cast.add(people.get(j).getPid());
					break;
				}
				count++;	
			}
			if(peopleSize-count==0) {
				return 2;
			}
		}

		return 0;
	}

	public int genreValidation(String genre) {
		if(genre.isEmpty()) {
			return 1;
		}
		String [] tokens = genre.split("\\|");
		List<Genre> useAbleGenre= model.getGenres();
		int genreSize=useAbleGenre.size();

		for(int i=0;i<tokens.length;i++) {
			int count=0;
			tokens[i]=tokens[i].replaceAll("\\s+", "");
			for(int j=0;j<genreSize;j++) {
				if(tokens[i].equalsIgnoreCase(useAbleGenre.get(j).getGenre())) {
					this.genre.add(useAbleGenre.get(j).getGid());
					break;
				}
				count++;	
			}
			if(genreSize-count==0) {
				return 2;
			}
		}

		return 0;
	}
	public boolean yearValidation(String year) {
		if(year.length()!=4) {
			return false;
		}
		/*
		 * if(Integer.parseInt(year)<1900||Integer.parseInt(year)>Calendar.getInstance()
		 * .get(Calendar.YEAR)+1) { return false; }
		 */
		return true;
	}
	public void InitController() {
		view.getChckbxTvSeries().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(view.getChckbxTvSeries().isSelected()) {	
					view.getLblDirector().setText("Creator:");
				}else {
					view.getLblDirector().setText("Director:");
				}
			}
		});


		JFormattedTextField txt = ((JSpinner.NumberEditor) view.getTxtYear().getEditor()).getTextField();
		((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);

		view.getBtnSave().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int genreValidationResult=genreValidation(view.getTxtGenre().getText());
				int directorValidationResult=directorValidation(view.getTxtDirector().getText());
				int castValidationResult=castValidation(view.getTxtCast().getText());
				if(!yearValidation(view.getTxtYear().getValue().toString())) {
					JOptionPane.showMessageDialog(null, "year value is invalid, it must be 4 digit");
					return;
				}

				if(genreValidationResult==1) {
					JOptionPane.showMessageDialog(null, "Genre is empty");
					return;

				}
				if(genreValidationResult==2) {
					JOptionPane.showMessageDialog(null, "Some of Genre do not exist");
					return;
				}
				if(directorValidationResult==1) {
					JOptionPane.showMessageDialog(null, "Director Field is Empty");
					return;
				}
				if(directorValidationResult==2) {
					JOptionPane.showMessageDialog(null, "Director Doesn't Exist");
					return;
				}
				if(castValidationResult==1){
					JOptionPane.showMessageDialog(null, "Cast is empty");
					return;
				}
				if(castValidationResult==2){
					JOptionPane.showMessageDialog(null, "Some of Cast members do not exist");
					return;
				}
				String title= view.getTxtTitle().getText();
				String description= view.getTxtDescription().getText();
				Integer year=Integer.parseInt(view.getTxtYear().getValue().toString());
				if(view.getChckbxTvSeries().isSelected()) {
					Integer id=model.getTvseries().size()+1;
					TvSeries tvSeries=new TvSeries(id, title, year, genre, director, cast ,description);
					model.addTvSeries(tvSeries);
				}
				else {
					Integer id=model.getFilms().size()+1;
					Film film=new Film(id, title, year, cast,  genre, director, description);
					model.addFilm(film);
				}
				ObjectMapper objectMapper=  new ObjectMapper();
				try {

					view.getFrame().dispose();
					objectMapper.writeValue(new OutputStreamWriter(new FileOutputStream(new File(System.getProperty("user.dir")+"\\"+"data.json")), "UTF-8")
							,model);
					CatalogueView view= new CatalogueView("Video Catalogue");
					CatalogueController controller = new CatalogueController(model, view, profileName);
					controller.InitController();
				} catch (JsonGenerationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}

		});

	}
}
