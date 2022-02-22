/**
 * Which is more likely: at least one 6 in 6 rolls of a fair die,
 * or at least two 6's in 12 rolls of a fair die?
 * DO NOT solve this as a math problem (you can of course). This is a computation
 * problem. Estimate the probabilities through simulation.
 * 
 * @author Ranjana Rajagopalan
 * @version 10/06/21
 * 
 */

public class Pepys
{    
    /**  
     * @param n the number of simulations (experiments) to run
     * (A simulation is rolling a die 6 times.)
     * @return the estimated likelihood of rolling at least one 6 in 6 rolls of a fair die
     */
    public double probAtLeastOneSix(int n){
        // TODO
        // e.g. one simulation might be: 1 4 4 2 6 1 (success -- at least one six)
        // e.g. 6 6 2 2 1 2 (success -- at least one six)
        // e.g. 1 2 5 5 3 4 (failure -- no sixes)
        // return (number of successes) / (number of simulations)
        int randomNum, numSuccess = 0;
        double probability;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                randomNum = (int)(Math.random() * 6) + 1; // creates random int between 1 and 6
                
                if (randomNum == 6) {
                    numSuccess++;
                    break; // if a six is found, leave inner loop
                }
            }
        }
        
        probability = ((double)numSuccess) / n;
        return probability;
    }
    
     /**
     * @param n the number of simulations (experiments) to run
     * (A simulation is rolling a die 12 times.)
     * @return the estimated likelihood of rolling at least two 6's in 12 rolls of a fair die
     */
    public double probAtLeastTwoSixes(int n){
        // TODO
        // e.g. one simulation might be: 1 4 4 2 6 1 6 1 1 1 1 2 (success -- at least two sixes)
        // e.g. 6 6 2 2 1 2 1 1 1 1 1 6 (success -- at least two sixes)
        // e.g. 1 2 5 5 3 4 4 1 2 4 5 6 (failure -- less than two sixes)
        // return (number of successes) / (number of simulations)
        
        int randomNum, numSuccess = 0, numSixes;
        double probability;
        
        for (int i = 0; i < n; i++) {
            numSixes = 0;
            for (int j = 0; j < 12; j++) {
                randomNum = (int)(Math.random() * 6) + 1;
                
                if (randomNum == 6) {
                    numSixes++;
                }
                
                if (numSixes >= 2) { // if number of sixes is 2, then the roll is a success 
                    numSuccess++;
                    break; // if two sixes rolled, stop counting
                }
            }
        }
        
        probability = ((double)numSuccess) / n;
        return probability;
    }
}
        
        