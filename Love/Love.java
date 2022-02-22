/**
 * This class replaces the first occurrence of the word 'hate' with 'love'. 
 * 
 * @author Ranjana Rajagopalan 
 * @version 09/15/21
 */
public class Love
{
    
    /**
     * Takes a String and replaces the first occurrence of "hate" with "love". 
     * If the word "hate" does not appear in the String, this method returns
     * the original String.
     * If the word "hate" occurs more than once in the String, 
     * this method replaces only the first occurrence of "hate".
     * 
     * Note: you can only use the indexOf and substring methods. You will not get
     * credit if you use any of the other String methods such as replace()
     */
    public String loveNotHate(String str){
        int startLetter;
        String finalString, startString, lastString;
        
        startLetter = str.indexOf("hate", 0);
        
        if (startLetter == -1) {
            return str;
        }
        else {
            startString = str.substring(0, startLetter);
            lastString = str.substring(startLetter + 4, str.length());
            finalString = startString + "love" + lastString;
        }
        
        return finalString;
    }
}