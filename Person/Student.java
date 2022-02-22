/**
 * This class contains information specifically about students. 
 *
 * @author Ranjana Rajagopalan
 * @version 01/18/22
 */
public class Student extends Person
{
    int studentID;
    String course, teacher;

    /**
     * Constructor for objects of class Student
     */
    public Student(String firstName, String lastName, int studentID, String course, String teacher)
    {
        super(firstName, lastName);
        this.studentID = studentID;
        this.course = course;
        this.teacher = teacher;
    }
    
    // accessor methods that get the ID, course name, and teacher of the student
    public int getID()
    {
        return studentID;
    }
    
    public String getCourse()
    {
        return course;
    }

    public String getTeacher()
    {
        return teacher;
    }
    
    // mutator methods that set the ID, course name, and teacher of the student
    public void setID(int ID)
    {
        studentID = ID;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }
    
    public void setTeacher(String teacher)
    {
        this.teacher = teacher;
    }
    
    /**
     * This method displays the information about a person, specifically a student. 
     */
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println(firstName + "'s student ID is: " + studentID);
        System.out.println("The course " + firstName + " is taking is: " + course);
        System.out.println(firstName + "'s teacher is: " + teacher);
    }
}
