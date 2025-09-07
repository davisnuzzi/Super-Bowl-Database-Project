import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class pageFive {

	// name of file to draw information of super bowls
	final static String sbInfoFile = "superbowl-information.txt";
	
	// the menu number in which to determine which menu option the user is inputing
	public static menuNumber menuNumber = new menuNumber();
	
	// array containing the contents of each Super Bowl
	static String[][] superBowls;
	
	// array containing the winners of each Super Bowl
	static String[] winners;
	
	// array containing the losers of each Super Bowl
	static String[] losers;
	
	/**
	 * 
	 * Creates and executes the front of the fifth start menu option page.
	 * 
	 * @throws IOException
	 */
	
	public static void pageFivePrompt() throws IOException
	{
		 System.out.println("What would you like to know more about?"
			+ "\n1. What team has won the most Super Bowls"
			+ "\n2. What team has lost the most Super Bowls"
			+ "\n"
			+ "\nEnter the number corresponding to what you'd like to know more about or 0 to go back: ");
		
		superBowls = FileInput.buildDataMatrix(sbInfoFile);
		setWinners();
		setLosers();
		
		// makes sure that the user enters a value which is valid 
		// in order for the page to execute one of it's possible methods
		do
		{
			try 
			{
				menuNumber.setMenuNumber();
			
				if(menuNumber.checkValidMenuNumber(menuNumber.getMenuNumber(), 2))
				{
					runPageFiveOption();
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
	 * Runs the page five option which has been chosen by the user.
	 * 
	 * @throws IOException
	 */
	
	public static void runPageFiveOption() throws IOException
	{
		if(menuNumber.getMenuNumber() == 0)
		{
			startMenu.startScreen();
		}
		if(menuNumber.getMenuNumber() == 1)
		{
			wonMost();
		}
		if(menuNumber.getMenuNumber() == 2)
		{
			lostMost();
		}
		
		// always returns to the page five starting screen
		pageFivePrompt();
	}
	
	/**
	 * Sets the values of the winners array to each corresponding Super Bowl winner.
	 */
	
	public static void setWinners()
	{
		winners = new String[superBowls.length];
		
		for(int i = 0; i < superBowls.length; i++)
		{
			winners[i] = superBowls[i][3];
		}
		
	}
	
	/**
	 * Sets the values of the losers array to each corresponding Super Bowl loser.
	 */
	
	public static void setLosers()
	{
		String[] sbTeams = new String[0];
		losers = new String[superBowls.length];
		
		for(int i = 0; i < superBowls.length; i++)
		{
			sbTeams = superBowls[i][1].split(" vs. ");
			
			if(!(sbTeams[0].equals(winners[i])))
			{
				losers[i] = sbTeams[0];
			}
			else
			{
				losers[i] = sbTeams[1];
			}
		}
		
	}
	
	/**
	 * Tells the user the team that has won the most Super Bowls.
	 */
	
	public static void wonMost()
	{
		ArrayList<String> wonMost = new ArrayList<String>();
		int count = 1;
		int max = Integer.MIN_VALUE;
		String mostWins = "";
		
		// sort the winners array to simplify counting
		Arrays.sort(winners);
		
		// traverse through the winners array to count which team occurs the most
		// and sets the element value(s) of wonMost to be the team(s)
		for(int i = 1; i < winners.length; i++)
		{
			if(winners[i].equalsIgnoreCase(winners[i-1]))
			{
				count++;
				
				// if the current count surpasses the current max, the max becomes the current count value
				// The value of most to be the current winner in the array and wonMost is cleared 
				// for the new team to be placed in wonMost
				if(count > max)
				{
					max = count;
					wonMost.removeAll(wonMost);
					wonMost.add(winners[i]);
				}
				
				// if count is the same as the max, add the team to wonMost
				if(count == max)
				{
					wonMost.add(winners[i]);
				}
			}
			
			// resets the count to 1 if the value of the current team is not the same as the previous element in the array
			// i.e. a new team is reached when traversing the array
			else
			{
				count = 1;
			}
		}
		
		//removes the first element due to repetition the occurs from the for loop
		wonMost.remove(0);
		
		// always add the first element since at least one team has won the most
		mostWins += wonMost.get(0);
		
		// if more than one team has won the same amount of wins, make the mostWins string contain all teams in wonMost
		if(wonMost.size() > 1)
		{
			for(int i = 1; i < wonMost.size(); i++)
			{
				mostWins += "/" + wonMost.get(i);
			}	
		}
		
		System.out.println("The " + mostWins + " have won the most Super Bowls with " + max);
		System.out.println();
	}
	
	/**
	 * Tells the user the team that has won the most Super Bowls.
	 */
	
	public static void lostMost()
	{
		ArrayList<String> lostMost = new ArrayList<String>();
		int count = 1;
		int max = Integer.MIN_VALUE;
		String mostLosses = "";
		
		// sort the winners array to simplify counting
		Arrays.sort(losers);
		
		// traverse through the losers array to count which team occurs the most
		// and sets the element value(s) of lostMost to be the team(s)
		for(int i = 1; i < losers.length; i++)
		{
			if(losers[i].equalsIgnoreCase(losers[i-1]))
			{
				count++;
				
				// if the current count surpasses the current max, the max becomes the current count value,
				// the value of most to be the current loser in the array and lostMost is cleared 
				// for the new team to be placed in lostMost
				if(count > max)
				{
					max = count;
					lostMost.removeAll(lostMost);
					lostMost.add(losers[i]);
				}
				
				// if count is the same as the max, add the team to lostMost
				if(count == max)
				{
					lostMost.add(losers[i]);
				}
			}
			
			// resets the count to 1 if the value of the current team is not the same as the previous element in the array
			// i.e. a new team is reached when traversing the array
			else
			{
				count = 1;
			}
		}
		
		//removes the first element due to repetition the occurs from the for loop
		lostMost.remove(0);
		
		// always add the first element since at least one team has won the most
		mostLosses += lostMost.get(0);
		
		// if more than one team has won the same amount of loses, make the mostLosses string contain all teams in lostMost
		if(lostMost.size() > 1)
		{
			for(int i = 1; i < lostMost.size(); i++)
			{
				mostLosses += "/" + lostMost.get(i);
			}	
		}
		
		System.out.println("The " + mostLosses + " have lost the most Super Bowls with " + max);
		System.out.println();
	}
	
}
