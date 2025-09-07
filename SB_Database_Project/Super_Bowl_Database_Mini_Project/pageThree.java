import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class pageThree {

	// name of file to draw information of super bowls
	final static String sbInfoFile = "superbowl-information.txt";
	
	// name of file containing the name of every NFL team
	final static String teamsFile = "teams.txt";
	
	// the menu number in which to determine which menu option the user is inputing
	public static menuNumber menuNumber = new menuNumber();
	
	// array containing the contents of each Super Bowl
	static String[][] superBowls;
	
	// array containing all NFL teams
	static String[] allTeams;
	
	// array list containing every team that has played in the super bowl
	static ArrayList<String> teamsPlayed = new ArrayList<String>();

	/**
	 * 
	 * Creates and executes the front of the third start menu option page.
	 * 
	 * @throws IOException
	 */
	
	public static void pageThreePrompt() throws IOException
	{
		System.out.println("What would you like to know more about?");
		System.out.println("1. Show me a team’s Super Bowls");
		System.out.println("2. Teams that have never been");
		System.out.println("3. Teams that have never won");
		System.out.println();
		
		System.out.println("Enter the number corresponding to what you'd like to know more about or 0 to go back: ");
		superBowls = FileInput.buildDataMatrix(sbInfoFile);
		allTeams = FileInput.readFile(teamsFile);
		setTeamsPlayed();
		
		// makes sure that the user enters a value which is valid 
		// in order for the page to execute one of it's possible methods
		do
		{
			try 
			{
				menuNumber.setMenuNumber();
			
				if(menuNumber.checkValidMenuNumber(menuNumber.getMenuNumber(), 3))
				{
					runPageThreeOption();
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
	 * Runs the page three option which has been chosen by the user.
	 * 
	 * @throws IOException
	 */
	
	public static void runPageThreeOption() throws IOException
	{
		if(menuNumber.getMenuNumber() == 0)
		{
			startMenu.startScreen();
		}
		if(menuNumber.getMenuNumber() == 1)
		{
			showTeamSuperBowls();
		}
		if(menuNumber.getMenuNumber() == 2)
		{
			neverBeen();
		}
		if(menuNumber.getMenuNumber() == 3)
		{
			neverWon();
		}
		
		// always returns to the page three starting screen
		pageThreePrompt();
	}
	
	/**
	 * Fills the array with every team that has ever played in the Super Bowl
	 */
	
	public static void setTeamsPlayed()
	{
		String[] sbTeams = new String[2];
		
		// add the teams of the first Super Bowl by default
		sbTeams = superBowls[0][1].split(" vs. ");
		
		// traverses through the Super Bowls array, separates the current playing teams,
		// and adds a team if it is not already in the array list
		for(int i = 1; i < superBowls.length; i++)
		{
			sbTeams = superBowls[i][1].split(" vs. ");
			
			
			for(int j = 0; j < sbTeams.length; j++)
			{
				if(teamsPlayed == null || teamsPlayed.contains(sbTeams[j]) == false)
				{
					teamsPlayed.add(sbTeams[j]);
				}
			}
		}
	}
	
	/**
	 * 
	 * Asks for the user's input and shows all the Super Bowls a specific team has played in
	 * 
	 * @throws FileNotFoundException
	 */
	
	public static void showTeamSuperBowls() throws FileNotFoundException
	{
		String[] sbTeams = new String[2];
		String[] sbTeamsInfo;
		Scanner input = new Scanner(System.in);
		sbTeamsInfo = FileInput.readFile(sbInfoFile);
		
		System.out.println("Which team?");
		String teamChoice = input.next();

		// checks if the user's input is invalid 
		// and will recursively restarts the method until the user enters a valid input
		if(containsIgnoreCase(teamsPlayed, teamChoice) == false)
		{
			System.out.println("That does not appear to be an option, please try again.");
			showTeamSuperBowls();
		}
		else
		{
			// traverses through the sbTeamsInfo array, 
			// and prints the Super Bowl's information (if one of the two teams that played 
			// in the current indexed Super Bowl is the same as the user input)
			for(int i = 0; i < sbTeamsInfo.length; i++)
			{
				sbTeams = superBowls[i][1].split(" vs. ");
				if(sbTeams[0].equalsIgnoreCase(teamChoice) || sbTeams[1].equalsIgnoreCase(teamChoice))
				{
					System.out.println(sbTeamsInfo[i]);
				}
			}
		}

		input.close();
		
		System.out.println();
	}
	
	/**
	 * Shows all the teams that have never been to a super bowl
	 */
	
	public static void neverBeen()
	{
		String[] teamName;
		
		// traverses though the allTeams array 
		// and prints the team all teams that are not in the teamsPlayed array list
		for(int i = 0; i < allTeams.length - 1; i++)
		{
			teamName = allTeams[i].split(" ");
			if(pageThree.containsIgnoreCase(teamsPlayed, teamName[teamName.length - 1]) == false)
			{
				System.out.println(allTeams[i]);
			}
		}
		
		System.out.println();
	}
	
	/**
	 * Shows all the teams that have never won the Super Bowl 
	 * (includes both teams that have and have not been)
	 */
	
	public static void neverWon()
	{
		ArrayList<String> winners = new ArrayList<String>();
		String[] teamName;
		
		// fills the winners array list with each unique team that has won a super bowl
		for(int i = 0; i < superBowls.length; i++)
		{
			if(teamsPlayed == null || (containsIgnoreCase(teamsPlayed, superBowls[i][3]) == true 
					&& containsIgnoreCase(winners, superBowls[i][3]) == false))
			{
				winners.add(superBowls[i][3]);
			}
		}
		
		// traverses though the allTeams array 
		// and prints all teams that are not in the winners array list
		for(int i = 0; i < allTeams.length - 1; i++)
		{
			teamName = allTeams[i].split(" ");
			if(pageThree.containsIgnoreCase(winners, teamName[teamName.length - 1]) == false)
			{
				System.out.println(allTeams[i]);
			}
		}
		
		System.out.println();
	}
	
	/**
	 * 
	 * Gives the boolean value as to whether or not a given list 
	 * contains a certain String, regardless of the case of the letters
	 * 
	 * @param list
	 * @param key
	 * @return boolean value of whether or not an array contains the key
	 */
	
	private static boolean containsIgnoreCase(List<String> list, String key) {
	    for (String current : list) {
	        if (current.equalsIgnoreCase(key)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	
}
