import java.util.*;
import java.io.*;

/**
 * Benford's law, or the first-digit law, is an observation about the frequency
 * distribution of leading digits in many real-life sets of numerical data. The law states
 * that in many naturally occurring collections of numbers, the leading digit is likely to
 * be small. For example, in sets that obey the law, the number 1 appears as the leading
 * significant digit about 30% of the time, while 9 appears as the leading significant
 * digit less than 5% of the time. If the digits were distributed uniformly, they would
 * each occur about 11.1% of the time. Benford's law also makes predictions about the
 * distribution of second digits, third digits, digit combinations, and so on.
 * 
 * Write a program that tests Benford’s Law. You will use data from two different real-life 
 * data sources. The data is stored in two separate text files: sunspots.txt and librarybooks.txt
 * Feel free to try this program out on other large sets of data!
 * 
 * You will loop through the list of numbers and count how many times 1 is the first
 * digit, 2 is the first, etc...
 * 
 * Your output/results should look like this:
 * 
 * Analysis of sunspot data:
 * Percentage of numbers starting with 1: 28.24%
 * Percentage of numbers starting with 2: 12.04%
 * Percentage of numbers starting with 3: 9.99%
 * Percentage of numbers starting with 4: 10.34%
 * Percentage of numbers starting with 5: 9.92%
 * Percentage of numbers starting with 6: 8.36%
 * Percentage of numbers starting with 7: 6.28%
 * Percentage of numbers starting with 8: 6.38%
 * Percentage of numbers starting with 9: 5.63%
 * 
 * Analysis of library book data:
 * Percentage of numbers starting with 1: 33.44%
 * Percentage of numbers starting with 2: 17.57%
 * Percentage of numbers starting with 3: 11.14%
 * Percentage of numbers starting with 4: 8.77%
 * Percentage of numbers starting with 5: 7.00%
 * Percentage of numbers starting with 6: 6.13%
 * Percentage of numbers starting with 7: 5.49%
 * Percentage of numbers starting with 8: 5.50%
 * Percentage of numbers starting with 9: 4.95%
 * 
 * @author Ranjana Rajagopalan 
 * @version 10/06/21
 */
public class BenfordsLaw
{
    public static void main(String[] args){
       
        System.out.println("According to Benford's Law, one might expect the following frequency of first digits");
        System.out.println("************************************************************************************");
        final double[]  freq = {0.0, 30.1, 17.6, 12.5, 9.7, 7.9, 6.7, 5.8, 5.1, 4.6};
        
        for (int i = 1; i <=9; i++)
            System.out.println("Percentage of numbers starting with " + i + ": " + freq[i] + "%");
        System.out.println();
        System.out.println("Analysis of sunspot data:");
        printFirstDigitsSunSpots("sunspots.txt");
        System.out.println();
        System.out.println("Analysis of library book data:");
        printFirstDigitsLibraryBooks("librarybooks.txt");
    }
    
    /**
     * Opens a file for input and prints out the frequency of 1 as a first digit, 2 as a first digit,
     * 3 as a first digit, and so forth
     */ 
    private static void printFirstDigitsLibraryBooks(String fileName)
    {
        // Location of file to read
        File file = new File(fileName);
        
        int totalLines = 0;
        int[] freq = new int[10];
        int firstDigit, numLines = 0;

        try 
        {
            Scanner scanner = new Scanner(file);
            // flush out the first 4 lines in the text file
            for (int i = 0; i < 4; i++)
                scanner.nextLine();
                
            while (scanner.hasNextLine())
            {
                // TODO:
                // Read in the next line and make note of the first digit in a running tally
               String line = scanner.nextLine();
               numLines++;
               firstDigit = line.charAt(0) - '0'; // converts character to integer
               
               freq[firstDigit]++;
            }

            scanner.close();
        } 
        
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        
        // TODO: 
        // Print out the results of your tally as as a percentage.
        // It should look something like this:
        //
        // Analysis of library book data:
        // Percentage of numbers starting with 1: 33.44%
        // Percentage of numbers starting with 2: 17.57%
        // Percentage of numbers starting with 3: 11.14%
        // Percentage of numbers starting with 4: 8.77%
        // Percentage of numbers starting with 5: 7.00%
        // Percentage of numbers starting with 6: 6.13%
        // Percentage of numbers starting with 7: 5.49%
        // Percentage of numbers starting with 8: 5.50%
        // Percentage of numbers starting with 9: 4.95%
        
        System.out.printf("Percentage of numbers starting with 1: %.2f%%\n", ((((double) freq[1]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 2: %.2f%%\n", ((((double) freq[2]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 3: %.2f%%\n", ((((double) freq[3]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 4: %.2f%%\n", ((((double) freq[4]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 5: %.2f%%\n", ((((double) freq[5]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 6: %.2f%%\n", ((((double) freq[6]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 7: %.2f%%\n", ((((double) freq[7]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 8: %.2f%%\n", ((((double) freq[8]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 9: %.2f%%\n", ((((double) freq[9]) / numLines) * 100));
    }
    
    /**
     * Opens a file for input and prints out the frequency of 1 as a first digit, 2 as a first digit,
     * 3 as a first digit, and so forth
     */ 
    private static void printFirstDigitsSunSpots(String fileName)
    {
        // Location of file to read
        File file = new File(fileName);
        //List<String> movies = new ArrayList<String>();
        
        int totalLines = 0;
        int[] freq = new int[10];
        int firstDigitIndex, firstDigit, numLines = 0;
        
        try 
        {
            Scanner scanner = new Scanner(file);
            
            //flush out the first 3 lines of the file
            for (int i = 0; i < 3; i++)
                scanner.nextLine();
                
            while (scanner.hasNextLine())
            {
                // TODO:
                // Read in the next sunpsot count and make note of the first digit in a running tally
                // Note: Each line of data looks something like this:   (* Month: 1749 05 *) 85
                // Notice that the integer you are interested comes at the end of the line.
                // You might use your String methods to extract the character of interest (i.e. '8')
                // Then you might want to convert the char '8' to an int type. How? 
                String line = scanner.nextLine();
                firstDigitIndex = line.indexOf(")");
                numLines++;
               
               if (firstDigitIndex == -1) {
                   continue; // go to next line in txt file if ")" is not present
               }
               
               firstDigit = line.charAt(firstDigitIndex + 2) - '0'; // convert character to integer
               
               freq[firstDigit]++;
            }
            
            scanner.close();
        }
    
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        // TODO: 
        // Print out the results of your tally as as a percentage.
        // It should look something like this:
        //
        // Analysis of sunspot data:
        // Percentage of numbers starting with 1: 28.24%
        // Percentage of numbers starting with 2: 12.04%
        // Percentage of numbers starting with 3: 9.99%
        // Percentage of numbers starting with 4: 10.34%
        // Percentage of numbers starting with 5: 9.92%
        // Percentage of numbers starting with 6: 8.36%
        // Percentage of numbers starting with 7: 6.28%
        // Percentage of numbers starting with 8: 6.38%
        // Percentage of numbers starting with 9: 5.63%
        
        System.out.printf("Percentage of numbers starting with 1: %.2f%%\n", ((((double) freq[1]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 2: %.2f%%\n", ((((double) freq[2]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 3: %.2f%%\n", ((((double) freq[3]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 4: %.2f%%\n", ((((double) freq[4]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 5: %.2f%%\n", ((((double) freq[5]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 6: %.2f%%\n", ((((double) freq[6]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 7: %.2f%%\n", ((((double) freq[7]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 8: %.2f%%\n", ((((double) freq[8]) / numLines) * 100));
        System.out.printf("Percentage of numbers starting with 9: %.2f%%\n", ((((double) freq[9]) / numLines) * 100));
    }
}

