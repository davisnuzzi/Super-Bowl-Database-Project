import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class pageEight {

	// name of file to draw information of super bowls
	final static String sbInfoFile = "superbowl-information.txt";
	
	// the menu number in which to determine which menu option the user is inputing
	public static menuNumber menuNumber = new menuNumber();
	
	// array of the locations of each Super Bowl
	public static String[] locations;
	
	// array containing the contents of each Super Bowl
	static String[][] superBowls;
	
	/**
	 * 
	 * Creates and executes the front of the eighth start menu option page.
	 * 
	 * @throws IOException
	 */
	
	public static void pageEightPrompt() throws IOException
	{
		System.out.println("What would you like to know more about?"
			+ "\n1. Location of a Super Bowl"
			+ "\n2. Location of a certain Year"
			+ "\n3. City most played in"
			+ "\n4. All Cities played in"
			+ "\n"
			+ "\nEnter the number corresponding to what you'd like to know more about or 0 to go back: ");

		superBowls = FileInput.buildDataMatrix(sbInfoFile);
		setLocations();
		
		// makes sure that the user enters a value which is valid 
		// in order for the page to execute one of it's possible methods
		do
		{
			try 
			{
				menuNumber.setMenuNumber();
			
				if(menuNumber.checkValidMenuNumber(menuNumber.getMenuNumber(), 4))
				{
					runPageEightOption();
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
	 * Runs the page eight option which has been chosen by the user.
	 * 
	 * @throws IOException
	 */
	
	public static void runPageEightOption() throws IOException
	{
		if(menuNumber.getMenuNumber() == 0)
		{
			startMenu.startScreen();
		}
		if(menuNumber.getMenuNumber() == 1)
		{
			getSBLocation();
		}
		if(menuNumber.getMenuNumber() == 2)
		{
			getYearLocation();
		}
		if(menuNumber.getMenuNumber() == 3)
		{
			mostPlayedIn();
		}
		if(menuNumber.getMenuNumber() == 4)
		{
			allCities();
		}
		
		// always returns to the page eight starting screen
		pageEightPrompt();
	}
	
	
	/**
	 * Sets the values of the locations array to be the location of each corresponding Super Bowl location.
	 */
	
	
	public static void setLocations()
	{
		locations = new String[superBowls.length];
		
		for(int i = 0; i < locations.length; i++)
		{
			locations[i] = superBowls[i][6];
		}
	}
	
	/**
	 * Asks for the users input and tells where a specific Super Bowl was played.
	 */
	
	public static void getSBLocation()
	{
		System.out.println("Which Super Bowl?");
		menuNumber.setMenuNumber();
		
		// checks if the user's input is invalid 
		// and will recursively restarts the method until the user enters a valid input
		if(menuNumber.getMenuNumber() < 1 || menuNumber.getMenuNumber() > locations.length)
		{
			System.out.println("That does not appear to be an option, please try again.");
			getSBLocation();
		}
		else
		{
			System.out.println("Super Bowl " + menuNumber.getMenuNumber() + " was played in " 
						+ locations[menuNumber.getMenuNumber()-1] + ".");		
			System.out.println();
		}
	}
	
	/**
	 * Asks for the user's input and tells where the super bowl was played in a specific year.
	 */
	
	public static void getYearLocation()
	{
		System.out.println("Which Year?");
		menuNumber.setMenuNumber();
		
		// checks if the user's input is invalid 
		// and will recursively restarts the method until the user enters a valid input
		if(menuNumber.getMenuNumber() < 1967 || menuNumber.getMenuNumber() > 1966 + locations.length)
		{
			System.out.println("That does not appear to be an option, please try again.");
			getYearLocation();
		}
		else
		{
			System.out.println("In " + menuNumber.getMenuNumber() + ", the Super Bowl was palyed in " 
					+ locations[menuNumber.getMenuNumber() - 1967] + ".");		
			System.out.println();
		}
	}
	
	/**
	 * Tells the user the city that has hosted the most Super Bowls 
	 * and the amount of times it has been played in that city.
	 */
	
	
	public static void mostPlayedIn()
	{
		int count = 1;
		int max = Integer.MIN_VALUE;
		String most = "";
		
		// sort the locations array in alphabetical order to simplify counting 
		Arrays.sort(locations);
		
		// traverses through the array and counts the number time a certain city appears
		for(int i = 1; i < locations.length; i++)
		{
			if(locations[i].equalsIgnoreCase(locations[i-1]))
			{
				count++;
				
				// if the current count surpasses the current max, the max becomes the current count value
				// and the sets the value of most to be the current location in the array
				if(count > max)
				{
					max = count;
					most = locations[i];
				}
			}
			
			// resets the count to 1 if the value of the current location is not the same as the previous element in the array
			// i.e. a new location is reached when traversing the array
			else
			{
				count = 1;
			}
		}
		
		System.out.println(most + " has hosted the most Super Bowls with " + max);
		System.out.println();
		
	}
	
	/**
	 * Shows the user each location in which the Super Bowl has been played in.
	 */
	
	public static void allCities()
	{
		// // sort the locations array in alphabetical order to simplify traversal and printing each unique element
		Arrays.sort(locations);
		
		System.out.println();
		// will always print the first element (guaranteed to be unique since it has no previous elements)
		System.out.println(locations[0]);
		
		// traverses through the array and prints each unique element
		for(int i = 1; i < locations.length; i++)
		{
			// if the location is not the same as the previous element then it is a new unique element
			// (the array is sorted in alphabetical order so every time the element isn't the same as the previous, the element changes in uniqueness)
			if(!(locations[i].equalsIgnoreCase(locations[i-1])))
			{
				System.out.println(locations[i]);
			}
		}
		
		// prints a space for neatness of output in the console
		System.out.println();
	}
}
