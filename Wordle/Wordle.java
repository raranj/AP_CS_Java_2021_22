import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class implements the game of Wordle. 
 *
 * @author Ranjana Rajagopalan
 * @version 05/20/22
 */
public class Wordle
{
    ArrayList<String> words; // contains all 5 letter words 
    
    /**
     * Constructor for objects of class Wordle
     */
    public Wordle()
    {
        words = new ArrayList<String>();
    }
    
    /**
     * This method reads all of the words and adds them to an array list.
     * 
     * @param fileName - plain text file with list of five-letter words 
     */
    public void readWords(String fileName) {
        File file = new File(fileName);
        
        try {
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine());
            }
            
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * This method returns the list of words.  
     * 
     * @return words - ArrayList of ~5800 words with 5 letters
     */
    public ArrayList<String> getWords() {
        return words;
    }
    
    /**
     * This method generates a random number and returns the word 
     * from the corresponding index in the array list. 
     * 
     * @return word - chosen word from array list to be guessed 
     */
    public String getWord() {
        if (words.size() == 0) {
            return "";
        }
        
        int num = (int)(Math.random() * (words.size()));
        String word = words.get(num);
        return word;
    }
    
    /**
     * This method returns a string demonstrating which letters from the guess are accurate. 
     * 
     * @return answer - a string with length 5 consisting of letters, dashes, and asterisks symbolizing the accuracy of the letters in the guess 
     * 
     * The characters from the String answer:
     * A "-" means the letter from the guess is not in the word. 
     * A "*" means the letter from the guess is in the word, but in a different position. 
     * The letter itself means it is in the word and in the right position. 
     */
    public String getAnswer(String word, String guess) {
        String answer = "";
        // to keep track of whether a letter has already been guessed
        boolean[] check = {false, false, false, false, false}; // each index in the array represents one letter from the actual word 

        for (int i = 0; i < 5; i++) {
            int index = word.indexOf(guess.charAt(i)); // index of current letter from the guess in the actual word 
            char guessLetter = guess.charAt(i);
            char wordLetter = word.charAt(i);
            
            if (guessLetter == wordLetter) { // if the letter is correct and is in the right position
                answer += wordLetter;
                check[i] = true; // set the boolean index corresponding to this letter to say that it has been accounted for 
            }
            else if (index != -1) { // if the letter is in the word but wrong position 
                
                while (index != -1) {
                    // if there is already a matching letter at the position 
                    if ((check[index] == true) || (word.charAt(index) == guess.charAt(index))) {
                        index = word.indexOf(guessLetter, (index + 1));
                        continue; // keep checking for a matching letter that doesn't match in position until the end of the word 
                    }
                    else { // otherwise, the letter exists, but wrong position 
                        answer += "*";
                        check[index] = true;
                        break;
                    }
                }
                
                if (index == -1) { // if break out of loop, the letter does not exist a second time 
                    answer += "-";
                }
            }
            else { // letter does not exist in the word
                answer += "-";
            }
        }

        return answer;
    }
}
