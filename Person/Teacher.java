/**
 * This class contains specific information about teachers. 
 *
 * @author Ranjana Rajagopalan
 * @version 01/18/22
 */
public class Teacher extends Person
{
    String subject;
    double salary;

    /**
     * Constructor for objects of class Teacher
     */
    public Teacher(String firstName, String lastName, String subject, double salary)
    {
        super(firstName, lastName);
        this.subject = subject;
        this.salary = salary;
    }
    
    // accessor methods that get the subject and salary of the teacher
    public String getSubject()
    {
        return subject;
    }
    
    public double getSalary()
    {
        return salary;
    }
    
    // mutator methods that set the subject and salary of the teacher
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    
    public void setSalary(double salary)
    {
        this.salary = salary;
    }
    
    /**
     * This method returns the information about a person, specifically a teacher. 
     */
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println(firstName + " " + lastName + " teaches the subject: " + subject);
        System.out.println(firstName + "'s salary is: " + salary);
    }
}
