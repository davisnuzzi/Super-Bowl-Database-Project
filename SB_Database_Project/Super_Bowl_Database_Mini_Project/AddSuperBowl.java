import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class AddSuperBowl {

	// name of file to draw information of super bowls
	final static String sbInfoFile = "superbowl-information.txt";
	
	// name of file that simply lists all NFL teams
	final static String teamInfoFile = "teams.txt";
	
	// array containing a list of all NFL teams
	static String[] allTeams = new String[32];
	
	// array containing all user input information gathered that will be added to the information file
	static String[] inputs = new String[7];
	
	// scanner that gathers the user's input
	static Scanner userInput = new Scanner(System.in);
	
	// writer to write out the added information into the file
	static BufferedWriter writer;
	
	
	/**
	 * 
	 * Asks the user if they'd like to add information, then executes the collection of information
	 * and add the user's input at the bottom of the Super Bowl information file.
	 * 
	 * @throws IOException
	 */
	
	public static void addInfo() throws IOException
	{
		
		
		try {
            writer = new BufferedWriter(new FileWriter(sbInfoFile, true));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
		
		System.out.println("Would you like to add information of a new Super Bowl? (Y or N)");
		String response = userInput.next();
		
		
		if(!(response.equalsIgnoreCase("N")) && !(response.equalsIgnoreCase("Y")))
		{
			System.out.println("Enter Y for yes or N for no please.");
			response = userInput.next();
		}
		
		while(!(response.equalsIgnoreCase("N")))
		{
			setInputs();
			
			writer.newLine();
			writer.write(inputs[0]);
			
			for(int i = 1; i < inputs.length; i++)
			{
				writer.write(", " + inputs[i]);
				writer.flush();
			}
			
			
			System.out.println("Would you like to add another Super Bowl? (Y or N)");
			response = userInput.next();
		}
		
		
		startMenu.startScreen();
	}
	
	/**
	 * 
	 * Executes all information collection methods and assigns input values into the input array.
	 * 
	 * @throws FileNotFoundException
	 */
	
	public static void setInputs() throws FileNotFoundException
	{
		setSBNumber();
		setSBTeams();
		setScore();
		setWinner();
		setMVP();
		setYear();
		setLocation();
		
	}
	
	/**
	 * Asks the user for the user to input the Super Bowl number in which they would like to add
	 * and set the value of the input array's first element to the Roman numeral value of the user's input.
	 */
	
	public static void setSBNumber()
	{
		System.out.println("Enter the number of the Super Bowl (using decimal numbers): ");
		int sbNumber = userInput.nextInt();
		
		// While loops ensures that the user will enter a valid super bowl number that has not been already played
		// or that is an impossible. It will stay in the while loop until the user inputs a valid number.
		while(sbNumber < 58)
		{
			System.out.println("That is not a valid input, please try again.");
			sbNumber = userInput.nextInt();
		}
		
		inputs[0] = roman_to_integer.convertToRoman(sbNumber);
	}
	
	/**
	 * 
	 * Asks the user to input the names of the teams that played in the Super Bowl they are wishing to add
	 * and sets the value of the second inputs array element to be the teams playing.
	 * 
	 * @throws FileNotFoundException
	 */
	
	public static void setSBTeams() throws FileNotFoundException
	{
		String[] allTeamsTemp = FileInput.readFile(teamInfoFile);
		
		// Sets the elements of allTeams to be only the team name, and not the location of the team
		for(int i = 0; i < allTeamsTemp.length; i++)
		{
			String[] teamName = allTeamsTemp[i].split(" ");
			allTeams[i] = teamName[teamName.length - 1];
		}
		
		System.out.println("Enter the home team: ");
		String homeTeam = userInput.next();
		
		// Array of teams is sorted to properly perform the binary search in the following while loops
		Arrays.sort(allTeams);
		
		// While loop ensures that user enters the name of a team and 
		// stays in the while loop until the user's input is valid to it's constraints
		while(Arrays.binarySearch(allTeams, homeTeam) < 0)
		{
			System.out.println("That is not a valid input, please try again.");
			homeTeam = userInput.next();
		}
		
		System.out.println("Enter the away team: ");
		String awayTeam = userInput.next();
		
		// while loop ensures that the input is a team and that they are not entering the same twice and
		// stays in the while loop until the user's input is valid to it's constraints
		while(Arrays.binarySearch(allTeams, awayTeam) < 0 || awayTeam.equalsIgnoreCase(homeTeam))
		{
			System.out.println("That is not a valid input, please try again.");
			awayTeam = userInput.next();
		}
		
		
		inputs[1] = homeTeam + " vs. " + awayTeam;
	}
	
	/**
	 * Asks the user to input the score of the super bowl being added then sets the value
	 * of the third inputs array element to show the score.
	 */
	
	public static void setScore()
	{
		System.out.println("Enter the winning score: ");
		int winner = userInput.nextInt();
		
		System.out.println("Enter the losing score: ");
		int loser = userInput.nextInt();
		
		// Switches the value of the winner and loser if the losing score is set to be higher that the winning score
		if(loser > winner)
		{
			int temp = loser;
			loser = winner;
			winner = temp;
		}
		
		inputs[2] = String.valueOf(winner) + "-" + String.valueOf(loser);
	}
	
	/**
	 * Asks the user to input the team that won and set the value of the fourth inputs array element to be the winner.
	 */
	
	public static void setWinner()
	{
		System.out.println("Enter the name of the winning team: ");
		String winner = userInput.next();
		
		// Array of the 2 teams that the user previously entered, used for making sure the user enters a team that played
		String[] playingTeams = inputs[1].split(" vs. ");
		
		// while loop ensures that the user enters one of the 2 teams that played in the super bowl they are adding and
		// stays in the while loop until the user's input is valid
		while(Arrays.binarySearch(playingTeams, winner) < 0)
		{
			System.out.println("That is not a valid input, please try again.");
			winner = userInput.next();
		}
		
		inputs[3] = winner;
	}
	
	/**
	 * Asks the user for the name of the player which won the MVP of the Super Bowl they are adding and
	 * sets the value of the fifth inputs array element to the name of the MVP player.
	 */
	
	public static void setMVP()
	{
		System.out.println("Enter the name of the player than won the MVP: ");
		inputs[4] = userInput.next();
	}
	
	/**
	 * Asks the user for the year in which the super they are adding was played in and sets the value of
	 * the sixth inputs array element to be the year
	 */
	
	public static void setYear()
	{
		System.out.println("Enter the year the game was played: ");
		int year = userInput.nextInt(); 
		
		// While loop ensures the user enters a year after the most recently played Super Bowl and
		// stays in the while loop until the user's input is valid
		while(year < 2024)
		{
			System.out.println("That is not a valid input, please try again.");
			year = userInput.nextInt();
		}
		
		inputs[5] = String.valueOf(year);
	}
	
	/**
	 * Asks the user to input the name of the location in which the Super Bowl they are adding was played in
	 * and sets the value of the 7th inputs array element to the location.
	 */
	
	public static void setLocation()
	{
		System.out.println("Enter the location the game was played in: ");
		inputs[6] = userInput.next();
	}
	
}
