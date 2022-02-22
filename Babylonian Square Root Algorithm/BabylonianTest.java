import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BabylonianTest.
 *
 * @author  Ranjana Rajagopalan
 * @version 09/15/21
 */
public class BabylonianTest
{
    @Test
    public void testSquareRoot(){
        Babylonian b = new Babylonian();
        //assertEquals(expected, actual, precision)
        assertEquals(10.000046356507898, b.squareRoot(100), 0.000000000001);
        assertEquals(3.162277660168379, b.squareRoot(10), 0.000000000001);
        assertEquals(22.504959637875427, b.squareRoot(500),  0.000000000001);
        assertEquals(32.72195679634224, b.squareRoot(999), 0.000000000001);
        
    }
}
