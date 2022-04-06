package main;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CJText extends JTextField{

	private int weight;
	private int longs;
	private int x;
	private int y;
	private JPanel panel;
	private ArrayList<JTextField> text = new ArrayList<JTextField>();
	
	public CJText( int num, int _x, int _y, int _weight, int _longs, JPanel _panel, ArrayList<JTextField> text2) {
		super();
		x = _x;
		y = _y;
		weight = _weight;
		longs = _longs;
		panel = _panel;
		text = text2;
		for( int i = 0 ; i < num * 4 ; i++ ) {
			JTextField tex = new JTextField();
			tex.setFont(new Font("¼Ð·¢Åé", Font.PLAIN, 16));
			tex.setEditable(false);
			text2.add( tex );
		} // for
		SetBounds();
		Add();
	} // CJText
	
	private void SetBounds( ) {
		for( int i = 0 ; i < text.size() ; i++ ) {
			if( i % 4 == 0 ) text.get( i ).setBounds( x, y, longs, weight );
			else if( i % 4 == 1 ) text.get( i ).setBounds( x + 105, y, 50, weight );
			else if( i % 4 == 2 ) text.get( i ).setBounds( x + 160, y, longs, weight );
			else {
				text.get( i ).setBounds( x + 265, y, 50, weight );
				y = y + 30;
			} // else
		} // for
	} // SetBounds
		
	private void Add() {
		for( int i = 0 ; i < text.size() ; i++ ) 
			panel.add( text.get( i ) );
	} // Add()
	
} // CJText
