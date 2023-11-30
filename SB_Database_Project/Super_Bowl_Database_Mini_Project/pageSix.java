import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class pageSix {

	// name of file to draw information of super bowls
	final static String sbInfoFile = "superbowl-information.txt";
		
	// the menu number in which to determine which menu option the user is inputing
	public static menuNumber menuNumber = new menuNumber();
		
	// array containing the contents of each Super Bowl
	static String[][] superBowls;
		
	// array containing the MVP from each Super Bowl
	// each cell is formatted as {Super Bowl Number, MVP Winner, Year}
	static String[][] mvp; 
	
	/**
	 * 
	 * Creates and executes the front of the sixth start menu option page.
	 * 
	 * @throws IOException
	 */
		
	public static void pageSixPrompt() throws IOException
	{
		System.out.println("What would you like to know more about?");
		System.out.println("1. MVP of a given year");
		System.out.println("2. MVP of a given Super Bowl");
		System.out.println("3. Player with most MVP's");
		System.out.println();
		
		System.out.println("Enter the number corresponding to what you'd like to know more about or 0 to go back: ");
		superBowls = FileInput.buildDataMatrix(sbInfoFile);
		setMVP();
		
		// makes sure that the user enters a value which is valid 
		// in order for the page to execute one of it's possible methods
		do
		{
			try 
			{
				menuNumber.setMenuNumber();
			
				if(checkValidMenuNumber(menuNumber.getMenuNumber()))
				{
					runPageSixOption();
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
	 * Runs the page six option which has been chosen by the user.
	 * 
	 * @throws IOException
	 */
	
	public static void runPageSixOption() throws IOException
	{
		if(menuNumber.getMenuNumber() == 0)
		{
			startMenu.startScreen();
		}
		if(menuNumber.getMenuNumber() == 1)
		{
			getYearSBMVP();
		}
		if(menuNumber.getMenuNumber() == 2)
		{
			getSBMVP();
		}
		if(menuNumber.getMenuNumber() == 3)
		{
			mostMVP();
		}
		
		// always returns to the page six starting screen
		pageSixPrompt();
	}
	
	/**
	 * Sets the values of the MVP array to each corresponding Super Bowl
	 */
	
	public static void setMVP()
	{
		mvp = new String[superBowls.length][3];
		
		// sets the first column to be the Super Bowl Number
		for(int i = 0; i < mvp.length; i++)
		{
			mvp[i][0] = superBowls[i][0];
		}
		
		// sets the second column to be the MVP winner
		for(int i = 0; i < mvp.length; i++)
		{
			mvp[i][1] = superBowls[i][4];
		}
		
		// sets the third column to be the year the Super Bowl was played in
		for(int i = 0; i < mvp.length; i++)
		{
			mvp[i][2] = superBowls[i][5];
		}
	}
	
	/**
	 * Asks for the users input and tells the user who the MVP was of a certain years
	 */
	
	public static void getYearSBMVP()
	{
		System.out.println("Which Year?");
		menuNumber.setMenuNumber();
		
		// checks if the user's input is invalid 
		// and will recursively restarts the method until the user enters a valid input
		if(menuNumber.getMenuNumber() < 1967 || menuNumber.getMenuNumber() > 1966 + mvp.length)
		{
			System.out.println("That does not appear to be an option, please try again.");
			getYearSBMVP();
		}
		else
		{			
			System.out.println("The Super Bowl MVP in " + menuNumber.getMenuNumber() + 
					" was " + mvp[menuNumber.getMenuNumber() - 1967][1]);
			System.out.println();
		}
	}
	
	/**
	 * Asks for the users input and tells who the MVP of a specific Super Bowl was.
	 */
	
	public static void getSBMVP()
	{
		System.out.println("Which Super Bowl?");
		menuNumber.setMenuNumber();
		
		// checks if the user's input is invalid 
		// and will recursively restarts the method until the user enters a valid input
		if(menuNumber.getMenuNumber() < 1 || menuNumber.getMenuNumber() > mvp.length)
		{
			System.out.println("That does not appear to be an option, please try again.");
			getSBMVP();
		}
		else
		{
			System.out.println("The MVP(s) of Super Bowl " + menuNumber.getMenuNumber() + " was " + mvp[menuNumber.getMenuNumber()-1][1]);
			System.out.println();
			
		}
	}
	
	/**
	 * Tells the user the player which has won the most Super Bowl MVPs and the amount they have won.
	 */
	
	
	public static void mostMVP()
	{
		String[] newMVP = new String[mvp.length];
		int count = 1;
		int max = Integer.MIN_VALUE;
		String most = "";
		
		for(int i = 0; i < mvp.length; i++)
		{
			newMVP[i] = mvp[i][1];
		}
		
		// sort the newMVP array in alphabetical order to simplify counting 
		Arrays.sort(newMVP);
		
		// traverses through the array and counts the number time a certain player appears
		for(int i = 1; i < newMVP.length; i++)
		{
			if(newMVP[i].equalsIgnoreCase(newMVP[i-1]))
			{
				count++;
				
				// if the current count surpasses the current max, the max becomes the current count value
				// and the sets the value of most to be the current player in the array
				if(count > max)
				{
					max = count;
					most = newMVP[i];
				}
			}
			
			// resets the count to 1 if the value of the current player is not the same as the previous element in the array
			// i.e. a new player is reached when traversing the array
			else
			{
				count = 1;
			}
		}
		
		System.out.println(most + " has won the most Super Bowl MVPs with " + max);
		System.out.println();
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
		if(String.valueOf(menuNumber).compareTo("z") >= 0 || menuNumber < 0 || menuNumber > 3)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
}
