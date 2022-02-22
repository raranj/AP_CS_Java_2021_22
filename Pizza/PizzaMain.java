/**
 * This class tests the Pizza class. 
 *
 * @author Ranjana Rajagopalan
 * @version 10/19/21
 */
public class PizzaMain
{
    /**
     * Constructor for objects of class PizzaMain
     */
    public PizzaMain()
    {
        Pizza pizza1 = new Pizza("small", 5, 0, 2);
        Pizza pizza2 = new Pizza("medium", 0, 3, 4);
        Pizza pizza3 = new Pizza("large", 5, 0, 8);
        
        System.out.println(pizza1.getDescription());
        System.out.println(pizza2.getDescription());
        System.out.println(pizza3.getDescription());
        
        // testing mutator methods
        pizza1.setPizzaSize("large");
        pizza1.setnumCheeseToppings(3);
        pizza1.setnumPeppToppings(2);
        pizza1.setnumHamToppings(1);
        
        System.out.println(pizza1.getDescription());
    }
}