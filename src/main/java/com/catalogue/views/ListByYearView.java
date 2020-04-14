package com.catalogue.views;


import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
public class ListByYearView {
	// View uses Swing framework to display UI to user
	private JFrame frame;
	private List<JLabel>lblYear;
	private List<JLabel> lblTitle;
	private List<JLabel> lblGenre;
	public List<JLabel> getLblYear() {
		return lblYear;
	}
	public void setLblYear(List<JLabel> lblYear) {
		this.lblYear = lblYear;
	}
	public List<JLabel> getLblTitle() {
		return lblTitle;
	}
	public void setLblTitle(List<JLabel> lblTitle) {
		this.lblTitle = lblTitle;
	}
	public List<JLabel> getLblGenre() {
		return lblGenre;
	}
	public void setLblGenre(List<JLabel> lblGenre) {
		this.lblGenre = lblGenre;
	}


	public ListByYearView(String title) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(450, 350);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		/*
		 * lblYear[0].setFont(new Font("Tahoma", Font.PLAIN, 15));
		 * lblYear[0].setBounds(10, 30, 81, 14); frame.getContentPane().add(lblYear[0]);
		 
		;*/	
		}
	public JFrame getFrame() {
		return frame;
	}

}