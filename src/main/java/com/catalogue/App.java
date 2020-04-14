package com.catalogue;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.catalogue.controllers.CatalogueController;
import com.catalogue.models.ItemContainer;
import com.catalogue.views.CatalogueView;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	public static ObjectMapper objectMapper=null;
	static ItemContainer item=null;
	public static void loadData() throws IOException {
		App.objectMapper = new ObjectMapper();
		 item = objectMapper.readValue(new InputStreamReader(new FileInputStream(new File(System.getProperty("user.dir")+"\\"+"data.json")), "UTF-8")
					,ItemContainer.class);			
	}
	
	public static void saveData() throws IOException{
		App.objectMapper.writeValue(new OutputStreamWriter(new FileOutputStream(new File(System.getProperty("user.dir")+"\\"+"data.json")), "UTF-8")
				,item);	
	}
	public static void main(String []args) {
		System.out.println("hello world");
		try {
			App.loadData();
			App.item.makeProfileMap();
			App.item.makeGenreMap();
			App.item.makePeopleMap();
			CatalogueView view= new CatalogueView("Video Catalogue");
			CatalogueController controller = new CatalogueController(item, view, "Fury");
			controller.InitController();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}



/*  sometests
 * 
 * 			//App.item.makeMaps();
			//System.out.println(item.getFilmsMap().get(155).getTitle());
 * 
 * 		//byte[] jsonData = Files.readAllBytes(Paths.get("data.json"));
//ItemContainer item = objectMapper.readValue(jsonData, ItemContainer.class);	
 * 
 * ObjectMapper mapper = new ObjectMapper(); try { JsonNode rootNode =
 * mapper.readTree(new File("data.json")); //People []people =
 * mapper.readValue(new File(System.getProperty("user.dir")+"\\"+"data.json"),
 * People[].class); //System.out.println(people[28].getPid()); } catch
 * (JsonParseException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } catch (JsonMappingException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); }
 */
