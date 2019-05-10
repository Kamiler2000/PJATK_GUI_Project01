import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//=========================================================================================
//This class imports Image.imageList to file===============================================
//=========================================================================================

public class ImportImageList {
	public static String path;
	
	public static void Import(String path) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		try {
			Image im = new Image(path);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e, "File error", JOptionPane.WARNING_MESSAGE);
		}
	}
}
