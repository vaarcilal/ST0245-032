/**
 * Recursive algorithm to get all the sub sets of a set of characters.
 *
 * @author Isabel Piedrahita
 * @version 1/2019
 */
class PowerSet
{  
    private static void powerSet(String str, int index, String sub){ 
        int l = str.length(); 
        
        if (index == l) { 
            return; 
        } 
        
        System.out.println(sub); 
        
        for (int i = index + 1; i <l; i++)  
        { 
            sub += str.charAt(i); 
            powerSet(str, i, sub); 
            sub = sub.substring(0, sub.length() - 1); 
        } 
    } 
}  