package snakeLadders.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Utility class for reading choice from keyboard
 * @author namo
 *
 */
public class InputOutputUtil {
	
	/**
	 * This method accepts the input from the user and return it to the calling enviornment
	 * 
	 * @return String
	 */
	
	public static String readFromKeyboard(BufferedReader reader)
	{
		String choice=null;
		try
		{
			choice=reader.readLine();
		}catch(Exception e)
		{
			System.out.println("ERROR IN READING YOUR INPUT.");
		}
		
		return choice;
	}

}
