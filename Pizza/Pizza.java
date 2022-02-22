/**
 * This class determines the cost of a pizza based on the number of toppings. 
 *
 * @author Ranjana Rajagopalan
 * @version 10/19/21
 */
public class Pizza
{
    String pizzaSize;
    int numCheese, numPepp, numHam;
    
    /**
     * Constructor for objects of class Pizza
     */
    public Pizza(String pizzaSize, int numCheese, int numPepp, int numHam)
    {
        this.pizzaSize = pizzaSize;
        this.numCheese = numCheese;
        this.numPepp = numPepp;
        this.numHam = numHam;
    }
    
    // accessor methods to return size of pizza and number of toppings
    public String getPizzaSize() {
        return pizzaSize;
    }
    
    public int getnumCheeseToppings() {
        return numCheese;
    }

    public int getnumPepperoniToppings() {
        return numPepp;
    }

    public int getnumHamToppings() {
        return numHam;
    }
    
    // mutator methods to set number of toppings and size
    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }
    
    public void setnumCheeseToppings(int numCheese) {
        this.numCheese = numCheese;
    }
    
    public void setnumPeppToppings(int numPepp) {
        this.numPepp = numPepp;
    }
    
    public void setnumHamToppings(int numHam) {
        this.numHam = numHam;
    }
    
    public double calcCost() { // method that calculates total cost of pizza
        int totalPriceToppings = 2 * (numCheese + numPepp + numHam);
        double pizzaCost;
        
        if (pizzaSize == "small") {
            pizzaCost = 10 + totalPriceToppings;
        }
        else if (pizzaSize == "medium") {
            pizzaCost = 12 + totalPriceToppings;
        }
        else { // defaults to large if random size is entered 
            pizzaCost = 14 + totalPriceToppings;
        }
        
        return pizzaCost;
    }
    
    public String getDescription() { // returns String representation of order and cost of pizza
        String order = ("You ordered a " + pizzaSize + " pizza with " + numCheese + " cheese toppings, " + numPepp + " pepperoni toppings, and " + numHam + " ham toppings.\n");
        String cost = ("Your total cost will be $" + calcCost() + ".");
        
        return (order + cost);
    }
}
