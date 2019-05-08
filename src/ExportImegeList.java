import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExportImegeList {
	public static String filePath;
	
	public static void Export() throws IOException {
	    try{
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
	    	writer.write("Samo Save1");
		    writer.close();
	    }
	    catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e, "File error", JOptionPane.WARNING_MESSAGE);
		}
	    
	}
	
	public static void Export(String filePath) throws IOException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
	    writer.write("U¿yta zosta³a funkcja Save As");
	    writer.newLine();
	    writer.write("U¿yta zosta³a funkcja Save As2");
	    writer.close();
	}
}
