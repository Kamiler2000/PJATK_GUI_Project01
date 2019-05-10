import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class S19877_GUI_Projekt01 {

	//public static List<Image> ImageList = new ArrayList<Image>();
	
	public static void main(String[] args) {	
		//Create GUI
		SwingUtilities.invokeLater(() -> {
			createAndShowGUI();
		});
	}
	
	
	public static void createAndShowGUI() {
		
		//=========================================================================================
		//Components===============================================================================
		//=========================================================================================
		
		//Panels-----------------------------------------------------------------------------------
		
		//Main panel
		JPanel pMain = new JPanel();
		pMain.setLayout(new BorderLayout());
		
		//Menu-------------------------------------------------------------------------------------
		JMenuBar menuBar = new JMenuBar();
		JMenu mFile = new JMenu("File");
		JMenu mImage = new JMenu("Image");

		//Menu Items-------------------------------------------------------------------------------
		
		//mFile Menu
		JMenuItem newFileItem = new JMenuItem("New");
		newFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem openFileItem = new JMenuItem("Open");
		openFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		JMenuItem saveFileItem = new JMenuItem("Save");
		saveFileItem.setEnabled(false);
		saveFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		JMenuItem saveAsFileItem = new JMenuItem("Save As");
		saveAsFileItem.setEnabled(false);
		saveAsFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK | ActionEvent.ALT_MASK));
		JMenuItem closeFileItem = new JMenuItem("Exit");
		
		//mFile Menu
		JMenuItem addImageFileItem = new JMenuItem("Add");
		JMenuItem editImageFileItem = new JMenuItem("Edit");
		JMenuItem removeImageFileItem = new JMenuItem("Remove");
		
		//Tables-----------------------------------------------------------------------------------
		//JTable table = new JTable(content, headers);
		//table.setEnabled(false);
		
		//ImageIcons-------------------------------------------------------------------------------
		ImageIcon imageIcon = new ImageIcon("Flowers.jpg");
		
		//Labels-----------------------------------------------------------------------------------
		JLabel picLabel = new JLabel(imageIcon);
		
		//FileChooser------------------------------------------------------------------------------
		JFileChooser fileOpenChooser = new JFileChooser();
		JFileChooser fileSaveAsChooser = new JFileChooser();
		JFileChooser fileChooserAdd = new JFileChooser();
		
		//Frame------------------------------------------------------------------------------------
		JFrame mainFrame = new JFrame();
		mainFrame.setContentPane(pMain); //add main panel
		mainFrame.setSize(1000, 800);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setJMenuBar(menuBar);
		
		//=========================================================================================
		//Add components===========================================================================
		//=========================================================================================
		
		//Add picLabel
		pMain.add(picLabel, BorderLayout.CENTER);
				
		//Menu items-------------------------------------------------------------------------------
		
		//mFile items
		mFile.add(newFileItem);
		mFile.add(openFileItem);
		mFile.add(saveFileItem);
		mFile.add(saveAsFileItem);
		mFile.addSeparator();
		mFile.add(closeFileItem);
		
		//mImage items
		mImage.add(addImageFileItem);
		addImageFileItem.enable(false);
		mImage.add(editImageFileItem);
		//Menu bars--------------------------------------------------------------------------------
		menuBar.add(mFile);
		menuBar.add(mImage);

		//=========================================================================================
		//Events===================================================================================
		//=========================================================================================

		
		//Menu events------------------------------------------------------------------------------
		
		//New File
		newFileItem.addActionListener(event -> {
			Image.clearImagesList();
			picLabel.setIcon(null);
			saveFileItem.setEnabled(false);
			saveAsFileItem.setEnabled(false);;
		});
		
		//Save File
		saveFileItem.addActionListener(event -> {
			//Save file event
			//JOptionPane.showMessageDialog(mainFrame, "Save");
			try {
				ExportImegeList.Export();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(mainFrame, e, "File error", JOptionPane.WARNING_MESSAGE);
			}
			saveFileItem.setEnabled(false);
		});
		
		
		//SaveAs File
		saveAsFileItem.addActionListener(event -> fileSaveAsChooser.showSaveDialog(mainFrame));
		fileSaveAsChooser.addActionListener(event -> {
			try {
				ExportImegeList.Export(fileSaveAsChooser.getSelectedFile().getPath());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(mainFrame, e, "File error", JOptionPane.WARNING_MESSAGE);
			}
			saveFileItem.setEnabled(false);
		});
		
		//Open File
		openFileItem.addActionListener(event -> fileOpenChooser.showOpenDialog(mainFrame));
		fileOpenChooser.addActionListener(event -> {
			//User should choose file
			try{
				String p = fileOpenChooser.getSelectedFile().getPath();
				ImportImageList.Import(p);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		});
		
		//Exit application
		closeFileItem.addActionListener(e -> System.exit(0));
		
		//Add image
		addImageFileItem.addActionListener(event -> fileChooserAdd.showOpenDialog(mainFrame));
		fileChooserAdd.addActionListener(evant -> {
			try{
				Image.addImage(new Image(fileChooserAdd.getSelectedFile().getPath()));	
				//TODO:		-show image
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(mainFrame, e, "File error", JOptionPane.WARNING_MESSAGE);
			}
			
			saveFileItem.setEnabled(true);
			saveAsFileItem.setEnabled(true);
		});
			
		//Edit item
		editImageFileItem.addActionListener(event -> {
			//TODO			-edit Image fields
		});
	}
}
