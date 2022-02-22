import java.util.*;
import java.io.*;
import java.util.ArrayList;

/**
 * This class contains methods that read in the phrases and return a String to be guessed. 
 *
 * @author Ranjana Rajagopalan
 * @version 11/28/21
 */
public class HangmanString
{
    ArrayList<String> phrases; // contains all movie names 
    
    /**
     * Constructor for objects of class HangmanString
     */
    public HangmanString()
    {
        phrases = new ArrayList<String>();
    }

    /**
     * This method reads all of the movie names and adds them to an array list. 
     * 
     * @param fileName - plain txt file with list of movies
     */
    public void readPhrases(String fileName) {
        File file = new File(fileName);
        
        try {
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                phrases.add(scanner.nextLine());
            }
            
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * This method generates a random number and returns the phrase from the corresponding index in the array list. 
     * 
     * @return phrase - chosen phrase from array list to be guessed 
     */
    public String getPhrase() {
        if (phrases.size() == 0) {
            return "";
        }
        
        int num = (int)(Math.random() * (phrases.size()));
        String phrase = phrases.get(num);
        return phrase;
    }
}
