import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import javax.swing.*;

public class View extends JFrame
{
	private String name;
	private JFrame frame;
	private JPanel mypanel;
	private JPanel fieldPanel;
	private JLabel input1;
	private JLabel output1;
	private JTextField passwordInput1;
	private JLabel input2;
	private JLabel symbCount;
	private JLabel output2;
	private JTextField passwordInput2;
	private JButton enter;
	private JLabel prompt;
	private JLabel testResults;
	private JLabel Password;
	private JComboBox<Integer> symbDrop;
	private Integer[] SymbCArr = {1, 2, 3, 4, 5};
	
	public View(String name) 
	{
		this.name = name;
		mypanel = new JPanel();
		fieldPanel = new JPanel();
		frame = new JFrame(name);
		
		input1 = new JLabel("Enter first keyword below:");
		passwordInput1 = new JTextField();
		passwordInput1.setPreferredSize(new Dimension(150, 20));
		output1 = new JLabel("");
		input2 = new JLabel("Enter second keyword below:");
		passwordInput2 = new JTextField();
		passwordInput2.setPreferredSize(new Dimension(150, 20));
		output2 = new JLabel("");
		
		symbCount = new JLabel("Select how many Special Characters:");
		symbDrop = new JComboBox<Integer>(SymbCArr);
		
		
		enter = new JButton("Enter");
		enter.setBackground(Color.RED); // Sets the background color of the button to red
        enter.setForeground(Color.WHITE); // Sets the foreground color of the button to white
        
        
		prompt = new JLabel("<html><body style=\"text-align:center;\"><h2>Password Generator and Stength Detector</h2>This program will generate a password for you based on 2 keywords that you provide<br>It will then provide test results for your password based on several types of attacks<br><br><body></html>", SwingConstants.CENTER);
		testResults = new JLabel("<html><body>Test Results:<br><br>The test results will be printed here <br> The strength of the password will be scored out of 5 points</body></html>");
		testResults.setOpaque(true);
		testResults.setBackground(Color.ORANGE);
		Password = new JLabel("<html><body>Suggested Password:<br><br>The suggested password will be printed here</body></html>");
		Password.setOpaque(true);
		Password.setBackground(Color.ORANGE);
		frame.setResizable(false);
		frame.setPreferredSize(new Dimension(650,550));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //display it
		
		fieldPanel.setLayout(new GridLayout(8,1,0,5));
		fieldPanel.setBorder(BorderFactory.createEmptyBorder(100,0,100,0));
		fieldPanel.add(input1);
		fieldPanel.add(passwordInput1);
		fieldPanel.add(output1);
		fieldPanel.add(input2);
		fieldPanel.add(passwordInput2);
		fieldPanel.add(output2);
		fieldPanel.add(symbCount);
		fieldPanel.add(symbDrop);
		
		mypanel.setLayout(new GridLayout(2,1,0,20));
		mypanel.add(Password);
		mypanel.add(testResults);
		frame.add(mypanel, BorderLayout.CENTER);
		frame.add(prompt, BorderLayout.NORTH);
		frame.add(enter, BorderLayout.SOUTH);
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
		String input2 = passwordInput2.getText();
		String[] inputs = {input1, input2};
		return inputs;
	}
	
	public JButton getEnter()
	{
		return enter;
	}
	
	public void givePassword(String pw)
	{
		Password.setText("<html><body>Suggested Password:<br><br>"+pw+"</body></html>");
	}
	
	public void giveStrength(String str)
	{
		testResults.setText("<html><body>Test Results:<br><br>"+str+"</body></html>");
	}
	
	/**
	 * grabs selection of symbol count as a string from the dropdown on the UI.
	 * @return Number selected as the string.
	 */
	public int getSelectedSymb()
	{
		int selected = (int)symbDrop.getSelectedItem();
		return selected;
		
	}
}
