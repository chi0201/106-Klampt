

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Filedata {
	
	public ArrayList<ArrayList<String>> dataList ;
	public String filename ;
	
	
	
	public Filedata( String _filename, ArrayList<ArrayList<String>> _data ) {
		this.filename = _filename;
		this.dataList = _data;
		GetFiledata();
	} // Filedata	
	
	private void GetFiledata() {
		File file = new File( filename );
		ArrayList<String> data = new ArrayList<String>() ;
		BufferedReader br;
		char c[] = null;
		String line = null;
		String temp = null;
		try {
			boolean first = true;
			br = new BufferedReader( new FileReader( file.getPath() ) );
			while( ( line = br.readLine() ) != null ) {
				c = line.toCharArray();
				for( int i = 0 ; i < line.length() ; i++ ) {
					temp = "";
					while( i < line.length() && c[i] != ' ' && c[i] != '\t' ) {
						temp = temp + c[i]; 
						i++;
					} // while
					if( temp != "" && !first ) data.add(temp);
					else first = false;
				} // for

			} // while
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // catch
		
		dataList.add(data);
	} // GetFiledata
	

}
