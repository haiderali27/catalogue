
package com.catalogue.views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
public class AddNewItemView {

	private JFrame frame;
	private final JLabel lblTitle = new JLabel("Title: ");
	private final JLabel lblDescription = new JLabel("Description: ");
	private final JLabel lblYear = new JLabel("Year: ");
	private final JLabel lblGenre = new JLabel("Genre: ");
	private JLabel lblDirector;
	public JLabel getLblDirector() {
		return lblDirector;
	}
	public void setLblDirector(JLabel lblDirector) {
		this.lblDirector = lblDirector;
	}
	private final JLabel lblCast = new JLabel("Cast: ");
	
	public JTextField getTxtTitle() {
		return txtTitle;
	}
	public void setTxtTitle(JTextField txtTitle) {
		this.txtTitle = txtTitle;
	}
	public JTextArea getTxtDescription() {
		return txtDescription;
	}
	public void setTxtDescription(JTextArea txtDescription) {
		this.txtDescription = txtDescription;
	}
	public JScrollPane getTxtDescriptionScroll() {
		return txtDescriptionScroll;
	}
	public void setTxtDescriptionScroll(JScrollPane txtDescriptionScroll) {
		this.txtDescriptionScroll = txtDescriptionScroll;
	}
	public JTextArea getTxtGenre() {
		return txtGenre;
	}
	public void setTxtGenre(JTextArea txtGenre) {
		this.txtGenre = txtGenre;
	}
	public JScrollPane getTxtGenreScroll() {
		return txtGenreScroll;
	}
	public void setTxtGenreScroll(JScrollPane txtGenreScroll) {
		this.txtGenreScroll = txtGenreScroll;
	}
	public JTextArea getTxtCast() {
		return txtCast;
	}
	public void setTxtCast(JTextArea txtCast) {
		this.txtCast = txtCast;
	}
	public JScrollPane getTxtCastScroll() {
		return txtCastScroll;
	}
	public void setTxtCastScroll(JScrollPane txtCastScroll) {
		this.txtCastScroll = txtCastScroll;
	}
	public JSpinner getTxtYear() {
		return txtYear;
	}
	public void setTxtYear(JSpinner txtYear) {
		this.txtYear = txtYear;
	}
	public JTextField getTxtDirector() {
		return txtDirector;
	}
	public void setTxtDirector(JTextField txtDirector) {
		this.txtDirector = txtDirector;
	}
	private JTextField txtTitle;
	//private JTextPane txtDescription = new JTextPane();
	private JTextArea txtDescription = new JTextArea();
	private JScrollPane txtDescriptionScroll = new JScrollPane (txtDescription, 
			   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	private JTextArea txtGenre = new JTextArea();
	private JScrollPane txtGenreScroll = new JScrollPane (txtGenre, 
			   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	private JTextArea txtCast = new JTextArea();
	private JScrollPane txtCastScroll = new JScrollPane (txtCast, 
			   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	private JSpinner txtYear;
	private JTextField txtDirector = new JTextField();
	private JCheckBox chckbxTvSeries = new JCheckBox("");
	public JCheckBox getChckbxTvSeries() {
		return chckbxTvSeries;
	}
	public void setChckbxTvSeries(JCheckBox chckbxTvSeries) {
		this.chckbxTvSeries = chckbxTvSeries;
	}
	private final JLabel lblTvSeries = new JLabel("Tv Series:");
	private JButton btnSave = new JButton("Save");
	public JButton getBtnSave() {
		return btnSave;
	}
	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public AddNewItemView(String title) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 600);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitle.setBounds(10, 26, 82, 27);
		frame.getContentPane().add(lblTitle);
		
		
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescription.setBounds(10, 74, 82, 27);
		frame.getContentPane().add(lblDescription);
		
		
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYear.setBounds(10, 187, 82, 27);
		frame.getContentPane().add(lblYear);
		
		
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenre.setBounds(10, 248, 82, 27);
		frame.getContentPane().add(lblGenre);
		
		lblDirector= new JLabel("Director");
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDirector.setBounds(10, 349, 82, 27);
		frame.getContentPane().add(lblDirector);
		
		
		lblCast.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCast.setBounds(10, 415, 82, 27);
		frame.getContentPane().add(lblCast);

		
		txtTitle = new JTextField();
		txtTitle.setBounds(134, 31, 240, 20);
		frame.getContentPane().add(txtTitle);
		txtTitle.setColumns(10);
		frame.setVisible(true);
		
		txtDescriptionScroll.setBounds(134, 76, 240, 67);
		frame.getContentPane().add(txtDescriptionScroll);
		frame.setVisible(true);
		
				
		txtYear = new JSpinner();
		txtYear.setBounds(134, 192, 239, 20);
		frame.getContentPane().add(txtYear);
		
		txtGenreScroll.setBounds(134, 250, 240, 67);
		frame.getContentPane().add(txtGenreScroll);
		frame.setVisible(true);
		
		txtDirector.setColumns(10);
		txtDirector.setBounds(134, 354, 240, 20);
		
		frame.getContentPane().add(txtDirector);
		frame.setVisible(true);
		
		txtCastScroll.setBounds(134, 417, 240, 67);
		frame.getContentPane().add(txtCastScroll);
		
		
		chckbxTvSeries.setBounds(62, 527, 32, 23);
		
		frame.getContentPane().add(chckbxTvSeries);
		lblTvSeries.setBounds(10, 524, 64, 26);
		
		frame.getContentPane().add(lblTvSeries);
		
		
		btnSave.setBounds(285, 527, 89, 23);
		frame.getContentPane().add(btnSave);
		frame.setVisible(true);
				
	}
}