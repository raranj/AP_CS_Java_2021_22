import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LoveTest.
 *
 * @author  Joe Polacco
 * @version August 13, 2020
 */
public class LoveTest
{
    @Test
    public void testLoveNotHate(){      
        Love love = new Love();
        assertEquals("I love brussel sprouts.", love.loveNotHate("I hate brussel sprouts."));
        assertEquals("It's a love/love relationship.", love.loveNotHate("It's a love/hate relationship."));
        assertEquals("I love it when my dog licks me.", love.loveNotHate("I hate it when my dog licks me."));
        assertEquals("I love love love ice cream.", love.loveNotHate("I love love love ice cream."));
        assertEquals("Why do you love me? Do not hate me.", love.loveNotHate("Why do you hate me? Do not hate me."));    
    }
        
}