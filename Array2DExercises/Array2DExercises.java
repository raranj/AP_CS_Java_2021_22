/**
 * This class performs various exercises related to 2D  arrays. 
 *
 * @author Ranjana Rajagopalan
 * @version 10/31/21
 */

public class Array2DExercises 
{
    // returns the maximum value in the 2d parameter array 
    public static int max(int[][] a) 
    {
        int max = a[0][0];
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                }
            }
        }
        
        return max;
    }

    // returns the sum of the elements in row r of a. 
    public static int rowSum(int[][] a, int r)
    {
        int sum = 0;
        
        for (int c = 0; c < a[r].length; c++) {
            sum += a[r][c];
        }
        
        return sum;
    }

    // returns the sum of the elements in column c of a (careful with rows of different lengths!).
    public static int columnSum(int[][] a, int c)
    {
        int sum = 0;
        
        for (int r = 0; r < a.length; r++) {
            if (c < a[r].length) { // if the column exists for this specific row
                sum += a[r][c];
            }
        }
        
        return sum;
    }
    
    // calculates the row sum for every row and returns each of the values in an array. 
    // index i of the return array contains the sum of elements in row i.
    public static int[] allRowSums(int[][] a)
    {
        int[] sums = new int[a.length]; // new array with length being number of rows in array a
        int sum;
        
        for (int r = 0; r < a.length; r++) {
            sum = 0; // reset sum for every row
            
            for (int c = 0; c < a[r].length; c++) {
                sum += a[r][c];
            }
            
            sums[r] = sum; 
        }
        
        return sums; 
    }
        
    // checks if the array is row-magic (this means that every row has the same row sum).
    public static boolean isRowMagic(int[][] a)
    {
        int sum,rowSum = 0;
        
        for (int r = 0; r < a.length; r++) {
            sum = 0;
            
            for (int c = 0; c < a[r].length; c++) {
                sum += a[r][c];
            }
            
            if (r == 0) { // set rowSum equal to sum only when r is 0 as a comparison for each new sum
                rowSum = sum;
            }
            else if (sum != rowSum) { // for every new row sum compare against the original
                return false;
            }
        }
        
        return true;
    }

    // checks if the array is column-magic (this means that every column has the same column sum).
    public static boolean isColumnMagic(int[][] a)
    {
        int sum, colSum = 0;
        
        for (int c = 0; c < a[0].length; c++) {
            sum = 0;
            
            for (int r = 0; r < a.length; r++) {
                sum += a[r][c];
            }
            
            if (c == 0) { // set colSum equal to sum only when c is 0 as a comparison for each new sum
                colSum = sum;
            }
            else if (sum != colSum) { // for every new column sum compare against the original
                return false;
            }
        }
        
        return true;
    }
    
    // checks if the array is square (i.e. every row has the same length as a itself).
    public static boolean isSquare(int[][] a)
    {
        for (int r = 0; r < a.length; r++) {
            if (a[r].length != a.length) { // compare length of every row to number of rows to see if equal
                return false;
            }
        }
        return true;
    }

    // checks if the array is a magic square. This means that it must be square, 
    // and that all row sums, all column sums, and the two diagonal-sums must all be equal.
    public static boolean isMagic(int[][] a)
    {
        int diagonalOneSum = 0, diagonalTwoSum = 0, rowSum = 0, colSum = 0;
        
        // check prior conditions, and return false if not satisfied
        if (isSquare(a) == false) {
            return false;
        }
        
        if (isRowMagic(a) == false) {
            return false;
        }
        
        if (isColumnMagic(a) == false) {
            return false;
        }
        
        // if prior checks are true, calculate diagonal sums
        for (int c = 0; c < a[0].length; c++) {
            rowSum += a[0][c];
        }
        
        for (int r = 0; r < a.length; r++) {
            colSum += a[r][0];
        }
        
        for (int i = 0; i < a.length; i++) {
            diagonalOneSum += a[i][i];
        }
        
        for (int r = 0; r < a.length; r++) {
            diagonalTwoSum += a[r][a.length - 1 - r];
        }
        
        // check if diagonal sums are equal to each other
        if (diagonalOneSum != diagonalTwoSum) {
            return false;
        }
        
        // check whether rowSum, columnSum, and diagonalSums are all equal
        if (rowSum != colSum) {
            return false;
        }
        
        if (rowSum != diagonalOneSum) {
            return false;
        }
        
        return true;
    }
}
