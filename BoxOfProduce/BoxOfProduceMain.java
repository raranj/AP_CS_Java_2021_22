import java.util.*;
import java.io.*;
import java.util.Scanner;

/**
 * This class prompts the user to decide the final three bundles of produce. 
 *
 * @author Ranjana Rajagopalan
 * @version 10/21/21
 */

public class BoxOfProduceMain
{
    public static void main(String[] args) 
    {
        int substitute = 1;
        String [] fiveProduceItems; // array of all 5 produce options
        String [] threeRandomBundles; // array of 3 randomly selected produce options
        Scanner keyboard = new Scanner(System.in);
        BoxOfProduceMain box = new BoxOfProduceMain();
        
        // read input file, and create box of produce with three randomly chosen produce options
        fiveProduceItems = box.returnProduce("FruitsAndVeggies.txt");
        threeRandomBundles = box.return3Bundles(fiveProduceItems);
        BoxOfProduce produceBox = new BoxOfProduce(threeRandomBundles[0], threeRandomBundles[1], threeRandomBundles[2]);  
        
        // display the contents of the box and prompt user to replace any one item
        System.out.println("The contents of your box are: \n1) " + threeRandomBundles[0] + "\n2) " + threeRandomBundles[1] + "\n3) " + threeRandomBundles[2]);
        System.out.println("Enter the number of the fruit or vegetable you would like to replace, or any other number if you do not want to replace anything:");
        int replace = keyboard.nextInt();
        
        // if user enters a valid option, ask which produce to replace the original with 
        if ((replace >= 1) && (replace <=3)) { 
            do {
                System.out.println("Enter the number of the fruit or vegetable you would like to replace it with: ");
                for (int i = 0; i < 5; i++) { // display all 5 produce options
                    System.out.println((i+1) + ") " + fiveProduceItems[i]);
                }
                substitute = keyboard.nextInt();
            } while (substitute < 1 || substitute > 5); // repeat until user enters a valid option
        }
        
        // replace the produce option chosen by user; if replace is not 1, 2, or 3, then don't do anything
        if (replace == 1) {
            produceBox.setProduce1(fiveProduceItems[substitute - 1]);
        }
        else if (replace == 2) {
            produceBox.setProduce2(fiveProduceItems[substitute - 1]);
        }
        else if (replace == 3) {
            produceBox.setProduce3(fiveProduceItems[substitute - 1]);
        }
        
        // print final contents of produce box
        System.out.println(produceBox);

    }
    
    /** 
     * This method takes the file name as an argument and returns an array 
     * with all the produce options from the file. 
     */
    public String [] returnProduce(String fileName) {
        File file = new File(fileName);
        String[] fiveProduceItems = new String[5];
        
        try 
        {
            Scanner scanner = new Scanner(file);

            for (int i = 0; i < 5; i++) {
                fiveProduceItems[i] = scanner.nextLine();
            }
            
            scanner.close();
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        
        return fiveProduceItems;
    }
    
    /** 
     * This method takes the array with all produce options
     * and randomly selects three to return in a separate array. 
     */
    public String [] return3Bundles(String [] produceOptions) {
        String[] chosenBundles = new String[3];
        int num;
        
        for (int i = 0; i < 3; i++) {
            num = (int)(Math.random() * 4) + 1;
            chosenBundles[i] = produceOptions[num];
        }
        
        return chosenBundles;
    }
}
