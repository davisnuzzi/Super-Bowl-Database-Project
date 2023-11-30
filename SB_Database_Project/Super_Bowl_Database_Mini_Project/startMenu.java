
import java.io.IOException;
import java.util.InputMismatchException;

public class startMenu {

	// the menu number in which to determine which menu option the user is inputing
	static menuNumber menuNumber = new menuNumber();	
	
	/**
	 * 
	 * Creates and executes the front of the seventh start menu option page.
	 * 
	 * @throws IOException
	 */
	
	public static void startScreen() throws IOException
	{
		
		
		System.out.println("What would you like to know about?");
		System.out.println("1. Show data file");
		System.out.println("2. Super Bowl Number");
		System.out.println("3. Teams");
		System.out.println("4. Scores");
		System.out.println("5. Winners");
		System.out.println("6. MVPs");
		System.out.println("7. Year Played");
		System.out.println("8. Location");
		System.out.println("9. Add Information");
		System.out.println();
		
		System.out.println("Enter the number corresponding to what you'd like to know more about: ");
		
		// makes sure that the user enters a value which is valid 
		// in order for the page to execute one of it's possible methods
		do
		{
			try 
			{
				menuNumber.setMenuNumber();
			
				if(checkValidMenuNumber(menuNumber.getMenuNumber()))
				{
					runMenuOption();
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
	 * Runs any of the page options which has been chosen by the user.
	 * 
	 * @throws IOException
	 */
	public static void runMenuOption() throws IOException
	{
		if(menuNumber.getMenuNumber() == 1)
		{
			pageOne.firstPage();
		}
		if(menuNumber.getMenuNumber() == 2)
		{
			pageTwo.pageTwoPrompt();
			pageTwo.selectSuperBowl(pageTwo.superBowlNumber.getMenuNumber());
		}
		if(menuNumber.getMenuNumber() == 3)
		{
			pageThree.pageThreePrompt();
		}
		if(menuNumber.getMenuNumber() == 4)
		{
			pageFour.pageFourPrompt();
		}
		if(menuNumber.getMenuNumber() == 5)
		{
			pageFive.pageFivePrompt();
		}
		if(menuNumber.getMenuNumber() == 6)
		{
			pageSix.pageSixPrompt();
		}
		if(menuNumber.getMenuNumber() == 7)
		{
			pageSeven.pageSevenPrompt();
		}
		if(menuNumber.getMenuNumber() == 8)
		{
			pageEight.pageEightPrompt();
		}
		if(menuNumber.getMenuNumber() == 9)
		{
			AddSuperBowl.addInfo();
		}
		
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
		if(String.valueOf(menuNumber).compareTo("z") >= 0 || menuNumber < 1 || menuNumber > 9)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}

}
