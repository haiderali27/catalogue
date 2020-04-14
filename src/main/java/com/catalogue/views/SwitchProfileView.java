package com.catalogue.views;

import javax.swing.JFrame;
import java.awt.Button;




public class SwitchProfileView {
 // View uses Swing framework to display UI to user
 private JFrame frame;
 public JFrame getFrame() {
	return frame;
}

public void setFrame(JFrame frame) {
	this.frame = frame;
}

public Button[] getButton() {
	return button;
}

public void setButton(Button[] button) {
	this.button = button;
}

Button[] button = new Button[4];

 public SwitchProfileView(String title) {
  frame = new JFrame(title);
  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  frame.setSize(250, 290);
  frame.setLocationRelativeTo(null);
  frame.getContentPane().setLayout(null);
  int loc=20;
  for(int i=0;i<4;i++) {
	  button[i] = new Button("dummy");
	  button[i].setBounds(41, loc, 149, 36);
	  frame.getContentPane().add(button[i]);
	  frame.setVisible(true);
	  loc+=60;
  }
 }
}