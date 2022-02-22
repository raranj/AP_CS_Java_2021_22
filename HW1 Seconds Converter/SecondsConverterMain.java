/**
 * This class uses the SecondsConverter class to convert seconds to hours, minutes, and seconds.  
 * 
 * @author Ranjana Rajagopalan
 * @version September 7, 2021
 */
public class SecondsConverterMain
{
    public static void main(){
        SecondsConverter converter = new SecondsConverter();
        
        System.out.println("50,391 seconds is equivalent to " + converter.secondsToHMS(50391));
        
        System.out.println("7200 seconds is equivalent to " + converter.secondsToHMS(7200));
        
        System.out.println("25 seconds is equivalent to " + converter.secondsToHMS(25));
        
        System.out.println("180 seconds is equivalent to " + converter.secondsToHMS(180));
        
        System.out.println("132 seconds is equivalent to " + converter.secondsToHMS(132));
        
        System.out.println("23275 seconds is equivalent to " + converter.secondsToHMS(23275));
    }
}