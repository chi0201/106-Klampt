import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
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
		Filedata file = null;
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		ArrayList<String> filename = new ArrayList<String>();
		
		frame = new JFrame("Klampt System");
		//1200 800
		frame.setBounds(100, 100, 1200, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 100, 1000, 530);
		frame.getContentPane().add(tabbedPane);
				
		JPanel panel_1 = new JPanel();
		CJPanel cpanel_1 = new CJPanel( 1, label, text_1, panel_1 );
		tabbedPane.addTab("機器人&頭", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		CJPanel cpanel_2 = new CJPanel( 2, label, text_2, panel_2 );
		tabbedPane.addTab("左手", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		CJPanel cpanel_3 = new CJPanel( 3, label, text_3, panel_3 );
		tabbedPane.addTab("左手指", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		CJPanel cpanel_4 = new CJPanel( 4, label, text_4, panel_4 );
		tabbedPane.addTab("右手", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		CJPanel cpanel_5 = new CJPanel( 5, label, text_5, panel_5 );
		tabbedPane.addTab("右手指", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		CJPanel cpanel_6 = new CJPanel( 6, label, text_6, panel_6 );
		tabbedPane.addTab("腰&左腳", null, panel_6, null);
		
		JPanel panel_7 = new JPanel();
		CJPanel cpanel_7 = new CJPanel( 7, label, text_7, panel_7 );
		tabbedPane.addTab("右腳", null, panel_7, null);
	 
		JComboBox cBox_File = new JComboBox();
		JComboBox cBox_File1 = new JComboBox();
		JComboBox cBox_File2 = new JComboBox();
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
					if( !same ) {
						cBox_File.addItem( fileChooser.getSelectedFile().getName() );  //儲存檔名
						cBox_File1.addItem( fileChooser.getSelectedFile().getName() );
						cBox_File2.addItem( fileChooser.getSelectedFile().getName() );
					} // if
					cBox_File.setSelectedItem( fileChooser.getSelectedFile().getName() );
				} // if 
			} // actionPerformed	
		});
		btnNewButton.setFont(new Font("標楷體", Font.BOLD, 20));
		frame.getContentPane().add(btnNewButton);
		
		cBox_File.setBounds(240, 10, 150, 30);
		cBox_File.setFont(new Font("標楷體", Font.PLAIN, 14));
		cBox_File.addItemListener((ItemListener) new ItemListener() {
			public void itemStateChanged( ItemEvent arg0 ) {
				for( int i = 0 ; i < filename.size(); i++ ) {
					if( filename.get(i).equals( (String) arg0.getItem() ) ) {
						cpanel_1.SetText( 0, 7, data, i, text_1, 0 );
						cpanel_2.SetText( 8, 13, data, i, text_2, 0 );
						cpanel_3.SetText( 14, 28, data, i, text_3, 0 );
						cpanel_4.SetText( 29, 34, data, i, text_4, 0 );
						cpanel_5.SetText( 35, 49, data, i, text_5, 0 );
						cpanel_6.SetText( 50, 56, data, i, text_6, 0 );
						cpanel_7.SetText( 57, 62, data, i, text_7, 0 );
					} // if
				} // for
			}
		});
		frame.getContentPane().add(cBox_File);
		
		cBox_File1.setBounds(395, 10, 150, 30);
		cBox_File1.setFont(new Font("標楷體", Font.PLAIN, 14));
		cBox_File1.addItemListener((ItemListener) new ItemListener() {
			public void itemStateChanged( ItemEvent arg0 ) {
				for( int i = 0 ; i < filename.size(); i++ ) {
					if( filename.get(i).equals( (String) arg0.getItem() ) ) {
						cpanel_1.SetText( 0, 7, data, i, text_1, 2 );
						cpanel_2.SetText( 8, 13, data, i, text_2, 2 );
						cpanel_3.SetText( 14, 28, data, i, text_3, 2 );
						cpanel_4.SetText( 29, 34, data, i, text_4, 2 );
						cpanel_5.SetText( 35, 49, data, i, text_5, 2 );
						cpanel_6.SetText( 50, 56, data, i, text_6, 2 );
						cpanel_7.SetText( 57, 62, data, i, text_7, 2 );
					} // if
				} // for
			}
		});
		frame.getContentPane().add(cBox_File1);
		
		cBox_File2.setBounds(550, 10, 150, 30);
		cBox_File2.setFont(new Font("標楷體", Font.PLAIN, 14));
		cBox_File2.addItemListener((ItemListener) new ItemListener() {
			public void itemStateChanged( ItemEvent arg0 ) {
				for( int i = 0 ; i < filename.size(); i++ ) {
					if( filename.get(i).equals( (String) arg0.getItem() ) ) {
						cpanel_1.SetText( 0, 7, data, i, text_1, 4 );
						cpanel_2.SetText( 8, 13, data, i, text_2, 4 );
						cpanel_3.SetText( 14, 28, data, i, text_3, 4 );
						cpanel_4.SetText( 29, 34, data, i, text_4, 4 );
						cpanel_5.SetText( 35, 49, data, i, text_5, 4 );
						cpanel_6.SetText( 50, 56, data, i, text_6, 4 );
						cpanel_7.SetText( 57, 62, data, i, text_7, 4 );
					} // if
				} // for
			}
		});
		frame.getContentPane().add(cBox_File2);
		
		
		JButton bdelete = new JButton("Remove");
		bdelete.setBounds(705, 10, 100, 30);
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
	}
}
