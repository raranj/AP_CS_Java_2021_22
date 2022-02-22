/**
 * This class tests the Student and Teacher classes. 
 *
 * @author Ranjana Rajagopalan
 * @version 01/18/22
 */
public class PersonMain
{
    public static void main(String[] args)
    {
        Student student1 = new Student("Hermione", "Granger", 1979, "arithmancy", "Prof. Vector");
        Student student2 = new Student("Harry", "Potter", 0731, "divination", "Prof. Trelawney");
        
        Teacher teacher1 = new Teacher("Severus", "Snape", "potions", 00.00);
        Teacher teacher2 = new Teacher("Minerva", "McGonagall", "transfiguration", 100000.00);  
        
        student1.displayDetails();
        student2.displayDetails();
        teacher1.displayDetails();
        teacher2.displayDetails();
    }
}
