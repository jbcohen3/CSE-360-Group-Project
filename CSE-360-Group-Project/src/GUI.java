import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI extends JFrame
{
	private static final long serialVersionUID = -8896061230325595358L;
	private static final int textFieldSize = 15;
	
	//dimensions to initialize GUI with
	private static final int WIDTH = 500;
	private static final int HEIGHT = 150;
	
	//colors to print status messages with
	private static final Color SUCCESS = new Color(0, 150, 50);
	private static final Color NEUTRAL = new Color(64, 64, 64);
	private static final Color FAILURE = new Color(200, 50, 50);
	
	//components
	private JTextField inputDirectory;
	private JTextField outputDirectory;
	private JButton formatButton;
	private JLabel inputLabel;
	private JLabel outputLabel;
	private JLabel status;
	
	private ActionListener formatButtonPressed;
	
	/**
	 * constructor builds a new GUI
	 */
	public GUI()
	{
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setTitle("Text Formatter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		inputDirectory = new JTextField(textFieldSize);
		outputDirectory = new JTextField(textFieldSize);
		formatButton = new JButton("Format");
		inputLabel = new JLabel("Input File:  ", SwingConstants.CENTER);
		outputLabel = new JLabel("  Output File:", SwingConstants.CENTER);
		status = new JLabel("", SwingConstants.CENTER);
		
		formatButtonPressed = new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pressFormatButton();
			}
		};
		
		formatButton.addActionListener(formatButtonPressed);
		
		JPanel labels = new JPanel(new GridLayout(1, 2));
		labels.add(inputLabel);
		labels.add(outputLabel);
		
		JPanel directory = new JPanel();
		directory.add(inputDirectory);
		directory.add(formatButton);
		directory.add(outputDirectory);
		
		JPanel northLayout = new JPanel(new BorderLayout());
		northLayout.add(labels, BorderLayout.NORTH);
		northLayout.add(directory, BorderLayout.CENTER);
		
		JPanel content = new JPanel(new BorderLayout());
		content.add(northLayout, BorderLayout.NORTH);
		content.add(status, BorderLayout.CENTER);
		
		this.add(content);
		this.setVisible(true);
	}
	
	/**
	 * implements functionality of the formatButton, such that
	 * when the formatButton is pressed this method will be called
	 */
	private void pressFormatButton()
	{
		this.printStatus("Formatting...", NEUTRAL);
		//--
		//--
		
	}
	
	/**
	 * prints a status message on this GUI
	 * 
	 * @param message String that will be printed
	 * @param color   color to print the String as
	 */
	public void printStatus(String message, Color color)
	{
		status.setText(message);
		status.setForeground(color);
	}
	
	public static void main(String args[])
	{
		GUI display = new GUI();
	}
}