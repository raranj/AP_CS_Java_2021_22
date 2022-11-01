import java.awt.Font; // for text on screen

/**
 * This class displays the graphics of the game. 
 *
 * @author Ranjana Rajagopalan
 * @version 05/20/22
 */
public class Grid // nothing to initialize in constructor 
{
    /**
     * This method creates an initial row of 5 squares.
     * 
     * @param row - the row to be drawn  
     */
    public void drawRow(int row) {
       for (int i = 0; i < 5; i++) {
           StdDraw.pause(100); // pause for 100 ms in between each square 
           StdDraw.setPenColor(128, 128, 128); // grey color 
           StdDraw.square((0.1 + (0.2*i)), (0.9 - (0.2*row)), 0.08); // draws a square
       }
    }
    
    /**
     * This method fills the squares based on the accuracy of the guess.
     * 
     * @ param ans - String of dashes, asterisks, and letters that show whether the letters are accurate or not
     * @ param row - the row that should be filled 
     */
    public void fillRow(String ans, int row) {
        for (int i = 0; i < 5; i++) {
           StdDraw.pause(500);
           
           if (ans.charAt(i) == '-') { // if the letter is not there, fill the square with grey 
               StdDraw.setPenColor(128, 128, 128);
           }
           else if (ans.charAt(i) == '*') { // if the letter is present but in the wrong position, fill the square with yellow
               StdDraw.setPenColor(212, 181, 80);
           }
           else { // if the letter is correct and in the right position, fill the square with green
               StdDraw.setPenColor(75, 139, 59);
           }
           
           StdDraw.filledSquare((0.1 + (0.2*i)), (0.9 - (0.2*row)), 0.08); // fill the square
       }
    }
    
    /**
     * This method populates the squares with the corresponding guessed letters. 
     * 
     * @param word - the word guessed by the user to be entered into the row of squares
     * @param row - the row to be populated
     */
    public void addLetters(String word, int row) {
        Font font = new Font("Sans Serif", Font.BOLD, 30); // change font and font size 
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < 5; i++) { 
            StdDraw.text((0.1 + (0.2*i)), (0.9 - (0.2*row)), word.substring(i, i+1)); // draw a letter at the center of every square 
        }
    }
}
