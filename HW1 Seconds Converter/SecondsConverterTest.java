import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SecondsConverterTest.
 *
 * @author Ranjana Rajagopalan
 * @version September 7, 2021
 */
public class SecondsConverterTest
{
    @Test
    public void testSecondsToHMS(){
        SecondsConverter converter = new SecondsConverter();
        assertEquals("13 hours, 59 minutes, and 51 seconds", converter.secondsToHMS(50391));
        assertEquals("0 hours, 16 minutes, and 40 seconds", converter.secondsToHMS(1000));
        assertEquals("2 hours, 46 minutes, and 40 seconds", converter.secondsToHMS(10000));        
        assertEquals("34 hours, 17 minutes, and 36 seconds", converter.secondsToHMS(123456));
        assertEquals("15 hours, 5 minutes, and 21 seconds", converter.secondsToHMS(54321));
        assertEquals("12 hours, 0 minutes, and 0 seconds", converter.secondsToHMS(43200));
        assertEquals("5 hours, 19 minutes, and 0 seconds", converter.secondsToHMS(19140));
         
    }
    
}