
/**
 * This class tests the StudentRecord class. 
 *
 * @author Ranjana Rajagopalan
 * @version 10/13/21
 */
public class studentRecordMain
{
    public static void main(String[] args){
         studentRecord student1 = new studentRecord("Mark", 5.9, 8, 10, 97.5, 98.8);
         studentRecord student2 = new studentRecord("Marissa", 6.7, 6.4, 8.9, 100, 79.4);
         
         student1.calculateNumericScore();
         student2.calculateNumericScore();
         
         student1.calculateLetterGrade();
         student2.calculateLetterGrade();
         
         if(student1.equals(student2)) {
             System.out.println("The two students are the same.\n");
         }
         else {
             System.out.println("The two students are not the same.\n");
         }
         
         System.out.println(student1);
         System.out.println(student2);
    }
}
