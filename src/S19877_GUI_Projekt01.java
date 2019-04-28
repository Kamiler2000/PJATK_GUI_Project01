import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class S19877_GUI_Projekt01 {

	public static List<Image> ImageList = new ArrayList<Image>();
	
	public static void main(String[] args) {	
		//Create GUI
		SwingUtilities.invokeLater(() -> {
			createAndShowGUI();
		});
	}
	
	
	public static void createAndShowGUI() {
		
		//================================================================
		//Components======================================================
		//================================================================
		
		//Panels----------------------------------------------------------
		//Main panel
		JPanel pMain = new JPanel();
		pMain.setLayout(new BorderLayout());
		
		//Left panel for images list and sorting
		JPanel pLeft = new JPanel();
		pLeft.setPreferredSize(new Dimension(200, 0));
		pLeft.setLayout(new BoxLayout(pLeft, BoxLayout.Y_AXIS));
		
		//Right panel for main view - navigation buttons, image, image properties
		JPanel pRight = new JPanel();
		pRight.setLayout(new BoxLayout(pRight, BoxLayout.Y_AXIS));
		
		//Right top panel for navigation buttons
		JPanel pRightTop = new JPanel();
		
		//Right center panel for image
		JPanel pRightCenter = new JPanel();
		
		//Right bottom panel for image properties
		JPanel pRightBottom = new JPanel();
		
		//Panels for image properties
		JPanel pRightBottomPath = new JPanel();
		JPanel pRightBottomAuthor = new JPanel();
		JPanel pRightBottomLocalizatin = new JPanel();
		JPanel pRightBottomDate = new JPanel();
		JPanel pRightBottomTags = new JPanel();
		
		//Menu------------------------------------------------------------
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");

		//Menu Items------------------------------------------------------
		JMenuItem newFileItem = new JMenuItem("New");
		newFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem openFileItem = new JMenuItem("Open");
		openFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		JMenuItem saveFileItem = new JMenuItem("Save");
		saveFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		JMenuItem saveAsFileItem = new JMenuItem("Save As");
		JMenuItem closeFileItem = new JMenuItem("Exit");
		
		//Buttons---------------------------------------------------------
		
		//TextFields------------------------------------------------------
		JTextField tfPath = new JTextField(20);
		tfPath.setEditable(false);
		
		JTextField tfAuthor = new JTextField(20);
		tfAuthor.setText("Kamil Rolek");
		
		JTextField tfLocation = new JTextField(20);
		tfLocation.setText("Warszawa");
		
		JTextField tfDate = new JTextField(20);
		tfDate.setEditable(true);
		
		JTextField tfTag = new JTextField(20);
		tfTag.setText("tag1; tag2");
		
		//ImageIcons------------------------------------------------------
		ImageIcon imageIcon = new ImageIcon("Flowers.jpg");
		
		//Labels----------------------------------------------------------
		JLabel picLabel = new JLabel(imageIcon);
		
		//FileChooser-----------------------------------------------------
		JFileChooser fileChooser = new JFileChooser();
		
		//Frame-----------------------------------------------------------
		JFrame mainFrame = new JFrame();
		mainFrame.setContentPane(pMain);
		mainFrame.setSize(1000, 800);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setJMenuBar(menuBar);
		
		//================================================================
		//Add components==================================================
		//================================================================
		
		//Controls--------------------------------------------------------
		pMain.add(pLeft, BorderLayout.LINE_START);
		pMain.add(pRight, BorderLayout.CENTER);
		
		pRight.add(picLabel);
		pRight.add(Box.createRigidArea(new Dimension(5, 5)));
		pRight.add(tfPath);
		pRight.add(Box.createRigidArea(new Dimension(5, 5)));
		pRight.add(tfAuthor);
		pRight.add(Box.createRigidArea(new Dimension(5, 5)));
		pRight.add(tfLocation);
		pRight.add(Box.createRigidArea(new Dimension(5, 5)));
		pRight.add(tfDate);
		pRight.add(Box.createRigidArea(new Dimension(5, 5)));
		pRight.add(Box.createVerticalGlue());
		pRight.add(tfTag);
				
		//Menu items------------------------------------------------------
		fileMenu.add(newFileItem);
		fileMenu.add(openFileItem);
		fileMenu.add(saveFileItem);
		fileMenu.add(saveAsFileItem);
		fileMenu.addSeparator();
		fileMenu.add(closeFileItem);

		//Menu bars--------------------------------------------------------
		menuBar.add(fileMenu);
		
		//================================================================
		//Events==========================================================
		//================================================================
		
		//Open File
		openFileItem.addActionListener(event -> fileChooser.showOpenDialog(mainFrame));
		fileChooser.addActionListener(event -> {
			Image image = new Image(fileChooser.getSelectedFile().getPath());
			ImageIcon iconFile = new ImageIcon(image.getPath());
			picLabel.setIcon(iconFile);
			tfPath.setText(image.getPath());
		});
		
		//Exit app
		closeFileItem.addActionListener(e -> System.exit(0));
	}
}
