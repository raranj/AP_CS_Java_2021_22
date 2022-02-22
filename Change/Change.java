/**
 * This class converts cents to the number of quarters, dimes, and nickels.
 * 
 * @author Ranjana Rajagopalan 
 * @version 09/15/21
 */
public class Change{
   /**
    * converts cents to quarters, dimes, nickels
    * 
    * precondition: cents is between 0 and 75, inclusive
    * 
    * @param cents the number of cents
    * @return a String in the form "q quarters, d dimes, and n nickels"
    */ 
    public String cashInCoins(int cents){
        String numCoins = " ";
        int quarters, dimes, nickels;
        if ((cents >= 0) && (cents <= 75)) {
            quarters = cents / 25;
            numCoins = (quarters + " quarters, ");
            cents -= (quarters * 25);
            dimes = cents / 10;
            numCoins += (dimes + " dimes, and ");
            cents -= (dimes * 10);
            nickels = cents / 5;
            numCoins += (nickels + " nickels");
        }
        else {
            System.out.println("Number of cents must be from 0 to 75"); 
        }
        
        return numCoins;
    }
        
}