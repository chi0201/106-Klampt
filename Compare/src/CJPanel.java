

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CJPanel extends JPanel {

	public double Pi = Math.PI;
	
	private int tab;
	private ArrayList<JLabel> label;
	private ArrayList<JTextField> text;
	
	private JPanel panel;
	
	
	public CJPanel( int _x, ArrayList<JLabel> _label, ArrayList<JTextField> _text, JPanel _panel  ) {
		tab = _x;
		label = _label;
		text = _text;
		panel = _panel;
		label.clear();
		panel.setLayout(null);
		AddLabel( );
		AddText();
	} //CJPanel
	
	private void AddLabel( ) {
		CJLabel label_1 = null;
		if ( tab == 1 ) label_1 = new CJLabel( 0, 7, 10, 40, 30, 145, panel, label );
		else if( tab == 2 ) label_1 = new CJLabel( 8, 13, 10, 40, 30, 145, panel, label );
		else if( tab == 3 ) label_1 = new CJLabel( 14, 28, 10, 40, 30, 145, panel, label );
		else if( tab == 4 ) label_1 = new CJLabel( 29, 34, 10, 40, 30, 145, panel, label );
		else if( tab == 5 ) label_1 = new CJLabel( 35, 49, 10, 40, 30, 145, panel, label );
		else if( tab == 6 ) label_1 = new CJLabel( 50, 56, 10, 40, 30, 145, panel, label );
		else if( tab == 7 ) label_1 = new CJLabel( 57, 62, 10, 40, 30, 145, panel, label );		
	} // AddLabel()
	
	private void AddText() {
		CJText text_1 = null;
		if ( tab == 1 ) text_1 = new CJText( 8, 160, 40, 30, 100, panel, text);
		else if( tab == 2 ) text_1 = new CJText( 6, 160, 40, 30, 100, panel, text);
		else if( tab == 3 ) text_1 = new CJText( 15, 160, 40, 30, 100, panel, text);
		else if( tab == 4 ) text_1 = new CJText( 6, 160, 40, 30, 100, panel, text);
		else if( tab == 5 ) text_1 = new CJText( 15, 160, 40, 30, 100, panel, text);
		else if( tab == 6 ) text_1 = new CJText( 7, 160, 40, 30, 100, panel, text);
		else if( tab == 7 ) text_1 = new CJText( 6, 160, 40, 30, 100, panel, text);
	} // AddText
			
	public void SetText( int head, int end, ArrayList<ArrayList<String>> _data, int file, ArrayList<JTextField> text, int num ) {
		int j = num ;
		float degree = 0 ;
		for( int i = head ; i <= end ; i++ ) {
			text.get( j ).setText( _data.get(file).get( i ) );
			j++;
			degree = (Integer) Math.round( Float.parseFloat( _data.get(file).get(i) ) / (float) Pi * 180 );
			text.get( j ).setText( String.valueOf( degree ) );
			j = j + 5;
		} // for
	} // SetText()
	
	private float Optimize( String data, int num ) {
		float degree = 0;
		float max = Max( num );
		float min = Min( num );
		float num_target = Float.parseFloat( data );
		if( num_target > 0 ) {
			for( degree = 0 ; degree < 180 ; degree++ ) {
				float num_small = degree * (float) Pi / 180 ;
				float num_big = ( degree + 1 ) * (float) Pi / 180 ;
				if( num_big >= max ) num_big = max;
				if( num_small <= num_target && num_big >= num_target ) {
					float close_min = num_target - num_small;
					float close_max = num_big - num_target;
					if( close_min > close_max ) return ++degree;
					else return degree;
				} // if
			} // for
		} // if
		else {
			for( degree = 0 ; degree > -180 ; degree-- ) {
				float num_big = degree * (float) Pi / 180;
				float num_small = ( degree - 1) * (float) Pi / 180;
				if( num_big <= min ) num_big = min;
				if( num_small <= num_target && num_big >= num_target ) {
					float close_min = num_target - num_small;
					float close_max = num_big - num_target;
					if( close_min > close_max ) return degree;
					else return --degree;
				} // if
			} // for
		} // else
		return 0;
	} // Optimize
	
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
	
	public void DeleteText( ArrayList<JTextField> text ) {
		for( int i = 0 ; i < text.size(); i++ ) {
			text.get(i).setText( null );
		} // for
	} // DeleteText()
	
	
}
