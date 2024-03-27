import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Super_Bowl_Project_Test {

    @Test
    void testDisplaySuperBowlData() {
        // Test displaying Super Bowl data
        // This test should check if the Super Bowl data is displayed correctly
        // We can check if specific Super Bowl information matches the expected output
        
        // Assuming the first Super Bowl data is displayed correctly
        String expectedOutput = "I, Packers vs. Chiefs, 35-10, Packers, Bart Starr, 1967, Los Angeles";
        assertEquals(expectedOutput, Super_Bowl_Project.displaySuperBowlData(1));
        
        // Add more assertions for other Super Bowls if needed
    }

    @Test
    void testListTeams() {
        // Test listing teams
        // This test should check if the list of teams is displayed correctly
        // We can verify if the number of teams matches the expected count
        // We can also check if specific teams are present in the list
        
        // Assuming the list of teams is correctly displayed
        String teamList = Super_Bowl_Project.listTeams();
        assertTrue(teamList.contains("New England Patriots"));
        assertTrue(teamList.contains("Dallas Cowboys"));
        assertEquals(32, teamList.split("\n").length); // Assuming there are 32 teams in total
    }

    @Test
    void testRomanToIntegerConversion() {
        // Test Roman to Integer conversion
        // This test should check if the conversion from Roman numerals to integers is correct
        // We can provide various Roman numerals as input and verify the output
        
        // Assuming the Roman to Integer conversion is correct
        assertEquals(14, Super_Bowl_Project.convertRomanToInteger("XIV"));
        assertEquals(69, Super_Bowl_Project.convertRomanToInteger("LXIX"));
        assertEquals(1000, Super_Bowl_Project.convertRomanToInteger("M"));
        assertEquals(3999, Super_Bowl_Project.convertRomanToInteger("MMMCMXCIX"));
    }

    @Test
    void testIntegerToRomanConversion() {
        // Test Integer to Roman conversion
        // This test should check if the conversion from integers to Roman numerals is correct
        // We can provide various integers as input and verify the output
        
        // Assuming the Integer to Roman conversion is correct
        assertEquals("XIV", Super_Bowl_Project.convertIntegerToRoman(14));
        assertEquals("LXIX", Super_Bowl_Project.convertIntegerToRoman(69));
        assertEquals("M", Super_Bowl_Project.convertIntegerToRoman(1000));
        assertEquals("MMMCMXCIX", Super_Bowl_Project.convertIntegerToRoman(3999));
    }
}
