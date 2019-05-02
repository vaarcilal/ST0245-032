import java.util.*; 
import java.lang.*; 
import java.io.*; 
/**
 * Write a description of class BicolorableGraph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BicolorableGraph
{
    public boolean isBicolorable(int[][] graph, int root, int v) {
        int colorArr[] = new int[v];
        
        //-1 = no color yet
        //0 = purple
        //1 = orange
        for (int i=0; i<v; ++i) {
            colorArr[i] = -1;  
        }
        
        colorArr[root] = 1; 
        
        LinkedList<Integer> BFSq = new LinkedList<Integer>(); 
        BFSq.add(root); 
        
        while(!BFSq.isEmpty()) {
            int thisVertex = BFSq.poll(); 
            if (graph[thisVertex][thisVertex] == 1) {
                return false; 
            }
            for (int i=0; i<v; ++v) { 
                if (graph[thisVertex][i] == 1 && colorArr[i] == -1) {
                    colorArr[v] = 1-colorArr[thisVertex]; 
                    BFSq.add(v); 
                }else if (graph[thisVertex][i] == 1 && colorArr[v] == colorArr[thisVertex]) {
                    return false; 
                }
            }
        }
        
        return true;
    }
    
    public static void main (String[] args) 
    { 
        int G[][] = {{0, 1, 0, 1}, 
            {1, 0, 1, 0}, 
            {0, 1, 0, 1}, 
            {1, 0, 1, 0} 
        }; 
        int bc[][] = {{1, 0, 1}, 
            {1, 1, 0}, 
            {0, 1, 1} 
        }; 
        BicolorableGraph b = new BicolorableGraph(); 
        if (b.isBicolorable(bc, 0, 4)) {
            System.out.println("BICOLORABLE."); 
        }else{
            System.out.println("NOT BICOLORABLE."); 
        }
    } 
}
