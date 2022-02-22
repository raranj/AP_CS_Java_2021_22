import java.util.Scanner;
import java.lang.*;

/**
 * This class implements a command line version of the game Hangman. 
 *
 * @author Ranjana Rajagopalan
 * @version 11/28/21
 */
public class HangmanMain
{
    public static void main(String[] args) { 
        HangmanString hString = new HangmanString();
        String phrase, hiddenPhrase;
        int numLetters;
        
        hString.readPhrases("MovieNames.txt"); // MovieNames.txt file contains all phrases
        phrase = hString.getPhrase(); // randomly get a phrase
        
        if (phrase.equals("")) { 
            System.out.println("Could'nt find a movie name. Exiting...");
            return;
        }
        
        explainRules();
        hiddenPhrase = hidePhrase(phrase); // replaces letters in phrase by asterisks
        
        System.out.println("\nHere is the mystery movie: \n" + hiddenPhrase);
        
        numLetters = numAsterisks(hiddenPhrase);
        guessString(phrase, hiddenPhrase, numLetters); // play the game
    }
    
    /**
     * This method explains the rules of the game. 
     */ 
    
    public static void explainRules() {
       System.out.println("In this game, you will be given a mystery movie name coded by a series of asterisks.");
       System.out.println("Your job is to guess the letters in the name of the movie in as little tries as possible.");
       System.out.println("If you guess all the letters of the movie title with less than 8 strikes, you win. Otherwise, the game ends and you lose.");
       System.out.println("You will be prompted when to guess a letter and also how many strikes you have left and the letters guessed from previous turns.");
    }
    
    /**
     * This method converts the phrase that is to be guessed into a hidden phrase represented by asterisks and the appropriate punctuation. 
     * 
     * @param phrase - original phrase that is to be converted into a series of asterisks and punctation
     * 
     * @return hidden - phrase created by converting letters into asterisks for the user to guess
     */
    public static String hidePhrase(String phrase) {
        char current;
        String hidden = ""; 
        
        for (int i = 0; i < phrase.length(); i++) {
           current = phrase.charAt(i); 
           
           if (((current >= 'a') && (current <= 'z')) || ((current >= 'A') && (current <= 'Z'))) {
               hidden += "*";
           }
           else {
               hidden += current;
           }
           
        }
        
        return hidden;
    } 
    
    /**
     * This method counts the number of asterisks in the hidden phrase.
     * 
     * @param hiddenPhrase - phrase containing the asterisks and punctuation created from the original phrase
     * 
     * @return numLetters - the number of asterisks corresponds to the number of letters in the phrase
     */
    public static int numAsterisks(String hiddenPhrase) {
        char current; 
        int numLetters = 0;
        
        for (int i = 0; i < hiddenPhrase.length(); i++) {
            current = hiddenPhrase.charAt(i);
            
            if (current == '*') {
                numLetters++;
            }
        }
        
        return numLetters;
    }
    
    /**
     * This method prompts the user to guess a letter that could be in the phrase. 
     * 
     * @return guess, character entered by the user that is going to be checked for presence in the phrase
     */
    public static char getGuess() {
        Scanner userGuess = new Scanner(System.in);
        System.out.println("\nGuess a letter: ");
        char guess = userGuess.next().charAt(0); // input a character from the user
        
        while (((guess < 'a') || (guess > 'z')) && ((guess < 'A') || (guess > 'Z'))) {
            System.out.println("You did not enter a letter. Please try again.");
            guess = userGuess.next().charAt(0);
        } 
        
        return guess;
    }
    
    /**
     * This method displays the hidden phrase and prompts the user to guess the letters it contains. 
     * 
     * @param phrase - original phrase that was randomly selected, used to update StringBuilder
     * @param hiddenPhrase - phrase converted into asterisks, converted into StringBuilder to be updated throughout the game
     * @param numLetters - number of asterisks the hidden phrase contains, used to check whether all the letters have been guessed
     */
    public static void guessString(String phrase, String hiddenPhrase, int numLetters) {
        StringBuilder hidden = new StringBuilder(); 
        hidden.append(hiddenPhrase); // converting hidden phrase into StringBuilder
        int strike = 0, guessedLetters = 0, length = hidden.length(), wrongGuessesLength;
        char guess, current, wrong; 
        boolean correct, oldGuess;
        String wrongGuessList = ""; // list of wrong guesses by user
        
        do {
            guess = getGuess();
            correct = false; // tracks if guess was correct or wrong
            
            for (int i = 0; i < length; i++) { // goes through every character in hidden phrase 
                current = phrase.charAt(i);
                
                // convert both characters to lower case to check for equality 
                current = Character.toLowerCase(current);
                guess = Character.toLowerCase(guess);
                
                if (current == guess) { // if the letter guessed by the user is in the phrase
                    correct = true;
                    
                    if (hidden.charAt(i) == '*') { // check if it is the first time this letter has been guessed
                        guessedLetters++; // increment the total number of letters that have been guessed
                        
                        hidden.setCharAt(i, phrase.charAt(i)); // replace the asterisk with the correct letter in hidden phrase
                    }
                    else { // if user has guessed right letter more than once
                        System.out.println("You have already guessed this letter.");
                        break; 
                    }
                }
            }
            
            // oldGuess keeps track of whether user has guessed the same incorrect letter more than once
            oldGuess = false;
            
            if (correct == false) { // if the guessed letter is not in the word
                wrongGuessesLength = wrongGuessList.length();
                
                // loop checks whether they have guessed the same wrong letter more than once
                for (int i = 0; i < wrongGuessesLength; i += 2) {
                    wrong = wrongGuessList.charAt(i);
                    
                    if (wrong == guess) { // if user has already guessed the letter
                        System.out.println("You have already guessed this letter."); 
                        oldGuess = true;
                        break; 
                    }
                }
                
                // if the user hasn't guessed this letter yet and it is wrong, add it to the list of wrong guesses
                if (oldGuess != true) {
                    wrongGuessList += (guess + " ");
                    strike++;
                }
                
                // tell the user that it is wrong and the number of strikes 
                System.out.println(guess + " is not in the phrase.");
                System.out.println("You are at " + strike + " strike(s), and have " + (8 - strike) + " chance(s) left.");
            }
            else {
                System.out.println("The letter " + guess + " is in the word.");
            }
            
            System.out.println("\nHere are the wrong guesses: " + wrongGuessList); // display list of wrong guesses
            System.out.println("\n" + hidden.toString()); // display to the user the string updated with the potentially new characters
            
            // keep repeating until user has used up all strikes or has guessed the word
        } while ((strike < 8) && (guessedLetters < numLetters)); 
        
        // if the user didn't guess the word, display that they lost
        if (strike >= 8) {
            System.out.println("\nSorry, you have reached 8 strikes and the game is over.");
            System.out.println("The movie was: " + phrase);
        }
        
        // if the user guessed the word within 8 strikes, display that they won
        if (guessedLetters >= numLetters) {
            System.out.println("\nYou won! The movie was: " + phrase);
            System.out.println("Thank you for playing!");
        }
    }
}
