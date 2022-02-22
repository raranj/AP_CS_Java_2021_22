/**
 * This class tests the Money class. 
 *
 * @author Ranjana Rajagopalan
 * @version 01/31/22
 */
public class MoneyMain
{
    public static void main(String[] args)
    {
        boolean equal2, equal3;
        
        Money m1 = new Money(123, 54);
        Money m2 = new Money(234, 53);
        
        Money m4 = Money.add(m1, m2);
        Money m5 = Money.minus(m2, m1);
        Money m6 = m1.add(m2);
        Money m7 = m1.minus(m2);
        Money m8 = m2.minus(m1);
        
        equal2 = m1.equals(m2);
        
        System.out.println(m1);
        System.out.println(m2);
        
        
        if (equal2 == true) {
            System.out.println("The first two amounts of money are equal.\n");
        }
        else {
            System.out.println("The first two amounts of money are not equal.\n");
        }
        
        // testing mutator methods
        m2.setDollars(123);
        m2.setCents(54);
        
        equal2 = m1.equals(m2);
        System.out.println("The second amount has been modified to $123.54\n");
        if (equal2 == true) {
            System.out.println("The two amounts of money are equal.\n");
        }
        else {
            System.out.println("The two amounts of money are not equal.\n");
        }
        
        System.out.println("Sum of the two amounts:");
        System.out.println(m4);
        System.out.println("Difference of the two amounts:");
        System.out.println(m5);
        System.out.println("The sum and difference of these amounts of money using the non-static methods: \n");
        System.out.println(m6);
        System.out.println(m7);
        System.out.println(m8);
        
        equal3 = m7.equals(m8);
        if (equal3 == true) {
            System.out.println("The last two amounts of money are equal.\n");
        }
        else {
            System.out.println("The last two amounts of money are not equal.\n");
        }
    }
}
