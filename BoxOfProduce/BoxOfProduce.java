/**
 * This class contains three bundles of produce to be delivered. 
 *
 * @author Ranjana Rajagopalan
 * @version 10/21/21
 */
public class BoxOfProduce
{
    String produce1, produce2, produce3; 

    /**
     * Constructor for objects of class BoxOfProduce
     */
    public BoxOfProduce(String produce1, String produce2, String produce3)
    {
        this.produce1 = produce1;
        this.produce2 = produce2;
        this.produce3 = produce3;
    }
    
    // accessor methods that return the three produce bundles
    public String getProduce1() {
        return produce1;
    }
    
    public String getProduce2() {
        return produce2;
    }
    
    public String getProduce3() {
        return produce3;
    }
    
    // mutator methods that set the three produce bundles
    public void setProduce1(String replaceProduce1) {
        produce1 = replaceProduce1;
    }
    
    public void setProduce2(String replaceProduce2) {
        produce2 = replaceProduce2;
    }
    
    public void setProduce3(String replaceProduce3) {
        produce3 = replaceProduce3;
    }
    
    // returns a String representation of the final three produce options in the box
    public String toString() {
        return ("The final contents of the box are " + produce1 + ", " + produce2 + ", and " + produce3 + "\n");
    }
}
