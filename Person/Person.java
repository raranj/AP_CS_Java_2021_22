/**
 * This class is used to represent a person's information.
 *
 * @author Ranjana Rajagopalan
 * @version 01/17/22
 */
public class Person
{
    String firstName, lastName;

    /**
     * Constructor for objects of class Person
     */
    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // accessor methods to get the name of the person
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    // mutator methods to set the name of the person
    public void setFirstName(String first)
    {
        firstName = first;
    }
    
    public void setLastName(String last)
    {
        lastName = last;
    }
    
    /**
     * This method outputs the first and last name of the person. 
     */
    public void displayDetails()
    {
         System.out.println("\nThis person's name is: " + firstName + " " + lastName);
    }
}
