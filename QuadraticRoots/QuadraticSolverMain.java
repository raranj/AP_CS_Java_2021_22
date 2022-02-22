/**
 * Write a program that calculates the real roots of a quadratic polynomial
 * in the form ax^2 + bx + c = 0. Prompt the user for input.
 * 
 * For example, a possible sample dialogue might be the following:
 * Enter coefficients for the quadratic ax^2 + bx + c = 0.
 * a = 1
 * b = 0
 * c = -4
 * 
 * roots are 2.0 and -2.0
 * 
 * If the quadratic has no real roots, output "no real roots"
 * 
 * 
 * @author Ranjana Rajagopalan
 * @version 09/22/21
 */
public class QuadraticSolverMain
{
    public static void main(String[] args){
        QuadraticSolver solver = new QuadraticSolver();
        
        System.out.println(solver.roots(0, 21, 3));
        System.out.println(solver.roots(2, 4, 2));
        System.out.println(solver.roots(54, -43, 85));
        System.out.println(solver.roots(1, -3, 2));
    }
}