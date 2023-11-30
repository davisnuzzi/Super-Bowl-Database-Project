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
	
}
