import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
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
	 * @throws IOException
	 */
	
	public static void showFile(String filename) throws IOException
	{
		try (var lines = Files.lines(Path.of(filename), StandardCharsets.UTF_8)) {
			lines.forEach(System.out::println);
		}
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
		List<String> lines = new ArrayList<>();
		
		try (Scanner sc = new Scanner(new File(filename), StandardCharsets.UTF_8.name())) 
		{
			while (sc.hasNextLine()) 
			{
				lines.add(sc.nextLine());
			}
		}
		
		return lines.toArray(new String[0]);
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

		for (int i = 0; i < rawData.length; i++) 
		{
			// Split on commas with optional surrounding spaces; keep empty trailing fields
			String[] parts = rawData[i].split("\\s*,\\s*", -1);

			for (int j = 0; j < 7; j++) {
				matrix[i][j] = (j < parts.length) ? parts[j].trim() : "";
			}
		}
		return matrix;
	}
}
