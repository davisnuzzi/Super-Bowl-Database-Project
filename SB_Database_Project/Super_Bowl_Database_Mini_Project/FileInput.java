import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class FileInput {
	
	/**
	 * 
	 * Reads in a file and prints its contents into the console for the user to see.
	 * 
	 * @param filename
	 * @throws FileNotFoundException
	 */
	
	public static void showFile(String filename) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File (filename));
		
		while(file.hasNextLine())
		{
			System.out.println(file.nextLine());
		}

		file.close();
	}
	
	/**
	 * 
	 * Reads in a file and stores its contents into an array and returns it.
	 * 
	 * @param filename
	 * @return the array in which the contents of the file are stored
	 * @throws FileNotFoundException
	 */
	
	public static String[] readFile(String filename) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File (filename));
			
		int lines = 0;
			
		// initializes how many lines are in the file to set the array size to
		while (file.hasNextLine()) 
		{
			lines++;
			file.nextLine();
		}
			
		file.close();
			
		file = new Scanner(new File (filename));
		
		String[] sbList = new String[lines];
		
		// stores the contents of the file into the array
		for (int i = 0; i < lines; ++i) 
		{
			sbList[i] = file.nextLine(); 
		}

		file.close();
			
		return sbList;
				
	}
	
	/**
	 * 
	 * Creates a matrix where each column represents a specific piece of information to each Super Bowl and
	 * each row represents a certain Super Bowl.
	 * 
	 * @param filename
	 * @return a matrix the contents of the contents of the file
	 * @throws FileNotFoundException
	 */
	
	public static String[][] buildDataMatrix(String filename) throws FileNotFoundException
	{
		
		String[] rawData = readFile(filename);
		
		String[][] matrix = new String[rawData.length][7];
		
		// separates each piece of information in the file and gets rid of an unnecessary white space 
		for(int i = 0; i < rawData.length; i++)
		{
			matrix[i] = rawData[i].split(", ");
			
			for(int j = 0; j < 7; j++)
			{
				matrix[i][j].trim();
			}
		}
		
		
		
		return matrix;
		
	}
}
