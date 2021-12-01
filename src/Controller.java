import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * links the Model and View
 * @author 
 *
 */
public class Controller 
{
	Model model;
	View view;
	public Controller( Model m, View v)
	{
		model = m;
		view = v;
		JButton enter = view.getEneter();
		enter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(view.getInputs()[0].equals("") || view.getInputs()[1].equals(""))
				{
					System.out.println("error! please fill BOTH fields");
				}
				else
				{
					GetPassword();
				}
			}
        	
        });
	}
	
	/*
	 * Generates password with a Password_Generator object
	 * then passes it to the model to test it
	 * then updates the view with the test results
	 */
	public void GetPassword()
	{
		String[] inputs = view.getInputs();
		Password_Generator gen = new Password_Generator(inputs[0], inputs[1]);
		String password = gen.GeneratePassword();
		String strength = model.StrengthDetector(password);
		view.givePassword(password);
		view.giveStrength(strength);
	}
}
