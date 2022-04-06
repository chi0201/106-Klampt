package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CJButton extends JButton {
	
	public double Pi = Math.PI;
	private int weight;
	private int longs;
	private int x;
	private int y;
	private JPanel panel;
	private ArrayList<JButton> button = new ArrayList<JButton>();
	private ArrayList<JTextField> text = new ArrayList<JTextField>();
	private int size;

	public CJButton ( int num, int _x, int _y, int _weight, int _longs, JPanel _panel, ArrayList<JButton> _button, ArrayList<JTextField> _text ) {
		super();
		x = _x;
		y = _y;
		weight = _weight;
		longs = _longs;
		panel = _panel;
		button = _button;
		text = _text;
		for( int i = 0 ; i < num ; i++ ) {
			JButton button1 = new JButton( "-0.5" );
			button1.setFont(new Font("標楷體", Font.BOLD, 14));
			JButton button2 = new JButton( "+0.5" );
			button2.setFont(new Font("標楷體", Font.BOLD, 14));
			button.add( button1 );
			button.add( button2 );
		} // for
		SetBounds();
		Add();
	} // CJText
	
	private void SetBounds( ) {
		for( int i = 0 ; i < button.size() ; i++ ) {
			if( i % 2 == 0 ) button.get( i ).setBounds( x, y, longs, weight );
			else {
				button.get( i ).setBounds( x + 75, y, longs, weight );
				y = y + 30;
			} // else
		} // for
	} // SetBounds
	
	
	private void Add() {
		for( int i = 0 ; i < button.size() ; i++ ) 
			panel.add( button.get( i ) );
	} // Add()
}
