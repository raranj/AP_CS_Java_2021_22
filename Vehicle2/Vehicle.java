/**
 * The vehicle class has information about the manufacturer of the vehicle, the number of cylinders, and the owner.
 *
 * @author Ranjana Rajagopalan
 * @version 01/22/22
 */
public class Vehicle
{
    private String name;
    private int numCylinders;
    private Person owner;

    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle(String name, int numCylinders, String ownerName)
    {
        this.name = name;
        this.numCylinders = numCylinders;
        this.owner = new Person(ownerName);
    }

    // mutator methods to set variables
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setCylinders(int numCylinders)
    {
        this.numCylinders = numCylinders;
    }
    
    public void setOwner(Person newOwner)
    {
        owner = new Person(newOwner);
    }
    
    // accessor methods to return variables
    public String getName()
    {
        return name;
    }
    
    public int getCylinders()
    {
        return numCylinders;
    }
    
    public Person getOwner()
    {
        return (owner);
    }
    
    public boolean equals(Vehicle other)
    {
        if ((name.equals(other.getName())) && (numCylinders == other.getCylinders()) && (owner.equals(other.getOwner()))) {
            return true;
        }
        
        return false;
    }
    
    public String toString()
    {
      String Manufacturer = ("The manufacturer of this vehicle is " + name + "\n");
      String Cylinders = ("This vehicle has " + numCylinders + " cylinders in the engine.\n");
      String Owner = ("The owner of this vehicle is " + owner.getName() + "\n");
      
      return (Manufacturer + Cylinders + Owner);
    }
    
}
