package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class ButtonAction implements ActionListener {
	
	private JTextPane text ;
	private JComboBox comboBox;
	public ButtonAction( JTextPane t, JComboBox box ) {
		this.text = t ;
		this.comboBox = box;
	} // ButtonAction
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	} // actionPerformed()
}
