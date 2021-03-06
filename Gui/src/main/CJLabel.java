package main;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CJLabel extends JLabel{

	private int weight;
	private int longs;
	private int x;
	private int y;
	private JPanel panel;
	private ArrayList<JLabel> label = new ArrayList<JLabel>();
	private int size;
	
	
	public CJLabel ( int _head, int _end, int _x, int _y, int _weight, int _long, JPanel _panel, ArrayList<JLabel> _label ) {
		super();
		this.x = _x;
		this.y = _y;
		this.weight = _weight;
		this.longs = _long;
		this.panel = _panel;
		this.label = _label;
		this.size = _end - _head;
		Init();
		for( int i = _head ; i <= _end ; i++ ) {
			JLabel lab = new JLabel( Name( i ) );
			JLabel min = new JLabel( Min( i ) ) ;
			JLabel max = new JLabel( Max( i ) ) ;
			lab.setFont(new Font("標楷體", Font.BOLD, 16));
			min.setFont(new Font("標楷體", Font.BOLD, 16));
			max.setFont(new Font("標楷體", Font.BOLD, 16));
			_label.add( lab );
			_label.add( min );
			_label.add( max );
		} // for
		SetBounds( );
		Add();
	} // CJLabel
	
	private void Init() {
		JLabel lab = new JLabel( "Link" );
		lab.setBounds( x, y-30, longs, weight );
		lab.setHorizontalAlignment(SwingConstants.CENTER);
		lab.setFont(new Font("標楷體", Font.BOLD, 16));
		panel.add(lab);
		JLabel olab = new JLabel( "Original" );
		olab.setBounds(x+150, y-30, 100, 30);
		olab.setHorizontalAlignment(SwingConstants.CENTER);
		olab.setFont(new Font("標楷體", Font.BOLD, 16));
		panel.add(olab);
		JLabel clab = new JLabel( "New" );
		clab.setBounds(x+310, y-30, 100, 30);
		clab.setHorizontalAlignment(SwingConstants.CENTER);
		clab.setFont(new Font("標楷體", Font.BOLD, 16));
		panel.add(clab);		
	} // Init()
	
	private void SetBounds( ) {
		for( int i = 0 ; i < label.size() ; i++ ) {
			label.get( i ).setBounds( x, y, longs, weight );
			i++;
			label.get( i ).setBounds( x + 470, y, 150, 30 );
			label.get( i ).setHorizontalAlignment(SwingConstants.CENTER);
			i++;
			label.get( i ).setBounds( x + 775, y, 150, 30 );
			label.get( i ).setHorizontalAlignment(SwingConstants.CENTER);
			y = y + 30;
		} // for
	} // SetBounds
	
	private String Name( int i ) {
		if( i == 0 ) return "00-Body_Torso0";
		else if( i == 1 ) return "01-Body_Torso1";
		else if( i == 2 ) return "02-Body_Torso2";
		else if( i == 3 ) return "03-Body_Torso3";
		else if( i == 4 ) return "04-Body_Torso4";
		else if( i == 5 ) return "05-Body_Torso5";
		else if( i == 6 ) return "06-X-頭";
		else if( i == 7 ) return "07-Y-頭";
		else if( i == 8 ) return "08-Y-左肩膀";
		else if( i == 9 ) return "09-X-左肩膀";
		else if( i == 10 ) return "10-Z-Body_LSY";
		else if( i == 11 ) return "11-Y-左手肘";
		else if( i == 12 ) return "12-Z-Body_LWY";
		else if( i == 13 ) return "13-Y-左手腕";
		else if( i == 14 ) return "14-X-左拇指基部";
		else if( i == 15 ) return "15-X-左拇指中段";
		else if( i == 16 ) return "16-X-左拇指末端";
		else if( i == 17 ) return "17-X-左小指基部";
		else if( i == 18 ) return "18-X-左小指中段";
		else if( i == 19 ) return "19-X-左小指末端";
		else if( i == 20 ) return "20-X-左無名指基部";
		else if( i == 21 ) return "21-X-左無名指中段";
		else if( i == 22 ) return "22-X-左無名指末端";
		else if( i == 23 ) return "23-X-左中指基部";
		else if( i == 24 ) return "24-X-左中指中段";
		else if( i == 25 ) return "25-X-左中指末端";
		else if( i == 26 ) return "26-X-左食指基部";
		else if( i == 27 ) return "27-X-左食指中段";
		else if( i == 28 ) return "28-X-左食指末端";
		else if( i == 29 ) return "29-Y-右肩膀";
		else if( i == 30 ) return "30-X-右肩膀";
		else if( i == 31 ) return "31-Z-Body_RSY";
		else if( i == 32 ) return "32-Y-右手肘";
		else if( i == 33 ) return "33-Z-Body_RWY";
		else if( i == 34 ) return "34-Y-右手腕";
		else if( i == 35 ) return "35-X-右拇指基部";
		else if( i == 36 ) return "36-X-右拇指中段";
		else if( i == 37 ) return "37-X-右拇指末端";
		else if( i == 38 ) return "38-X-右小指基部";
		else if( i == 39 ) return "39-X-右小指中段";
		else if( i == 40 ) return "40-X-右小指末端";
		else if( i == 41 ) return "41-X-右無名指基部";
		else if( i == 42 ) return "42-X-右無名指中段";
		else if( i == 43 ) return "43-X-右無名指末端";
		else if( i == 44 ) return "44-X-右中指基部";
		else if( i == 45 ) return "45-X-右中指中段";
		else if( i == 46 ) return "46-X-右中指末端";
		else if( i == 47 ) return "47-X-右食指基部";
		else if( i == 48 ) return "48-X-右食指中段";
		else if( i == 49 ) return "49-X-右食指末端";
		else if( i == 50 ) return "50-Z-腰";
		else if( i == 51 ) return "51-Z-髖關節";
		else if( i == 52 ) return "52-X-髖關節";
		else if( i == 53 ) return "53-Y-左大腿";
		else if( i == 54 ) return "54-Y-左小腿";
		else if( i == 55 ) return "55-Y-左腳踝";
		else if( i == 56 ) return "56-X-左腳踝";
		else if( i == 57 ) return "57-Z-髖關節";
		else if( i == 58 ) return "58-X-髖關節";
		else if( i == 59 ) return "59-Y-右大腿";
		else if( i == 60 ) return "60-Y-右小腿";
		else if( i == 61 ) return "61-Y-右腳踝";
		else if( i == 62 ) return "62-X-右腳踝";
		else return "0" ;
	} // Name()
	
	private String Max( int i ) {
		if( i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 ) return "無限大";
		// left hand
		else if( i == 6 ) return "0.523599 (31度)";
		else if( i == 7 ) return "0.523599 (31度)";
		else if( i == 8 ) return "3.14158 (180度)";
		else if( i == 9 ) return "3.14158 (180度)";
		else if( i == 10 ) return "3.14158 (180度)";
		else if( i == 11 ) return "0.0698132 (5度)";
		else if( i == 12 ) return "3.14158 (180度)";
		else if( i == 13 ) return "1.01229  (59度)";
		// left fingers
		else if( i == 14 || i == 17 || i == 20 || i == 23 || i == 26 ) return "0         (0度)";
		else if( i == 15 || i == 16 || i == 18 || i == 19 || i == 21 ) return "1        (58度)";
		else if( i == 22 || i == 24 || i == 25 || i == 27 || i == 28 ) return "1        (58度)";
		// right hand
		else if( i == 29 ) return "3.14158 (180度)";
		else if( i == 30 ) return "0         (0度)";
		else if( i == 31 ) return "3.14158 (180度)";
		else if( i == 32 ) return "0.0698132 (5度)";
		else if( i == 33 ) return "3.14158 (180度)";
		else if( i == 34 ) return "1.01229  (59度)";
		// right fingers
		else if( i == 35 || i == 38 || i == 41 || i == 44 || i == 47 ) return "0         (0度)";
		else if( i == 36 || i == 37 || i == 39 || i == 40 || i == 42 ) return "1        (58度)";
		else if( i == 43 || i == 45 || i == 46 || i == 48 || i == 49 ) return "1        (58度)";
		else if( i == 50 ) return "3.14158 (180度)";
		// legs
		else if( i == 51 || i == 57 ) return "1.5708   (91度)";
		else if( i == 52 || i == 58 ) return "0.488692 (29度)";
		else if( i == 53 || i == 59 ) return "1.6057   (93度)";
		else if( i == 54 || i == 60 ) return "2.60054 (150度)";
		else if( i == 55 || i == 61 ) return "1.69297  (98度)";
		else if( i == 56 || i == 62 ) return "0.191986 (12度)";
		else return "0" ;
	} // Max()
	
	private String Min( int i ) {
		if( i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5) return "無限小";
		// head
		else if( i == 6 || i == 7 ) return "-0.523599 (-31度)";
		// left hand
		else if( i == 8 ) return "-3.14158 (-180度)";
		else if( i == 9 ) return "0           (0度)";
		else if( i == 10 ) return "-3.14158 (-180度)";
		else if( i == 11 ) return "-2.49582 (-144度)";
		else if( i == 12 ) return "-3.14158 (-180度)";
		else if( i == 13 ) return "-1.64061 (-105度)";
		// left fingers
		else if( i == 14 || i == 17 || i == 20 || i == 23 || i == 26 ) return "-2       (-115度)";
		else if( i == 15 || i == 16 || i == 18 || i == 19 || i == 21 ) return "0           (0度)";
		else if( i == 22 || i == 24 || i == 25 || i == 27 || i == 28 ) return "0           (0度)";
		// right hand
		else if( i == 29 ) return "-3.14158 (-180度)";
		else if( i == 30 ) return "-3.14158 (-180度)";
		else if( i == 31 ) return "-3.14158 (-180度)";
		else if( i == 32 ) return "-2.49582 (-144度)";
		else if( i == 33 ) return "-3.14158 (-180度)";
		else if( i == 34 ) return "-1.64061  (-95度)";
		// right fingers
		else if( i == 35 || i == 38 || i == 41 || i == 44 || i == 47 ) return "-2       (-115度)";
		else if( i == 36 || i == 37 || i == 39 || i == 40 || i == 42 ) return "0           (0度)";
		else if( i == 43 || i == 45 || i == 46 || i == 48 || i == 49 ) return "0           (0度)";
		else if( i == 50 ) return "-3.14158 (-180度)";
		// legs
		else if( i == 51 || i == 57 ) return "-1.5708   (-91度)";
		else if( i == 52 || i == 58 ) return "-0.488692 (-29度)";
		else if( i == 53 || i == 59 ) return "-1.48353  (-86度)";
		else if( i == 54 || i == 60 ) return "-0.0698132 (-5度)";
		else if( i == 55 || i == 61 ) return "-1.29154  (-75度)";
		else if( i == 56 || i == 62 ) return "-0.191986 (-12度)";
		else return "0" ;
	} // Min()
	
	private void Add() {
		for( int i = 0 ; i < label.size() ; i++ ) 
			panel.add( label.get( i ) );
	} // Add()
	
} //CJLabel

