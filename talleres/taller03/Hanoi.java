
/**
 * Recursive algorithm to solve the towers of Hanoi puzzle.
 *
 * @author Isabel Piedrahita.
 * @version 2/2019
 */
public class Hanoi
{
    public static void hanoi(int n){
        auxHanoi(n,1,2,3);
    }
    
    public static void auxHanoi(int n, int from, int inter, int to){
        if(n == 1){
            System.out.println("Disk 1 from "+from+" to "+to);
        }else{
            auxHanoi(n-1,from,to,inter);
            System.out.println("Disk "+n+" from "+from+" to "+to);
            auxHanoi(n-1,inter,from,to);
        }
    }
}
