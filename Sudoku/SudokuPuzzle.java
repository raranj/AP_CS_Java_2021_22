/**
 * The class SudokuPuzzle has all the methods to implement a game of Sudoku. 
 *
 * @author Ranjana Rajagopalan
 * @version 12/20/21
 */
public class SudokuPuzzle
{
    int[][] board = new int[9][9]; // Sudoku 9 by 9 puzzle board
    boolean[][] start = new boolean[9][9]; // 2D boolean array represents which values can't be changed and which can
    int[][][] puzzles = new int[2][9][9]; // array of 2D arrays with initial puzzle configurations
    
    /**
     * Constructor for objects of class SudokuPuzzle
     */
    public SudokuPuzzle()
    {
        int num = (int)(Math.random() * 2) + 1;
        
        // set all values in board to 0 and all values in start to true (to be changed later)
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                board[r][c] = 0;
                start[r][c] = true;
            }
        }
        
        // set all values in puzzles to 0
        for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    puzzles[0][r][c] = 0;
                    puzzles[1][r][c] = 0;
                }
        }
        
        // initial puzzle configuration option 1
        puzzles[0][0][0] = 7;
        puzzles[0][0][2] = 4;
        puzzles[0][0][5] = 8;
        puzzles[0][1][1] = 8;
        puzzles[0][1][3] = 7;
        puzzles[0][1][7] = 6;
        puzzles[0][2][0] = 3;
        puzzles[0][2][1] = 1;
        puzzles[0][2][4] = 9;
        puzzles[0][2][5] = 4;
        puzzles[0][3][0] = 8;
        puzzles[0][3][1] = 2;
        puzzles[0][3][2] = 3;
        puzzles[0][3][5] = 6;
        puzzles[0][3][6] = 5;
        puzzles[0][4][0] = 9;
        puzzles[0][4][1] = 5;
        puzzles[0][4][2] = 7;
        puzzles[0][4][4] = 4;
        puzzles[0][4][5] = 2;
        puzzles[0][4][7] = 3;
        puzzles[0][4][8] = 6;
        puzzles[0][5][2] = 1;
        puzzles[0][5][8] = 7;
        puzzles[0][6][0] = 1;
        puzzles[0][6][1] = 3;
        puzzles[0][6][2] = 8;
        puzzles[0][6][3] = 2;
        puzzles[0][6][8] = 4;
        puzzles[0][7][0] = 4;
        puzzles[0][7][1] = 7;
        puzzles[0][7][2] = 6;
        puzzles[0][7][3] = 3;
        puzzles[0][7][5] = 5;
        puzzles[0][7][6] = 9;
        puzzles[0][7][8] = 2;
        puzzles[0][8][1] = 9;
        puzzles[0][8][2] = 2;
        puzzles[0][8][3] = 4;
        puzzles[0][8][5] = 7;
        puzzles[0][8][8] = 3;
        
        // initial puzzle configuration option 2
        puzzles[1][0][3] = 8;
        puzzles[1][0][5] = 5;
        puzzles[1][0][7] = 4;
        puzzles[1][0][8] = 2;
        puzzles[1][1][1] = 4;
        puzzles[1][1][3] = 9;
        puzzles[1][1][5] = 7;
        puzzles[1][1][7] = 1;
        puzzles[1][1][8] = 5;
        puzzles[1][2][1] = 6;
        puzzles[1][2][3] = 4;
        puzzles[1][2][5] = 3;
        puzzles[1][2][7] = 8;
        puzzles[1][3][0] = 1;
        puzzles[1][3][4] = 9;
        puzzles[1][3][5] = 6;
        puzzles[1][4][2] = 9;
        puzzles[1][4][5] = 1;
        puzzles[1][4][7] = 3;
        puzzles[1][5][1] = 2;
        puzzles[1][5][2] = 4;
        puzzles[1][5][3] = 5;
        puzzles[1][5][4] = 7;
        puzzles[1][5][8] = 6;
        puzzles[1][6][0] = 7;
        puzzles[1][6][2] = 6;
        puzzles[1][6][3] = 1;
        puzzles[1][6][6] = 5;
        puzzles[1][6][7] = 2;
        puzzles[1][7][0] = 4;
        puzzles[1][7][3] = 7;
        puzzles[1][7][8] = 1;
        puzzles[1][8][1] = 8;
        puzzles[1][8][4] = 5;
        puzzles[1][8][5] = 9;
        puzzles[1][8][6] = 4;
        puzzles[1][8][8] = 3;
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (puzzles[num-1][r][c] != 0) {
                    addInitial(r, c, puzzles[num-1][r][c]);  
                }
            }
        }
    }

    /**
     * This method sets the given square to the given value as an initial value that cannot be changed. 
     *
     * @param row - row of puzzle square
     * @param col - column of puzzle square
     * @param value - value assigned to the square
     */
    public void addInitial(int row, int col, int value)
    {
        board[row][col] = value;
        start[row][col] = false;
    }
    
    /**
     * This method sets the given square to the given value that can be changed later if it is not one of the original values. 
     *
     * @param row - row of puzzle square
     * @param col - column of puzzle square
     * @param value - value assigned to the square
     * @return - whether the guess has been succesfully added to the board or not
     */
    public boolean addGuess(int row, int col, int value)
    {
        // if the value user wants to change is a starting value
        if (start[row][col] == false) {
            if (value != board[row][col]) { // if the value is different from the initial configuration value  
                return false;
            }
            // if value user wants to change it to is the same as the initial configuration value
            return true;
        }
        
        board[row][col] = value; // add the user's guess to the board
        return true;
    }
    
    /**
     * This method checks if the values in the puzzle satisfy the restrictions. 
     *
     * @return true if rules are satisfied, and false otherwise
     */
    public boolean checkPuzzle()
    {
        // check each row and column to see if rules are met
        for (int i = 0; i < 9; i++) {
            if (checkRow(i) == false) {
                return false;
            }
            if (checkCol(i) == false) {
                return false;
            }
        }
        
        // check each 3 by 3 subgroup to see if rules are met
        for (int r = 0; r <= 6; r += 3) {
            for (int c = 0; c <= 6; c += 3) {
                if (checkSub(r, c) == false) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * This method returns the value in the given square. 
     *
     * @param row - row of puzzle square
     * @param col - column of puzzle square
     * @return the value at the given square
     */
    public int getValueIn(int row, int col)
    {
        return board[row][col];
    }
    
    /**
     * This method returns a 1D array of booleans corresponding to a digit, and is true if the digit
     * can be placed in the given square without violating the restrictions. 
     *
     * @param row - row of puzzle square
     * @param col - column of puzzle square
     */
    public boolean [] getAllowedValues(int row, int col)
    {
        boolean[] allowed = new boolean[9];
        int temp = board[row][col]; // storing value at this square so it can be reset later
        
        // if the given value is a starting digit, then set all indices to false except that of the starting digit
        if (start[row][col] == false) { 
            for (int i = 0; i < 9; i++) {
                if ((i + 1) == board[row][col]) {
                    allowed[i] = true;
                }
                else {
                    allowed[i] = false;
                }
            }
            
            return allowed;
        }
        
        // if the given value can be changed, then check whether it satisfies the restrictions
        // and set corresponding index to true or false
        for (int i = 0; i < 9; i++) {
            board[row][col] = (i + 1);
            allowed[i] = checkPuzzle();
        }
        
        board[row][col] = temp; // change value back to what it was 
        return allowed;
    }
    
    /**
     * This method checks if every square has a value. 
     *
     * @return true if every digit has a value, and false otherwise
     */
    public boolean isFull()
    {
        // go through whole board and return false if there is still a 0
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == 0) { 
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * This method changes all of the nonpermanent squares back to blanks.
     */
    public void reset()
    {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (start[r][c] == true) { // if the square is not permanent, set it back to 0
                    board[r][c] = 0;
                }
            }
        }
    }
    
    /**
     * This method returns a string representation of the puzzle that can be printed. 
     */
    public String toString()
    {   
        String str = "";
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                str += (board[r][c] + " ");
            }
            str += "\n";
        }
        
        return str;
    }
    
    /**
     * This method checks a 3 by 3 subgroup to see if it meets the restrictions. 
     * 
     * @return true whether rules are met, and false otherwise
     */
    private boolean checkSub(int startRow, int startCol)
    {   
        boolean[] check = new boolean[10];
        
        for (int i = 0; i < 10; i++) {
            check[i] = false;
        }
        
        // if a digit is seen for the first time, set its index in array check to true
        // for every following digit seen, check if its index is already set to true
        // if it's true, then the digit has been repeated, so return false
        // otherwise, set the digit's index to true
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (check[(board[startRow + i][startCol + j])] == true) {
                    return false;
                }
                if (board[startRow + i][startCol + j] != 0) {
                    check[(board[startRow + i][startCol + j])] = true;
                }
            }
        }
        
        return true;
    }
    
    /**
     * This method checks a given row to see if it meets the restrictions. 
     * 
     * @ param row - row to be checked
     * @ return true if the rules are met, and false otherwise
     */
    private boolean checkRow(int row)
    {   
        boolean[] check = new boolean[10];
        
        // set every index to false
        for (int i = 0; i < 10; i++) {
            check[i] = false;
        }
        
        // if digit has been seen twice, index of array check should be true, and method will return false
        // if digit is new, corresponding index in check will be set to true
        for (int c = 0; c < 9; c++) {
            if (check[(board[row][c])] == true) {
                return false;
            }
            if (board[row][c] != 0) {
                check[(board[row][c])] = true;
            }
        }
        
        return true;
    }
    
    /**
     * This method checks a given column to see if it meets the restrictions. 
     * 
     * @ param col - column to be checked
     * @ return true if the rules are met, and false otherwise
     */
    private boolean checkCol(int col)
    {   
        boolean[] check = new boolean[10];
        
        // set every index to false
        for (int i = 0; i < 10; i++) {
            check[i] = false;
        }
        
        // if digit has been seen twice, index of array check should be true, and method will return false
        // if digit is new, corresponding index in check will be set to true
        for (int r = 0; r < 9; r++) {
            if (check[(board[r][col])] == true) {
                return false;
            }
            if (board[r][col] != 0) {
                check[(board[r][col])] = true;
            }
        }
        
        return true;
    }
}

