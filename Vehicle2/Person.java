/**
 * This class contains information about the person. 
 *
 * @author Ranjana Rajagopalan
 * @version 01/22/22
 */
public class Person
{
    private String name;
    
    /**
     * Constructor for objects of class Person
     */
    public Person()
    {
        name = ""; // unknown name
    }
    
    public Person(String theName)
    {
        name = theName;
    }
    
    public Person(Person theObject)
    {
        name = theObject.getName();
    }
    
    public String getName() 
    {
        return name;
    }
    
    public void setName(String theName)
    {
        name = theName;
    }
    
    public String toString()
    {
      return ("The person's name is " + name); 
    }
    
    public boolean equals(Person other)
    {
        return name.equals(other.getName()); 
    }
}
