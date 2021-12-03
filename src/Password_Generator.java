import java.util.Random;
import java.lang.*;
/**
 * Houses the means of generating passwords
 * takes two strings as inputs that contain info from the user
 * these two strings are then used to create a password
 * Custom represents the selected amount of special characters desired in the password.
 * @author 
 *
 */
public class Password_Generator 
{
	String personal1; 
	String personal2;
	int custom;

	public Password_Generator(String p1, String p2, int custom)
	{
		personal1 = p1;
		personal2 = p2;
		this.custom = custom;

	}

	/**
	 * uses the two instance variables given and mutates them into a password
	 * @return
	 */
	public String GeneratePassword()
	{
		Random rand = new Random();

		String temp = "";
		//generate random number
		int random = rand.nextInt(3)+1;
		//determine what goes in the middle of the two words
		//1-> nothing
		if(random == 1)
		{
			temp = personal1+personal2;
		}
		//2-> underscore
		else if (random == 2)
		{
			temp = personal1+"_"+personal2;
		}
		//3-> dash
		else if (random == 3)
		{
			temp = personal1+"-"+personal2;
		}
		StringBuilder pw = new StringBuilder(temp);
		//loop through the words
		for(int i = 0; i<temp.length(); i++)
		{
			//generate random number
			random = rand.nextInt(2)+1;
			//1-> uppercase
			if(random == 1)
			{
				pw.setCharAt(i, Character.toUpperCase(temp.charAt(i)));
			}
			//2-> lowercase
			else if (random == 2)
			{
				pw.setCharAt(i, Character.toLowerCase(temp.charAt(i)));
			}
		}
		//loop through the words
		for(int i = 0; i<temp.length(); i++)
		{
			//generate random number
			random = rand.nextInt(2)+1;
			//1-> 'A' or 'a' becomes '@' or 'S' or 's' becomes '$' and so on
			if(random == 1)
			{
				if(Character.toLowerCase(temp.charAt(i)) == 'a')
				{
					pw.setCharAt(i, '@');
				}
				else if(Character.toLowerCase(temp.charAt(i)) == 's')
				{
					pw.setCharAt(i, '$');
				}
				else if(Character.toLowerCase(temp.charAt(i)) == 'o')
				{
					pw.setCharAt(i, '0');
				}
				else if(Character.toLowerCase(temp.charAt(i)) == 'b')
				{
					pw.setCharAt(i, '8');
				}
				else if(Character.toLowerCase(temp.charAt(i)) == 'c')
				{
					pw.setCharAt(i, '(');
				}
				else if(Character.toLowerCase(temp.charAt(i)) == 'i' || Character.toLowerCase(temp.charAt(i)) == 'l')
				{
					pw.setCharAt(i, '1');
				}
			}
		}
		temp = pw.toString();
		//generate random number
		random = rand.nextInt(2)+1;
		//1-> add some special characters to start
		if(random == 1)
		{
			String chars= "";
			for(int i = 0; i < custom; i++)
			{
				//generate random number
				random = rand.nextInt(11)+33; // ascii values of different symbols
				chars = chars+(char)random;
				
			}
			temp = chars+temp;
		}

		//2-> add some special characters to end
		else if (random == 2)
		{
			String chars= "";
			for(int i = 0; i < custom; i++)
			{
				//generate random number
				random = rand.nextInt(11)+33; // ascii values of different symbols
				chars = chars+(char)random;
				
			}
			temp = temp + chars;
		}
		//generate random number
		random = rand.nextInt(20)+1; 
		//add random number to end of password
		temp = temp+random;
		return temp;
	}
}
