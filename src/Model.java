import java.io.*;
import java.util.*;

/**
 * Models the variables of the Frame
 * this is where the attack algorithms will be used
 * @author 
 *
 */
public class Model 
{
	public String password;
	public String s;
	public String result;
	
	public Model()
	{
	}
	
	public String StrengthDetector(String p)
	{
		password = p;
		int strength = 0;
		
		boolean capital = false;
		boolean small = false;
		boolean number = false;
		boolean dictionary = false;
		
		// creates an array list of special characters
		ArrayList<String> special = new ArrayList<String>();
		special.add("!");
		special.add("@");
		special.add("#");
		special.add("$");
		special.add("%");
		special.add("^");
		special.add("&");
		special.add("*");
		special.add("(");
		special.add(")");
		
		// determines changes in value of strength based on password length
		if(password.length() > 16)
		{
			strength = strength + 2;
		}
		else if(password.length() > 8)
		{
			strength = strength + 1;
		}
		
		// determines changes in value of strength based on presence of special characters in the password
		for(int i = 0; i < special.size() ;i++)
		{
			if(password.contains(special.get(i)))
			{
				strength = strength + 1;
				break;
			}
		}
		
		// checks if password has upper case, lower case and numerical characters
		for(int i = 0; i < password.length() ;i++)
		{
			if(Character.isUpperCase(password.charAt(i)))
			{
				capital = true;
			}
			else if(Character.isLowerCase(password.charAt(i)))
			{
				small = true;
			}
			else if(Character.isDigit(password.charAt(i)))
			{
				number = true;
			}
		}
		
		// if password has upper case, lower case and numerical characters value of strength is increased by 1
		if(capital && small && number)
		{
			strength = strength + 1;
		}
		
		// creates scanner object that takes in easyPasswords.txt file as input
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("easyPasswords.txt"));
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

		// checks if the password matches one of the easy passwords in the file
		while(scanner.hasNext()) {
			String easyPassword = scanner.nextLine();
			if(password.equals(easyPassword))
			{
				dictionary = true;
			}
		}
		
		// if password does not match any of the easy passwords in the file, strength is increased by 1
		if(dictionary == false)
		{
			strength = strength + 1;
		}
		
		// describes the strength of the password in words
		if(strength == 5)
		{
			s = "the generated password is extremely strong)";
		}
		else if(strength == 4)
		{
			s = "the generated password is strong)";
		}
		else if(strength == 3)
		{
			s = "the generated password has average strength)";
		}
		else
		{
			s = "the generated password is too easy, please re-enter keywords)";
		}

		result = "Strength Score = " + strength + " (" + s;
			
		return result;
	}
}