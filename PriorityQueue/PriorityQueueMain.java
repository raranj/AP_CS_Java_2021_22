
/**
 * This class implements the test code for the PriorityQueue class.
 *
 * @author Ranjana Rajagopalan
 * @version 12/10/21
 */
public class PriorityQueueMain
{
    public static void main(String[] args)
    {
        PriorityQueue<String> q = new PriorityQueue<String>();
        
        // ascending order
        q.add("A", 3);
        q.add("B", 6);
        q.add("C", 9);
        q.add("D", 12);
        System.out.println(q);
        System.out.println(q.remove()); 
        System.out.println(q.remove()); 
        System.out.println(q.remove());
        System.out.println(q.remove()); 
        System.out.println(q); // print empty queue
        
        // descending order
        q.add("J", 100);
        q.add("K",80);
        q.add("Q", 60);
        q.add("V", 40);
        q.add("Y", 20);
        System.out.println(q);
        System.out.println(q.remove()); 
        System.out.println(q.remove()); 
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove()); // remove from empty queue
        
        // mixed order
        q.add("X", 10);
        q.add("Y", 1);
        q.add("Z", 3);
        q.add("A", 7);
        q.add("E", 0);
        q.add("T", 21);
        System.out.println(q); 
        System.out.println(q.remove()); 
        System.out.println(q.remove()); 
        System.out.println(q.remove()); 
        System.out.println(q.remove()); 
        System.out.println(q.remove()); 
        System.out.println(q.remove());
        
    }
}
