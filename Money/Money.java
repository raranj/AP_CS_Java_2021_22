/**
 * This class contains information about money in dollars and cents. 
 *
 * @author Ranjana Rajagopalan
 * @version 01/31/22
 */
public class Money
{
    private int dollars, cents;

    // constructors
    public Money(int dollars, int cents)
    {
        this.dollars = dollars;
        this.cents = cents;
    }
    
    public Money(int dollars)
    {
        this.dollars = dollars;
        cents = 0;
    }
    
    public Money()
    {
        dollars = 0;
        cents = 0;
    }
    
    // mutator methods for amount of dollars and cents
    public void setDollars(int dollars) 
    {
        this.dollars = dollars;
    }
    
    public void setCents(int cents)
    {
        this.cents = cents;
    }
    
    // accessor methods to get dollars and cents
    public int getDollars()
    {
        return dollars;
    }
    
    public int getCents()
    {
        return cents;
    }
    
    // This method adds two given amounts of money together
    // and returns the resulting amount of money in dollars and cents.
    public static Money add(Money m1, Money m2) 
    {
        int theDollars = m1.getDollars() + m2.getDollars();
        int theCents = m1.getCents() + m2.getCents();
        
        if (theCents >= 100) {
            theCents -= 100;
            theDollars += 1;
        }
        
        Money m3 = new Money(theDollars, theCents);
        
        return m3;
    }
    
    // This method subtracts the smaller amount of money from the larger
    // and returns the resulting amount of money in dollars and cents.
    public static Money minus(Money m1, Money m2) 
    {
        int m1Cents = m1.getTotalCents();
        int m2Cents = m2.getTotalCents();
        int max, min, theCents, theDollars;
        
        if (m1Cents >= m2Cents) {
            max = m1Cents;
            min = m2Cents;
        }
        else {
            max = m2Cents;
            min = m1Cents;
        }
        
        theCents = max - min;
        theDollars = theCents / 100;
        theCents %= 100;
 
        Money m3 = new Money(theDollars, theCents);
        
        return m3;
    }

    // This method is the non-static version of the add method above.
    public Money add(Money m2) 
    {
        return add(this, m2);
    }
    
    // This method is the non-static version of the minus method above. 
    public Money minus(Money m2) 
    {
        return minus(this, m2);
    }
    
    public boolean equals(Money other)
    {
        if ((dollars == other.getDollars()) && (cents == other.getCents())) 
        {
            return true;
        }
        
        return false;
    }
    
    public String toString()
    {
        if (cents < 10) {
            return ("The amount of money in dollars and cents is: $" + dollars + ".0" + cents + "\n");
        }
        
        return ("The amount of money in dollars and cents is: $" + dollars + "." + cents + "\n");
    }
    
    private int getTotalCents() {
        return ((dollars*100) + cents); // return total amount of money in cents
    }
}
