

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
			lab.setFont(new Font("�з���", Font.BOLD, 16));
			_label.add( lab );
		} // for
		SetBounds( );
		Add();
	} // CJLabel
	
	private void Init() {
		JLabel lab = new JLabel( "Link" );
		lab.setBounds( x, y-30, longs, weight );
		lab.setHorizontalAlignment(SwingConstants.CENTER);
		lab.setFont(new Font("�з���", Font.BOLD, 16));
		panel.add(lab);	
		JLabel flab = new JLabel( "First" );
		flab.setBounds(x+150, y-30, 100, 30);
		flab.setHorizontalAlignment(SwingConstants.CENTER);
		flab.setFont(new Font("�з���", Font.BOLD, 16));
		panel.add(flab);
		JLabel slab = new JLabel( "Second" );
		slab.setBounds(x+310, y-30, 100, 30);
		slab.setHorizontalAlignment(SwingConstants.CENTER);
		slab.setFont(new Font("�з���", Font.BOLD, 16));
		panel.add(slab);		
		JLabel tlab = new JLabel( "Third" );
		tlab.setBounds(x+470, y-30, 100, 30);
		tlab.setHorizontalAlignment(SwingConstants.CENTER);
		tlab.setFont(new Font("�з���", Font.BOLD, 16));
		panel.add(tlab);	
	} // Init()
	
	private void SetBounds( ) {
		for( int i = 0 ; i < label.size() ; i++ ) {
			label.get( i ).setBounds( x, y, longs, weight );
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
		else if( i == 6 ) return "06-X-�Y";
		else if( i == 7 ) return "07-Y-�Y";
		else if( i == 8 ) return "08-Y-���ӻH";
		else if( i == 9 ) return "09-X-���ӻH";
		else if( i == 10 ) return "10-Z-Body_LSY";
		else if( i == 11 ) return "11-Y-����y";
		else if( i == 12 ) return "12-Z-Body_LWY";
		else if( i == 13 ) return "13-Y-�����";
		else if( i == 14 ) return "14-X-�������";
		else if( i == 15 ) return "15-X-��������q";
		else if( i == 16 ) return "16-X-���������";
		else if( i == 17 ) return "17-X-���p����";
		else if( i == 18 ) return "18-X-���p�����q";
		else if( i == 19 ) return "19-X-���p������";
		else if( i == 20 ) return "20-X-���L�W����";
		else if( i == 21 ) return "21-X-���L�W�����q";
		else if( i == 22 ) return "22-X-���L�W������";
		else if( i == 23 ) return "23-X-��������";
		else if( i == 24 ) return "24-X-���������q";
		else if( i == 25 ) return "25-X-����������";
		else if( i == 26 ) return "26-X-��������";
		else if( i == 27 ) return "27-X-���������q";
		else if( i == 28 ) return "28-X-����������";
		else if( i == 29 ) return "29-Y-�k�ӻH";
		else if( i == 30 ) return "30-X-�k�ӻH";
		else if( i == 31 ) return "31-Z-Body_RSY";
		else if( i == 32 ) return "32-Y-�k��y";
		else if( i == 33 ) return "33-Z-Body_RWY";
		else if( i == 34 ) return "34-Y-�k���";
		else if( i == 35 ) return "35-X-�k�����";
		else if( i == 36 ) return "36-X-�k������q";
		else if( i == 37 ) return "37-X-�k�������";
		else if( i == 38 ) return "38-X-�k�p����";
		else if( i == 39 ) return "39-X-�k�p�����q";
		else if( i == 40 ) return "40-X-�k�p������";
		else if( i == 41 ) return "41-X-�k�L�W����";
		else if( i == 42 ) return "42-X-�k�L�W�����q";
		else if( i == 43 ) return "43-X-�k�L�W������";
		else if( i == 44 ) return "44-X-�k������";
		else if( i == 45 ) return "45-X-�k�������q";
		else if( i == 46 ) return "46-X-�k��������";
		else if( i == 47 ) return "47-X-�k������";
		else if( i == 48 ) return "48-X-�k�������q";
		else if( i == 49 ) return "49-X-�k��������";
		else if( i == 50 ) return "50-Z-�y";
		else if( i == 51 ) return "51-Z-�b���`";
		else if( i == 52 ) return "52-X-�b���`";
		else if( i == 53 ) return "53-Y-���j�L";
		else if( i == 54 ) return "54-Y-���p�L";
		else if( i == 55 ) return "55-Y-���}��";
		else if( i == 56 ) return "56-X-���}��";
		else if( i == 57 ) return "57-Z-�b���`";
		else if( i == 58 ) return "58-X-�b���`";
		else if( i == 59 ) return "59-Y-�k�j�L";
		else if( i == 60 ) return "60-Y-�k�p�L";
		else if( i == 61 ) return "61-Y-�k�}��";
		else if( i == 62 ) return "62-X-�k�}��";
		else return "0" ;
	} // Name()
	
	private void Add() {
		for( int i = 0 ; i < label.size() ; i++ ) 
			panel.add( label.get( i ) );
	} // Add()
	
} //CJLabel

