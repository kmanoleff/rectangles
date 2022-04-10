import org.junit.Assert;
import org.junit.Test;

public class InputValidationTests {
    // input string[] should be translated to int[]
    @Test
    public void testProcessValidInput() {
        Assert.assertArrayEquals(
                "Process a valid input",
                Main.getInputAsInts(new String[]{"0","0","4","4","1","1","2","2"}),
                new int[]{0,0,4,4,1,1,2,2}
        );
    }

    // incorrect length of input should return null
    @Test
    public void testNotEnoughCoordinates() {
        Assert.assertNull(
                "Input length is incorrect",
                Main.getInputAsInts(new String[]{"0"})
        );
    }

    // any argument can't be formatted to int should return null
    @Test
    public void testNonIntegerProvided() {
        Assert.assertNull(
                "One or more inputs not a number",
                Main.getInputAsInts(new String[]{"0","a","4","4","b","1","2","2"})
        );
    }
}