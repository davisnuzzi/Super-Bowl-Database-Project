import java.util.Scanner;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class menuNumber {
	
	public Scanner keyboard = new Scanner(System.in);
	private int menuNum;
	
	/**
	 * Constructor to initialize the menu number.
	 */
	public menuNumber()
	{
		this.menuNum = 0;
	}
	
	/**
	 * Sets the value of the menu number to the input of the user.
	 */
	
	public void setMenuNumber()
	{
		this.menuNum = this.keyboard.nextInt();
	}
	
	/**
	 * Retrieves the value of the current menu number.
	 * @return the value of the current menu number
	 */
	
	public int getMenuNumber()
	{
		return this.menuNum;
		
	}

	/**
	 * 
	 * Checks to see if the menu number selected is valid for the constraints of the class.
	 * 
	 * @param menuNumber
	 * @return the boolean value of whether or not the menu number is valid
	 */
	
	public boolean checkValidMenuNumber(int menuNumber, int numItems)
	{
		if(String.valueOf(menuNumber).compareTo("z") >= 0 || menuNumber < 0 || menuNumber > numItems)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
}
