
/**
 * This class tests the Truck Class. 
 *
 * @author Ranjana Rajagopalan
 * @version 01/27/22
 */
public class VehicleMain
{
    public static void main(String[] args)
    {
        boolean equal2, equal3;
        
        Truck truck1 = new Truck(1.53, 4000, "Ford", 7, "Billy"); 
        Truck truck2 = new Truck(0.98, 6025, "Daimler", 6, "Bob");
        
        Truck truck3 = new Truck(1.53, 4000, "Ford", 7, "Billy"); 
        
        equal2 = truck1.equals(truck2);
        equal3 = truck1.equals(truck3);
        
        System.out.println(truck1);
        System.out.println("\n" + truck2);
        System.out.println("\n" + truck3 + "\n");
        
        if (equal2 == true) {
            System.out.println("Truck 1 and truck 2 are the same.");
        }
        else {
            System.out.println("Truck 1 and truck 2 are not the same.");
        }
        
        if (equal3 == true) {
            System.out.println("Truck 1 and truck 3 are the same.");
        }
        else {
            System.out.println("Truck 1 and truck 3 are not the same.");
        }
        
        // testing mutator methods
        truck2.setLoadCapacity(1.53);
        truck2.setTowCapacity(4000);
        truck2.setName("Ford");
        truck2.setCylinders(7);
        truck2.setOwner(new Person("Billy"));
        
        System.out.println("\n" + truck2);
        equal2 = truck1.equals(truck2);
        
        if (equal2 == true) {
            System.out.println("\nTruck 1 and truck 2 are the same.");
        }
        else {
            System.out.println("\nTruck 1 and truck 2 are not the same.");
        }
    }
}
