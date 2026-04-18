import java.util.Scanner;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class menuNumber {
	
	private static final Scanner SHARED_KEYBOARD = new Scanner(System.in);
	public final Scanner keyboard = SHARED_KEYBOARD;
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
		if (this.keyboard.hasNextInt())
		{
			this.menuNum = this.keyboard.nextInt();
		}
		else
		{
			this.keyboard.next();
			this.menuNum = Integer.MIN_VALUE;
		}
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
		return menuNumber >= 0 && menuNumber <= numItems;
	}
	
}
