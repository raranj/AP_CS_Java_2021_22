/**
 * This class uses the TemperatureConverter class   
 * to convert degrees in Fahrenheit to Celsius.
 * 
 * @author Ranjana Rajagopalan 
 * @version September 6, 2021
 */
public class TemperatureConverterMain
{
    public static void main(String[] args){
        
        TemperatureConverter converter = new TemperatureConverter();
        
        System.out.println("212 degrees Fahrenheit is equivalent to " +
            converter.fToC(212) + " degrees Celsius.");
            
        System.out.println("98.6 degrees Fahrenheit is equivalent to " + 
            converter.fToC(98.6) + " degrees Celsius.");
            
        System.out.println("-40 degrees Fahrenheit is equivalent to " + 
            converter.fToC(-40) + " degrees Celsius.");
            
        System.out.println("68 degrees Fahrenheit is equivalent to " +
            converter.fToC(68) + " degrees Celsius.");
            
        TemperatureConverterTest test = new TemperatureConverterTest();
        
        test.testFToCPositive();
        test.testFToCNegative();
        test.testFToCZero();
    }
}

