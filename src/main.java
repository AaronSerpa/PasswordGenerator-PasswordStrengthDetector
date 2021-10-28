/**
 * runs the program
 * @author 
 *
 */
public class main {
	public static void main(String[] args)
	{
		Model model = new Model();
		View view = new View("Password Friend");
		Controller controller = new Controller(model, view);
	}
}
