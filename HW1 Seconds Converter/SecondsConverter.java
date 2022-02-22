/**
 * This class converts seconds to hours, minutes, and seconds. 
 * 
 * @author Ranjana Rajagopalan
 * @version September 7, 2021
 */
public class SecondsConverter
{
    /**
     * Converts seconds to hours, minutes, and seconds.
     * For example, if seconds = 50391 the method should return the following String:
     * "13 hours, 59 minutes, and 51 seconds"
     * 
     * @param seconds - number of seconds
     * @return a String represenation in hours, minutes, and seconds
     */
   
    String secondsToHMS(int seconds){
       String converted;
       int hours, minutes, remainingSeconds, sec;
       
       hours = seconds/3600;
       remainingSeconds = seconds % 3600;
       minutes = (remainingSeconds / 60);
       sec = (remainingSeconds % 60); 

       converted = (hours + " hours, " + minutes + " minutes, and " + sec + " seconds");
       
       return converted;
    }
        
        
        
}