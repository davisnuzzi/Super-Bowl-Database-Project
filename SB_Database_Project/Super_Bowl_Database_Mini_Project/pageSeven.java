import java.io.IOException;
import java.util.InputMismatchException;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class pageSeven {

	// name of file to draw information of super bowls
	final static String sbInfoFile = "superbowl-information.txt";
	
	// the menu number in which to determine which menu option the user is inputing
	public static menuNumber menuNumber = new menuNumber();
	
	// array containing the contents of each Super Bowl
	static String[][] superBowls;
	
	// array containing each Super Bowl year's information
	static String[] years;
	
	/**
	 * 
	 * Creates and executes the front of the seventh start menu option page.
	 * 
	 * @throws IOException
	 */
	
	public static void pageSevenPrompt() throws IOException
	{
		System.out.println("What year would you like to know about? (Enter a year to learn more or type 0 to go back)");
		superBowls = FileInput.buildDataMatrix(sbInfoFile);
		years = FileInput.readFile(sbInfoFile);
		
		// makes sure that the user enters a value which is valid 
		// in order for the page to execute one of it's possible methods
		do
		{
			try 
			{
				menuNumber.setMenuNumber();
				
				if(menuNumber.getMenuNumber() == 0)
				{
					startMenu.startScreen();
				}
			
				if(checkValidMenuNumber(menuNumber.getMenuNumber()))
				{
					readYearInfo();
					break;
				}
			
			}
			catch(InputMismatchException e)
			{
				
			}
			finally
			{
				menuNumber.keyboard.nextLine();
			}
			
			System.out.println("That does not appear to be an option, please try again.");
		
		} while (true);
	}
	
	/**
	 * 
	 * Asks the user to enter a year and then tells the user the information from that year.
	 * 
	 * @throws IOException
	 */
	
	public static void readYearInfo() throws IOException
	{
		
		System.out.println("Super Bowl, Teams, Score, Winner, MVP, Year Played, Location Played");
		System.out.println();
		System.out.println(years[menuNumber.getMenuNumber()-1967]);
		System.out.println();
		
		// always returns to the page four starting screen
		pageSevenPrompt();
	}
	
	/**
	 * 
	 * Checks to see if the menu number selected is valid for the constraints of the class.
	 * 
	 * @param menuNumber
	 * @return the boolean value of whether or not the menu number is valid
	 */
	
	public static boolean checkValidMenuNumber(int menuNumber)
	{
		if(String.valueOf(menuNumber).compareTo("z") >= 0 || menuNumber < 1967 || menuNumber > 1966 + superBowls.length)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
}
