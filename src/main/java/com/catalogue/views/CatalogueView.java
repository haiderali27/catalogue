package com.catalogue.views;


import javax.swing.JButton;
import javax.swing.JFrame;


import javax.swing.JLabel;


public class CatalogueView {
	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JButton switchProfileBtn = new JButton("Switch Profile");
	private JButton addNewBtn = new JButton("Add New");
	private JButton listByYearBtn = new JButton("List By Year");
	private JButton listByGenreButton = new JButton("List By Genre");
	private JLabel[] videoLbl = new JLabel[5]; 
	private JLabel[] yearLbl = new JLabel[5]; 
	private JLabel[] genreLabel = new JLabel[5]; 
	private final JLabel lblUserProfile = new JLabel("User Profile:");
	private JLabel lblProfileValue = new JLabel("dummy");
	public JLabel getLblProfileValue() {
		return lblProfileValue;
	}
	public void setLblProfileValue(JLabel lblProfileValue) {
		this.lblProfileValue = lblProfileValue;
	}
	public JLabel[] getVideoLbl() {
		return videoLbl;
	}
	public void setVideoLbl(JLabel[] videoLbl) {
		this.videoLbl = videoLbl;
	}
	public JLabel[] getYearLbl() {
		return yearLbl;
	}
	public void setYearLbl(JLabel[] yearLbl) {
		this.yearLbl = yearLbl;
	}
	public JLabel[] getGenreLabel() {
		return genreLabel;
	}
	public void setGenreLabel(JLabel[] genreLabel) {
		this.genreLabel = genreLabel;
	}

	public JButton getSwitchProfileBtn() {
		return switchProfileBtn;
	}
	public void setSwitchProfileBtn(JButton switchProfileBtn) {
		this.switchProfileBtn = switchProfileBtn;
	}
	public JButton getAddNewBtn() {
		return addNewBtn;
	}
	public void setAddNewBtn(JButton addNewBtn) {
		this.addNewBtn = addNewBtn;
	}
	public JButton getListByYearBtn() {
		return listByYearBtn;
	}
	public void setListByYearBtn(JButton listByYearBtn) {
		this.listByYearBtn = listByYearBtn;
	}
	public JButton getListByGenreButton() {
		return listByGenreButton;
	}
	public void setListByGenreButton(JButton listByGenreButton) {
		this.listByGenreButton = listByGenreButton;
	}

	public CatalogueView(String title) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(700, 250);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);


	
		switchProfileBtn.setBounds(10, 40, 125, 23);
		frame.getContentPane().add(switchProfileBtn);


	
		addNewBtn.setBounds(10, 80, 125, 23);
		frame.getContentPane().add(addNewBtn);


		listByYearBtn.setBounds(10, 120, 125, 23);
		frame.getContentPane().add(listByYearBtn);


		listByGenreButton.setBounds(10, 160, 125, 23);
		frame.getContentPane().add(listByGenreButton);
		lblUserProfile.setBounds(276, 11, 75, 14);
		
		frame.getContentPane().add(lblUserProfile);
		lblProfileValue.setBounds(349, 11, 46, 14);
		
		frame.getContentPane().add(lblProfileValue);
		
		/*
		 * videoLbl[0] = new JLabel("dummy"); videoLbl[0].setBounds(173, 36, 46, 14);
		 * frame.getContentPane().add(videoLbl[0]);
		 * 
		 * 
		 * 
		 * yearLbl[0]=new JLabel("dummy"); yearLbl[0].setBounds(282, 36, 46, 14);
		 * frame.getContentPane().add(yearLbl[0]);
		 * 
		 * genreLabel[0]=new JLabel("dummy"); genreLabel[0].setBounds(391, 36, 46, 14);
		 * frame.getContentPane().add(genreLabel[0]); frame.setVisible(true);
		 */
		
		int loc=40;
		for(int i=0;i<5;i++) {
			
			videoLbl[i] = new JLabel("dummy");
			videoLbl[i].setBounds(173, loc, 80, 14);
			frame.getContentPane().add(videoLbl[i]);
			

			yearLbl[i]=new JLabel("dummy");
			yearLbl[i].setBounds(282, loc, 50, 14);
			frame.getContentPane().add(yearLbl[i]);
			
			genreLabel[i]=new JLabel("dummy");
			genreLabel[i].setBounds(391, loc, 200, 14);
			frame.getContentPane().add(genreLabel[i]);
			frame.setVisible(true);
			
			loc=loc+30;
		}
	}
}
