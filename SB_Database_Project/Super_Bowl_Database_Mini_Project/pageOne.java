import java.io.IOException;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class pageOne{
	
	// name of file to draw information of super bowls
	final static String sbInfoFile = "superbowl-information.txt";
	
	/**
	 *
	 * Reads the contents of the Super Bowl information file and prints it into the console
	 * then returns to the start menu screen.
	 * 
	 * @throws IOException
	 */
	
	public static void firstPage() throws IOException
	{
		FileInput.showFile(sbInfoFile);
		System.out.println();
		startMenu.startScreen();
	}
	
}
