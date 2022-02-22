/**
 * This class contains information specifically about trucks. 
 *
 * @author Ranjana Rajagopalan
 * @version 01/22/22
 */
public class Truck extends Vehicle
{
    private double loadCapacity;
    private int towCapacity;

    /**
     * Constructor for objects of class Truck
     */
    public Truck(double loadCapacity, int towCapacity, String name, int numCylinders, String ownerName) {
        super(name, numCylinders, ownerName);
        this.loadCapacity = loadCapacity;
        this.towCapacity = towCapacity;
    }
    
    // mutator methods to set variables
    public void setLoadCapacity(double loadCapacity)
    {
        this.loadCapacity = loadCapacity;
    }
    
    public void setTowCapacity(int towCapacity)
    {
        this.towCapacity = towCapacity;
    }
    
    // accessor methods to return variables
    public double getLoadCapacity()
    {
        return loadCapacity;
    }
    
    public int getTowCapacity()
    {
        return towCapacity;
    }
    
    public boolean equals(Truck other)
    {
        if ((super.equals(other)) && (loadCapacity == other.getLoadCapacity()) && (towCapacity == other.getTowCapacity())) {
            return true;
        }
        
        return false;
    }
    
    public String toString() 
    {
        return (super.toString() + "The towing capacity of the truck is " + towCapacity + " pounds, and the load capacity in tons is " + loadCapacity);
    }
}
