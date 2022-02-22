import java.util.ArrayList;

/**
 * This class implements a priority queue that holds objects of arbitrary type T. 
 *
 * @author Ranjana Rajagopalan
 * @version 12/10/21
 */
public class PriorityQueue<T>
{
    private ArrayList<T> queue; // holds all the items of Type T
    private ArrayList<Integer> priorities; // holds the priority of each item in ArrayList queue
    
    // initialize ArrayLists
    public PriorityQueue() {
        queue = new ArrayList<T>();
        priorities = new ArrayList<Integer>();
    }
    
    // This method adds a new item to the priority queue and adds the corresponding priority to the list of priorities
    public void add(T item, int priority) {
        priorities.add(priority);
        queue.add(item);
    }
    
    // This method removes and returns the item with the highest priority
    public T remove() {
        
        // return null if priority queue doesn't have any items 
        if (priorities.size() == 0) {
            return null;
        }
        
        int highestPriorityIndex = 0; // index of item with highest priority
        
        for (int i = 0; i < priorities.size(); i++) {
            if (priorities.get(i) > priorities.get(highestPriorityIndex)) {
                highestPriorityIndex = i; 
            }
        }
        
        priorities.remove(highestPriorityIndex); // remove priority from list of priorities as well
        
        return queue.remove(highestPriorityIndex); // return item with highest priority
    }
    
    // This method returns a String representation of the priority queue
    public String toString() {
        String str = "[ ";
        for (int i = 0; i < queue.size(); i++) {
            if (i != (queue.size() - 1)) {
                str += ("[\"" + queue.get(i) + "\"," + priorities.get(i) + "], ");
            }
            else {
                str += ("[\"" + queue.get(i) + "\"," + priorities.get(i) + "] ");
            }
        }
        
        str += "]";
        
        return str;
    }
}
