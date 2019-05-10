import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//=========================================================================================
//This class exports Image.imageList to file===============================================
//=========================================================================================

public class ExportImegeList {
	public static String filePath;
	
	public static void Export() throws IOException {
	    try{
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
	    	for(Image im : Image.getImagesList()) {
	    		writer.write(im.getPath() + ";");
	    		writer.write(im.getAuthor() + ";");
	    		writer.write(im.getLocation() + ";");
	    		writer.write(im.getDate() + ";");
	    		writer.write(im.getTag() + ";");
	    		writer.newLine();
	    	};
		    writer.close();
	    }
	    catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e, "File error", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void Export(String filePath) throws IOException {
	    try{
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
	    	for(Image im : Image.getImagesList()) {
	    		writer.write(im.getPath() + ";");
	    		writer.write(im.getAuthor() + ";");
	    		writer.write(im.getLocation() + ";");
	    		writer.write(im.getDate() + ";");
	    		writer.write(im.getTag() + ";");
	    		writer.newLine();
	    	};
		    writer.close();
	    }
	    catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e, "File error", JOptionPane.WARNING_MESSAGE);
		}
	}
}
