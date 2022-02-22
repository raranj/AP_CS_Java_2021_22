import java.util.Scanner;

/**
 * This class implements a game of Sudoku.
 *
 * @author Ranjana Rajagopalan
 * @version 12/20/21
 */
public class SudokuMain
{
    public static void main(String[] args) { 
        SudokuPuzzle game = new SudokuPuzzle();
        Scanner input = new Scanner(System.in);
        int row, col, value, option;
        boolean[] allowedValues; // to store all the digits allowed at a certain square
        boolean check; 
        
        explainRules();
        
        do {
            System.out.println("\n" + game); // print the board
            
            // give options to the user
            System.out.println("Enter one of the following options: ");
            System.out.println("0                - reset the board");
            System.out.println("1                - get values allowed in certain row and column");
            System.out.println("any other number - enter a digit at a certain row and column");
            
            option = input.nextInt(); // input user's pick
            
            // reset the board to the initial configuration
            if (option == 0) {
                game.reset();
                continue;
            }
            
            // get row and column from user
            do {
                System.out.println("Enter the row and the column (0 - 8): ");
                row = input.nextInt();
                col = input.nextInt();
            } while (((row < 0 || row > 8)) || ((col < 0) || (col > 8)));
            
            allowedValues = game.getAllowedValues(row, col); // store all the allowed values in an array
            
            // display allowed values to user
            if (option == 1) {
                System.out.println("The allowed values at row " + row + " and column " + col + " are: ");
                for (int i = 0; i < 9; i++) {
                    if (allowedValues[i] == true) {
                        System.out.printf((i + 1) + " ");
                    }
                }
                System.out.println("\n");
                continue; 
            }
            
            // get digit from user
            do {
                System.out.println("Enter the digit (1 - 9): ");
                value = input.nextInt();
            } while ((value < 1) || (value > 9));
            
            if (allowedValues[value - 1] == true) { // if digit meets the rule, add it to the board
                check = game.addGuess(row, col, value);
                
                if (check == false) { // if user wants to change permanent digit, say its permanent
                    System.out.println("This value can't be changed as it is a part of the initial configuration of the board.");
                }
            }
            else { 
                System.out.println("The digit does not satisfy the rules of the game.");
            }
            
        } while ((game.isFull() != true) && (game.checkPuzzle() == true));
        
        System.out.println("Congrats! You solved the puzzle!");
    }
    
    /**
     * This method explains the rules of the game. 
     */ 
    
    public static void explainRules() {
        System.out.println("This is a classic game of Sudoku.");
        System.out.println("The digits you are supposed to change are temporarily filled in with a 0.");
    }
}
