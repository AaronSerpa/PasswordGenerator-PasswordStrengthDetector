import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import javax.swing.*;
/**
 * Creates the frame
 * @author 
 *
 */
public class View extends JFrame
{
	private String name;
	private JFrame frame;
	private JPanel mypanel;
	private JPanel fieldPanel;
	private JTextField passwordInput1;
	private JTextField passwordInput2;
	private JButton enter;
	private JTextArea prompt;
	private JTextArea testResults;
	private JTextArea Password;
	
	public View(String name) 
	{
		this.name = name;
		mypanel = new JPanel();
		fieldPanel = new JPanel();
		frame = new JFrame(name);
		passwordInput1 = new JTextField();
		passwordInput1.setPreferredSize(new Dimension(150, 20));
		passwordInput2 = new JTextField();
		passwordInput2.setPreferredSize(new Dimension(150, 20));
		
		enter = new JButton("Enter");
		prompt = new JTextArea("This program will generate a password for you based on 2 keywords that you provide \nIt will then provide test reults for your password based on several types of attacks");
		testResults = new JTextArea("TEST STRING \nBLAHBLAHBLAH!!!");
		Password = new JTextArea("password destination");
		frame.setResizable(false);
		frame.setPreferredSize(new Dimension(650,550));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //display it
		
		fieldPanel.setLayout(new GridLayout(2,1,0,50));
		fieldPanel.setBorder(BorderFactory.createEmptyBorder(100,0,100,0));
		fieldPanel.add(passwordInput1);
		fieldPanel.add(passwordInput2);
		
		mypanel.setLayout(new GridLayout(2,1,0,20));
		mypanel.add(Password);
		mypanel.add(testResults);
		frame.add(mypanel, BorderLayout.CENTER);
		frame.add(prompt, BorderLayout.NORTH);
		frame.add(enter, BorderLayout.SOUTH);
		//frame.add(testResults, BorderLayout.EAST);
		frame.add(fieldPanel, BorderLayout.WEST);
		frame.pack(); 
		frame.setLocation(300, 90);
		frame.setVisible(true);
	}
	
	/**
	 * gets the inputs for the text fields
	 * @return an array of the input strings
	 */
	public String[] getInputs()
	{
		//put if statements for null pointer exception
		String input1 = passwordInput1.getText();
		String input2 = passwordInput1.getText();
		String[] inputs = {input1, input2};
		return inputs;
	}
}
