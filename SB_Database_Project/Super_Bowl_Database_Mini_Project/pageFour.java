import java.io.IOException;
import java.util.InputMismatchException;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class pageFour {
	
	// name of file to draw information of super bowls
	final static String sbInfoFile = "superbowl-information.txt";
	
	// the menu number in which to determine which menu option the user is inputing
	public static menuNumber menuNumber = new menuNumber();
	
	// array containing the contents of each Super Bowl
	static String[][] superBowls;
	
	// array containing the scores of a given super bowl
	static String[] score = new String[2];
	
	/**
	 * 
	 * Creates and executes the front of the fourth start menu option page.
	 * 
	 * @throws IOException
	 */
	
	public static void pageFourPrompt() throws IOException
	{
		System.out.println("What would you like to know more about?");
		System.out.println("1. Highest Scoring Super Bowl");
		System.out.println("2. Lowest Scoring Super Bowl");
		System.out.println("3. Largest margin of victory");
		System.out.println("4. Smallest margin of victory");
		System.out.println("5. Most points scored by a team");
		System.out.println("6. Least points scored by a team");
		System.out.println();
		
		System.out.println("Enter the number corresponding to what you'd like to know more about or 0 to go back: ");
		superBowls = FileInput.buildDataMatrix(sbInfoFile);
		
		// makes sure that the user enters a value which is valid 
		// in order for the page to execute one of it's possible methods
		do
		{
			try 
			{
				menuNumber.setMenuNumber();
			
				if(checkValidMenuNumber(menuNumber.getMenuNumber()))
				{
					runPageFourOption();
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
	 * Runs the page four option which has been chosen by the user.
	 * 
	 * @throws IOException
	 */
	
	public static void runPageFourOption() throws IOException
	{
		if(menuNumber.getMenuNumber() == 0)
		{
			startMenu.startScreen();
		}
		if(menuNumber.getMenuNumber() == 1)
		{
			highestScore();
		}
		if(menuNumber.getMenuNumber() == 2)
		{
			lowestScore();
		}
		if(menuNumber.getMenuNumber() == 3)
		{
			biggestBlowout();
		}
		if(menuNumber.getMenuNumber() == 4)
		{
			closestGame();
		}
		if(menuNumber.getMenuNumber() == 5)
		{
			mostPointsByTeam();
		}
		if(menuNumber.getMenuNumber() == 6)
		{
			leastPointsByTeam();
		}
			
		// always returns to the page four starting screen
		pageFourPrompt();
	}
	
	/**
	 * Tells the user the Super Bowl which had the most total points scored.
	 */
	
	public static void highestScore()
	{
		int max = Integer.MIN_VALUE;
		int sbMax = 0;
		
		// traverses through each the superBowls array, separates each score,
		// and adds up the score points scored to find the highest scoring Super Bowl
		for(int i = 0; i < superBowls.length; i++)
		{
			score = superBowls[i][2].split("-");
			if(Integer.valueOf(score[0]) + Integer.valueOf(score[1]) > max)
			{
				max = Integer.valueOf(score[0]) + Integer.valueOf(score[1]);
				sbMax = i + 1;
			}
		}
		
		System.out.println("The highest scoring Super Bowl was Super Bowl " + sbMax + " where " + max + " total points were scored.");
		System.out.println();
	}
	
	/**
	 * Tells the user the Super Bowl which had the least total points scored.
	 */
	
	public static void lowestScore()
	{
		int min = Integer.MAX_VALUE;
		int sbMin = 0;
		
		// traverses through each the superBowls array, separates each score,
		// and adds up the points scored to find the lowest scoring Super Bowl
		for(int i = 0; i < superBowls.length; i++)
		{
			score = superBowls[i][2].split("-");
			if(Integer.valueOf(score[0]) + Integer.valueOf(score[1]) < min)
			{
				min = Integer.valueOf(score[0]) + Integer.valueOf(score[1]);
				sbMin = i + 1;
			}
		}
		
		System.out.println("The lowest scoring Super Bowl was Super Bowl " + sbMin + " where " + min + " total points were scored.");
		System.out.println();
	}
	
	/**
	 * Tells the user the Super Bowl which had the largest score difference.
	 */
	
	public static void biggestBlowout()
	{
		int biggestWin = Integer.MIN_VALUE;
		int sbBiggestWin = 0;
		
		// Traverses through the superBowls array, separates each score,
		// and subtracts the points scored to find the largest score difference
		for(int i = 0; i < superBowls.length; i++)
		{
			score = superBowls[i][2].split("-");
			if(Integer.valueOf(score[0]) - Integer.valueOf(score[1]) > biggestWin)
			{
				biggestWin = Integer.valueOf(score[0]) - Integer.valueOf(score[1]);
				sbBiggestWin = i + 1;
			}
		}
		
		System.out.println("The largest margin of victory was in Super Bowl " + sbBiggestWin + " where the " 
				+ superBowls[sbBiggestWin-1][3] + " won by " + biggestWin + " points.");
		System.out.println();
	}
	
	/**
	 * Tells the user the Super Bowl which had the smallest score difference.
	 */
	
	public static void closestGame()
	{
		int smallestWin = Integer.MAX_VALUE;
		int sbSmallestWin = 0;
		
		// Traverses through the superBowls array, separates each score,
		// and subtracts the points scored to find the smallest score difference
		for(int i = 0; i < superBowls.length; i++)
		{
			score = superBowls[i][2].split("-");
			if(Integer.valueOf(score[0]) - Integer.valueOf(score[1]) < smallestWin)
			{
				smallestWin = Integer.valueOf(score[0]) - Integer.valueOf(score[1]);
				sbSmallestWin = i + 1;
			}
		}
		
		System.out.println("The smallest margin of victory was in Super Bowl " + sbSmallestWin + " where the " 
				+ superBowls[sbSmallestWin-1][3] + " won by " + smallestWin + " point(s).");
		System.out.println();
	}
	
	/**
	 * Tells the user which team has scored the most points in a Super Bowl.
	 */
	
	public static void mostPointsByTeam()
	{
		int mostPoints = Integer.MIN_VALUE;
		int sbMostPoints = 0;
		
		// Traverses through the superBowls array, separates each score,
		// and sees whether or not the value of the winning score is higher 
		// than the current most points scored by a team
		for(int i = 0; i < superBowls.length; i++)
		{
			score = superBowls[i][2].split("-");
			if(Integer.valueOf(score[0]) > mostPoints)
			{
				mostPoints = Integer.valueOf(score[0]);
				sbMostPoints = i + 1;
			}
		}
		
		System.out.println("The " + superBowls[sbMostPoints - 1][3] + " scored the most points in a super bowl with " + mostPoints 
				+ " during Super Bowl " + sbMostPoints);
		System.out.println();
	}
	
	/**
	 * Tells the reader which team has scored the least points in a Super Bowl.
	 */
	
	public static void leastPointsByTeam()
	{
		String leastPointsTeam = "";
		String[] teams = new String[2];
		String winner;;
		int leastPoints = Integer.MAX_VALUE;
		int sbLeastPoints = 0;
		
		// Traverses through the superBowls array, separates each score,
		// and sees whether or not the value of the losing score is lower 
		// than the current least points scored by a team
		for(int i = 0; i < superBowls.length; i++)
		{
			score = superBowls[i][2].split("-");
			if(Integer.valueOf(score[1]) < leastPoints)
			{
				leastPoints = Integer.valueOf(score[1]);
				sbLeastPoints = i + 1;
			}
		}
		
		// sets the value to be the winner of which the Super Bowl 
		// which the least team points occurred
		winner = superBowls[sbLeastPoints-1][3];
		
		// sets the value to be the teams of the Super Bowl
		// which the least team points occurred
		teams = superBowls[sbLeastPoints-1][1].split(" vs. ");
		
		// leastPointsTeam is the first element of teams if it is not the winner
		if(teams[0].equalsIgnoreCase(winner))
		{
			leastPointsTeam = teams[1];
		}
		else
		{
			leastPointsTeam = teams[0];
		}
		
		System.out.println("The " + leastPointsTeam + " scored the least points in a super bowl with " + leastPoints 
				+ " during Super Bowl " + sbLeastPoints);
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
		if(String.valueOf(menuNumber).compareTo("z") >= 0 || menuNumber < 0 || menuNumber > 6)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
}
