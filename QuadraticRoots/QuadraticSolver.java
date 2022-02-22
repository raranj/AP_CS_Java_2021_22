/**
 * This class returns the roots of a quadratic function of the form ax^2+bx+c.
 * 
 * @author Ranjana Rajagopalan 
 * @version 09/22/21
 */
public class QuadraticSolver
{
    /**
     * returns the roots of ax^2 + bx + c = 0 in the format:
     * "roots are r1 and r2"
     * (where r1 >= r2)
     * 
     * if the roots are non-real, returns "no real roots"
     * 
     * precondition: a is non-zero 
     */
    public String roots(double a, double b, double c){
        if (a == 0) { // denominator can't be 0
            return "a must be a non-zero number.";
        }
        
        if (((b*b) - (4*a*c)) < 0) { // check if discriminant is positive
            return "no real roots";
        }
        
        double root1, root2;
        
        root1 = (((-1*b) + (Math.sqrt((b*b) - (4*a*c)))) / (2*a));
        root2 = (((-1*b) - (Math.sqrt((b*b) - (4*a*c)))) / (2*a));
        
        if (((b*b) - (4*a*c)) == 0) { // if discriminant is 0, only 1 root 
            return ("root is " + root1);
        }
        
        if (root1 > root2) { // display based on which root is real
            return ("roots are " + root1 + " and " + root2);
        }
        else {
            return ("roots are " + root2 + " and " + root1); 
        }
    }
}
