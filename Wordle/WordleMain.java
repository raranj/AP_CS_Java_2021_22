import java.util.Scanner;
import java.lang.*;
import java.util.ArrayList;

/**
 * This class executes the Wordle game. 
 *
 * @author Ranjana Rajagopalan
 * @version 05/20/22
 */
public class WordleMain
{
    public static void main(String[] args) {
        Grid g = new Grid();
        Wordle w = new Wordle();
        String word;
        int row = 0; // keeps track of number of rounds
        boolean guessed = false;
        ArrayList<String> words;

        w.readWords("words.txt"); // words.txt file contains all words
        words = w.getWords(); // array list of all words
        
        word = w.getWord(); // randomly get a word 
        word = word.toUpperCase();
        
        // if there is an error getting the word 
        if (word.equals("")) { 
            System.out.println("Couldn't find a word. Exiting...");
            return;
        }
        
        explainRules();
        
        // draw five blank rows 
        for (int i = 0; i < 5; i++) {
            g.drawRow(i);
        }
        
        while ((row < 5) && (guessed == false)) { // while the user has not guessed the word and haven't passed the guess limit
            String guess = getGuess(words);
            
            String str = w.getAnswer(word, guess); // gives a string of "-", "*", and letters representing the right answers
            g.fillRow(str, row); // color the tiles based on whether the letters are correct or not 
            g.addLetters(guess, row); // add the text to the tiles 
            
            // check if the word has been guessed 
            if (str.equals(word)) {
                guessed = true;
            }
            
            row++; // move to next row 
        }
        
        if (guessed == true) { // if word was guessed 
            System.out.println("You guessed it! The word was " + word + "!");
            System.out.println("Thank you for playing!");
        }
        else { 
            System.out.println("Sorry! The word was " + word + ".");
            System.out.println("Try again next time!");
        }
    }
    
    /**
     * This method explains the rules of the game. 
     */ 
    
    public static void explainRules() {
        System.out.println("Welcome to a version of Wordle with only five attempts!");
        System.out.println("Your job is to guess the letters in a given word in five or less tries in order to win.");
        System.out.println("Your guess should be a valid five letter word.");
        System.out.println("After each guess, the color of the tiles will change to show how close your guess was to the word.");
        System.out.println("A green tile means the letter is in the word and in the right spot.");
        System.out.println("A yellow tile means the letter exists in the hidden word, but is in a different position.");
        System.out.println("A grey tile means the letter is not in the word at all.\n");
    }
    
    /**
     * This method gets a guess from the user that is a valid word and is five letters long.  
     */ 
    public static String getGuess(ArrayList<String> words) {
        Scanner input = new Scanner(System.in);
        String guess;
        boolean real = false;
        
        // word must be five letters long and must be a real word 
        do {
            System.out.println("Enter a valid, 5 letter word: ");
            guess = input.next();
            guess = guess.toLowerCase(); // words in the "words.txt" file are in lower case 
            
            // if the word is a real word from the array list of ~5800 words
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                
                if (guess.equals(word)) { // the guess is a real word 
                    real = true;
                }
            }
        } while ((guess.length() != 5) || (real == false)); 
    
        guess = guess.toUpperCase(); // to be displayed in upper case on the graphics screen
        
        return guess;
    }
}
