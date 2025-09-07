import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class pageTwo {

	// name of file to draw information of super bowls
	final static String sbInfoFile = "superbowl-information.txt";
	
	// the Super Bowl number in which to determine which Super Bowl the user is inputing
	static menuNumber superBowlNumber = new menuNumber();
	
	// array containing the contents of each Super Bowl
	static String[][] superBowls;
	
	/**
	 * 
	 * Creates and executes the front of the second start menu option page.
	 * 
	 * @throws IOException
	 */
	
	public static void pageTwoPrompt() throws FileNotFoundException
	{
		System.out.println("Which super bowl would you like to know more about? "
				+ "(Enter a number to see more information or 0 to go back)");
		superBowls = FileInput.buildDataMatrix(sbInfoFile);
		
		// makes sure that the user enters a value which is valid 
		// in order for the page to execute the selectSuperBowl method
		
		do
		{
			try 
			{
				superBowlNumber.setMenuNumber();
			
				if(checkValidSBNumber(superBowlNumber.getMenuNumber()))
				{
					break;
				}
			
			}
			catch(InputMismatchException e)
			{
				
			}
			finally
			{
				superBowlNumber.keyboard.nextLine();
			}
			
			System.out.println("That does not appear to be an option, please try again.");
		
		} while (true);
		
		
	}
	
	/**
	 * 
	 * Reads in the user's input and prints out a sentence with some 
	 * information of a given Super Bowl, 
	 * or returns to the start screen menu if 0 is input
	 * 
	 * @param num
	 * @throws IOException
	 */
	
	public static void selectSuperBowl(int num) throws IOException
	{
		
		if(num == 0)
		{
			startMenu.startScreen();
		}
		else
		{
			System.out.println("Super bowl " + superBowls[num - 1][0] + " was a matchup of " + superBowls[num - 1][1] + " in which the "
					+ superBowls[num - 1][3] + " won " + superBowls[num - 1][2] + ", and " + superBowls[num - 1][4] + " won the MVP of the game."
					+ " The game was play in " + superBowls[num - 1][5] + " in " + superBowls[num - 1][6] + ".");
			
			System.out.println();
			startMenu.runMenuOption();
		}
		
	}
	
	/**
	 * 
	 * Checks to see if the menu number selected is valid for the constraints of the class.
	 * 
	 * @param sbNumber
	 * @return the boolean value of whether or not the menu number is valid
	 */
	
	public static boolean checkValidSBNumber(int sbNumber)
	{
		if(String.valueOf(sbNumber).compareTo("z") >= 0 || sbNumber < 0 || sbNumber > superBowls.length)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
}
