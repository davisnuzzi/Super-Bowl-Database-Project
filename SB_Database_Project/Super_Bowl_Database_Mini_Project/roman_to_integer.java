import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Davis Nuzzi
 * @version 1.0
 *
 */

public class roman_to_integer {
	
	// class and methods comes from leetcode solutions page and use of ChatGPT
	
	// creates a map to set letters to numbers based on correlation of Roman numerals
	private static final Map<Character, Integer> NUMS = new HashMap<Character, Integer>(){{
	    put('I', 1);
	    put('V', 5);
	    put('X', 10);
	    put('L', 50);
	    put('C', 100);
	    put('D', 500);
	    put('M', 1000);
	}};
	
	/**
	 * 
	 * Converts a given string of a Roman numeral to it's decimal value
	 * 
	 * @param s
	 * @return the value of the Roman numeral
	 */
	
	public static int convertToInt(String s) {
		int r = 0;
		int prev = 0;

		for (char c : s.toCharArray()) {
			int v = NUMS.get(c);
	        r = ((v > prev) ? r - prev + (v - prev) : r + v);
	        prev = v;
		}

		return r;
	}
	
	/**
	 * 
	 * Converts a given decimal value number to it's Roman numeral equivalent
	 * 
	 * @param x
	 * @return A string containing the Roman numeral
	 */
	
	public static String convertToRoman(int x)
	{
		int[] decimalValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < decimalValues.length; i++) {
            while (x >= decimalValues[i]) {
                x -= decimalValues[i];
                roman.append(romanNumerals[i]);
            }
        }

        return roman.toString();
	}
}
