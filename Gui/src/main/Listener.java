package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

public class Listener implements ActionListener{
	
	public double Pi = Math.PI;
	private JTextField text ;
	private JTextField Dtext;
	private String symbol;
	
	public Listener( JTextField _text, JTextField text_degree, String _symbol ) {
		text = _text;
		Dtext = text_degree;
		symbol = _symbol;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if( symbol.equals( "+" ) ) {
			String target = Dtext.getText();
			float degree = Float.parseFloat( target );
			degree = (float) (degree + 0.5);
			float num = degree * (float) Pi / 180;
			if ( 0.00001 > num && num > -0.00001 ) num = 0;
			Dtext.setText( String.valueOf( degree ) );
			text.setText( String.valueOf( num ) );
		} // if
		else if( symbol.equals( "-" ) ) {
			String target = Dtext.getText();
			float degree = Float.parseFloat( target );
			degree = (float) (degree - 0.5);
			float num = degree * (float) Pi / 180;
			if ( 0.00001 > num && num > -0.00001 ) num = 0;
			Dtext.setText( String.valueOf( degree ) );
			text.setText( String.valueOf( num ) );
		} // else if
	} // actionPerformed()

	private float Max( int num ) {
		// head
		if( num == 6 || num == 7 ) return (float) 0.523599;
		// left hand
		else if ( num == 8 ) return (float) 3.14158;
		else if ( num == 9 ) return (float) 3.14158;
		else if ( num == 10 ) return (float) 3.14158;
		else if ( num == 11 ) return (float) 0.0698132;
		else if ( num == 12 ) return (float) 3.14158;
		else if ( num == 13 ) return (float) 1.01229;
		// left fingers
		else if ( num == 14 || num == 17 || num == 20 || num == 23 || num == 26 ) return (float) 0;
		else if ( num == 15 || num == 16 || num == 18 || num == 19 || num == 21 ) return (float) 1;
		else if ( num == 22 || num == 24 || num == 25 || num == 27 || num == 28 ) return (float) 1;
		// right hand
		else if ( num == 29 ) return (float) 3.14158;
		else if ( num == 30 ) return (float) 0;
		else if ( num == 31 ) return (float) 3.14158;
		else if ( num == 32 ) return (float) 0.0698132;
		else if ( num == 33 ) return (float) 3.14158;
		else if ( num == 34 ) return (float) 1.01229;
		// right fingers
		else if ( num == 35 || num == 38 || num == 41 || num == 44 || num == 47 ) return (float) 0;
		else if ( num == 36 || num == 37 || num == 39 || num == 40 || num == 42 ) return (float) 1;
		else if ( num == 43 || num == 45 || num == 46 || num == 48 || num == 49) return (float) 1;
		else if ( num == 50 ) return (float) 3.14158;
		// legs
		else if ( num == 51 || num == 57 ) return (float) 1.5708;
		else if ( num == 52 || num == 58 ) return (float) 0.488692;
		else if ( num == 53 || num == 59 ) return (float) 1.6057;
		else if ( num == 54 || num == 60 ) return (float) 2.60054;
		else if ( num == 55 || num == 61 ) return (float) 1.69297;
		else if ( num == 56 || num == 62 ) return (float) 0.191986;
		else return 0;
	} // Max
	
	private float Min( int num ) {
		// head
		if( num == 6 || num == 7 ) return (float) -0.523599;
		// left hand
		else if ( num == 8 ) return (float) -3.14158;
		else if ( num == 9 ) return (float) 0;
		else if ( num == 10 ) return (float) -3.14158;
		else if ( num == 11 ) return (float) -2.49582;
		else if ( num == 12 ) return (float) -3.14158;
		else if ( num == 13 ) return (float) 1.64061;
		// left fingers
		else if ( num == 14 || num == 17 || num == 20 || num == 23 || num == 26 ) return (float) -2;
		else if ( num == 15 || num == 16 || num == 18 || num == 19 || num == 21) return (float) 0;
		else if ( num == 22 || num == 24 || num == 25 || num == 27 || num == 28 ) return (float) 0;
		// right hand
		else if ( num == 29 ) return (float) -3.14158;
		else if ( num == 30 ) return (float) -3.14158;
		else if ( num == 31 ) return (float) -3.14158;
		else if ( num == 32 ) return (float) -2.49582;
		else if ( num == 33 ) return (float) -3.14158;
		else if ( num == 34 ) return (float) -1.64061;
		// right fingers
		else if ( num == 35 || num == 38 || num == 41 || num == 44 || num == 47 ) return (float) -2;
		else if ( num == 36 || num == 37 || num == 39 || num == 40 || num == 42 ) return (float) 0;
		else if ( num == 43 || num == 45 || num == 46 || num == 48 || num == 49 ) return (float) 0;
		else if ( num == 50 ) return (float) -3.14158;
		// legs
		else if ( num == 51 || num == 57 ) return (float) -1.5708;
		else if ( num == 52 || num == 58 ) return (float) -0.488692;
		else if ( num == 53 || num == 59 ) return (float) -1.48353;
		else if ( num == 54 || num == 60 ) return (float) -0.0698132;
		else if ( num == 55 || num == 61 ) return (float) -1.29154;
		else if ( num == 56 || num == 62 ) return (float) -0.191986;
		else return 0;
	} // Min
	
}
