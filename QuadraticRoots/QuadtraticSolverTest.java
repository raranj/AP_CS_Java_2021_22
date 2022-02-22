import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class QuadtraticSolverTest.
 *
 * @author  Joe Polacco
 * @version August 15, 2020
 */
public class QuadtraticSolverTest
{
    @Test
    public void testRoots(){
        QuadraticSolver quad = new QuadraticSolver();
        assertEquals("roots are 2.0 and -2.0", quad.roots(1,0,-4)); 
        assertEquals("roots are 0.5 and -1.5", quad.roots(4,4,-3)); 
        assertEquals("no real roots" , quad.roots(1,0,4));
        assertEquals("roots are 2.5 and -3.0" , quad.roots(2,1,-15));
        assertEquals("roots are -3.5 and -4.5", quad.roots(4,32,63));
       
    }
        
}