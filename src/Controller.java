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
	}
	
	/*
	 * Generates password with a Password_Generator object
	 * then passes it to the model to test it
	 * then updates the view with the test reults
	 */
	public void GetPassword()
	{
		
	}
}
