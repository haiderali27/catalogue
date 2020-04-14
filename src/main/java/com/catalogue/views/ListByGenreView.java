package com.catalogue.views;


import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class ListByGenreView {
	// View uses Swing framework to display UI to user
	private JPanel container;
	public JPanel getContainer() {
		return container;
	}
	public void setContainer(JPanel container) {
		this.container = container;
	}
	public JScrollPane getJsp() {
		return jsp;
	}
	public void setJsp(JScrollPane jsp) {
		this.jsp = jsp;
	}
	private JScrollPane jsp;
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

	public ListByGenreView(String title) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(450, 400);
		frame.setLocationRelativeTo(null);

		/*
		 * frame.setLocationRelativeTo(null); frame.getContentPane().setLayout(null);
		 */

		container = new JPanel();
		jsp = new JScrollPane(container);
		container.setPreferredSize(new Dimension(416, 400));
		container.setLayout(null);
		frame.getContentPane().add(jsp);

		/*
		 * lblYear[0].setFont(new Font("Tahoma", Font.PLAIN, 15));
		 * lblYear[0].setBounds(10, 30, 81, 14); frame.getContentPane().add(lblYear[0]);
		 */
		frame.setVisible(true);	}
	public JFrame getFrame() {
		return frame;
	}

}