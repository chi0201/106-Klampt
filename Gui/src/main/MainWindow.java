package main;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;

//+-1時  text要檢查是否在最大最小的範圍內

public class MainWindow {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ArrayList<JLabel> label = new ArrayList<JLabel>(); 
		ArrayList<JTextField> text_1 = new ArrayList<JTextField>();
		ArrayList<JTextField> text_2 = new ArrayList<JTextField>();
		ArrayList<JTextField> text_3 = new ArrayList<JTextField>();
		ArrayList<JTextField> text_4 = new ArrayList<JTextField>();
		ArrayList<JTextField> text_5 = new ArrayList<JTextField>();
		ArrayList<JTextField> text_6 = new ArrayList<JTextField>();
		ArrayList<JTextField> text_7 = new ArrayList<JTextField>();
		ArrayList<JButton> button = new ArrayList<JButton>();
		Filedata file = null;
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		ArrayList<String> filename = new ArrayList<String>();
		
		frame = new JFrame("Klampt System");
		//1200 800
		frame.setBounds(100, 100, 1200, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 80, 1000, 530);
		frame.getContentPane().add(tabbedPane);
		JScrollPane scrollPane = new JScrollPane();	
				
		JPanel panel_1 = new JPanel();
		CJPanel cpanel_1 = new CJPanel( 1, label, text_1, button, panel_1 );
		tabbedPane.addTab("機器人&頭", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		CJPanel cpanel_2 = new CJPanel( 2, label, text_2, button, panel_2 );
		tabbedPane.addTab("左手", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		CJPanel cpanel_3 = new CJPanel( 3, label, text_3, button, panel_3 );
		tabbedPane.addTab("左手指", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		CJPanel cpanel_4 = new CJPanel( 4, label, text_4, button, panel_4 );
		tabbedPane.addTab("右手", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		CJPanel cpanel_5 = new CJPanel( 5, label, text_5, button, panel_5 );
		tabbedPane.addTab("右手指", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		CJPanel cpanel_6 = new CJPanel( 6, label, text_6, button, panel_6 );
		tabbedPane.addTab("腰&左腳", null, panel_6, null);
		
		JPanel panel_7 = new JPanel();
		CJPanel cpanel_7 = new CJPanel( 7, label, text_7, button, panel_7 );
		tabbedPane.addTab("右腳", null, panel_7, null);
	 
		JComboBox cBox_File = new JComboBox();
		JButton btnNewButton = new JButton("Choose File");
		btnNewButton.setBounds(50, 10, 170, 30);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();          //宣告filechooser 
				int returnValue = fileChooser.showOpenDialog(null);     //叫出filechooser 
				if (returnValue == JFileChooser.APPROVE_OPTION) {   //判斷是否選擇檔案
					filename.add( fileChooser.getSelectedFile().getName() );
					Filedata file = new Filedata( fileChooser.getSelectedFile().getAbsolutePath(), data );
					boolean same = false;
						for( int i = 0 ; cBox_File.isShowing() && i < cBox_File.getItemCount() ; i++ ) 
							if( fileChooser.getSelectedFile().getName().equals( cBox_File.getItemAt(i).toString() ) ) same = true;
					if( !same ) cBox_File.addItem( fileChooser.getSelectedFile().getName() );  //儲存檔名
					cBox_File.setSelectedItem( fileChooser.getSelectedFile().getName() );
				} // if 
			} // actionPerformed	
		});
		btnNewButton.setFont(new Font("標楷體", Font.BOLD, 20));
		frame.getContentPane().add(btnNewButton);
		
		cBox_File.setBounds(240, 10, 200, 30);
		cBox_File.setFont(new Font("標楷體", Font.PLAIN, 20));
		cBox_File.addItemListener((ItemListener) new ItemListener() {
			public void itemStateChanged( ItemEvent arg0 ) {
				for( int i = 0 ; i < filename.size(); i++ ) {
					if( filename.get(i).equals( (String) arg0.getItem() ) ) {
						cpanel_1.SetText( 0, 7, data, i, text_1 );
						cpanel_2.SetText( 8, 13, data, i, text_2 );
						cpanel_3.SetText( 14, 28, data, i, text_3 );
						cpanel_4.SetText( 29, 34, data, i, text_4 );
						cpanel_5.SetText( 35, 49, data, i, text_5 );
						cpanel_6.SetText( 50, 56, data, i, text_6 );
						cpanel_7.SetText( 57, 62, data, i, text_7 );
					} // if
				} // for
				
			}
		});
		frame.getContentPane().add(cBox_File);
		
		
		JButton bdelete = new JButton("Remove");
		bdelete.setBounds(460, 10, 100, 30);
		bdelete.setForeground(Color.RED);
		bdelete.setFont(new Font("標楷體", Font.BOLD, 16));
		bdelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cBox_File.removeItem( cBox_File.getSelectedItem());
				if( cBox_File.getSelectedItem() == null ) {
					cpanel_1.DeleteText( text_1 );
					cpanel_2.DeleteText( text_2 );
					cpanel_3.DeleteText( text_3 );
					cpanel_4.DeleteText( text_4 );
					cpanel_5.DeleteText( text_5 );
					cpanel_6.DeleteText( text_6 );
					cpanel_7.DeleteText( text_7 );
				} // if
			} 
		});
		frame.getContentPane().add(bdelete);
		
		JButton boutput = new JButton("All Out");
		boutput.setBounds(570, 10, 100, 30);
		boutput.setForeground(Color.RED);
		boutput.setFont(new Font("標楷體", Font.BOLD, 16));
		boutput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		frame.getContentPane().add(boutput);
		
		JButton btnNewButton_1 = new JButton("sure");
		btnNewButton_1.setFont(new Font("標楷體", Font.BOLD, 20));
		btnNewButton_1.setBounds(420, 620, 85, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String file_name = "C_" + cBox_File.getSelectedItem().toString();
				FileWriter fw;
				try {
					fw = new FileWriter( file_name, false);
					fw.write( "63" );
					fw.write( cpanel_1.GetText() );
					fw.write( cpanel_2.GetText() );
					fw.write( cpanel_3.GetText() );
					fw.write( cpanel_4.GetText() );
					fw.write( cpanel_5.GetText() );
					fw.write( cpanel_6.GetText() );
					fw.write( cpanel_7.GetText() );
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnNewButton_1);
	}
}
