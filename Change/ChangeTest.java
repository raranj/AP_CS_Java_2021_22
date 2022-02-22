import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ChangeTest.
 *
 * @author  Joe Polacco
 * @version August 15, 2020
 */
public class ChangeTest
{
    @Test
    public void testCashInCoins(){
        Change change = new Change();
        //assertEquals(expected, actual)
        assertEquals("0 quarters, 1 dimes, and 1 nickels", change.cashInCoins(15) );
        assertEquals("1 quarters, 0 dimes, and 1 nickels", change.cashInCoins(30));
        assertEquals("1 quarters, 2 dimes, and 0 nickels", change.cashInCoins(45));
        assertEquals("3 quarters, 0 dimes, and 0 nickels", change.cashInCoins(75));
        assertEquals("0 quarters, 0 dimes, and 1 nickels", change.cashInCoins(5));
        assertEquals("2 quarters, 1 dimes, and 1 nickels", change.cashInCoins(65));
    }
}