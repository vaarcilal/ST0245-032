import java.util.*;
/**
 * WBFS and BFS based island detection algorithm.
 *
 * @author Isabel Piedrahita, Vincent Arcila
 * @version 25/04/2019
 */
public class PathFinder
{
    public static boolean validPathDFS(DiGraph g, int source, int destination){
        boolean [] checked = new boolean [g.getSize()];
        return DFSPath(g, source, destination, checked);
    }
    
    private static boolean DFSPath(DiGraph g, int source, int destination, boolean[] checked){
        ArrayList<Integer> next = g.getSuccessors(source);
        checked[source] = true;
        boolean answer = false;

        if(destination == source){
            answer = true;
        }

        for(int neighbor: next){
            if(checked[neighbor] == false){
                answer = answer || DFSPath(g, neighbor, destination, checked);
            }
        }
        return answer;
    }
    
    public static boolean validPathBFS(DiGraph g, int source, int destination){
        boolean [] checked = new boolean [g.getSize()];
        return BFSPath(g, source, destination, checked);
    }

    private static boolean BFSPath(DiGraph g, int source, int destination, boolean [] checked){
        ArrayList<Integer> visitedList = g.getSuccessors(source);
        Queue <Integer> lista = new LinkedList <Integer>();
        boolean answer = false;
        checked[source]=true;
        
        for (int nextNode: visitedList){
            lista.add(nextNode);
        }
        
        if(source == destination){
            answer = true;
        }
        
        while (lista.size() != 0){
            int org= lista.poll();
            return BFSPath(g, org, destination, checked);
        }
        
        return answer;
    }
    
    public static void main() {
        DiGraph graph = new DiGraphAL(5);
        graph.addArc(1,2,0);
        graph.addArc(2,4,0);
        graph.addArc(1,5,0);
        System.out.println(validPathDFS(graph, 1, 4));
        System.out.println(validPathDFS(graph, 1, 5));
        System.out.println(validPathDFS(graph, 1, 3));
    }
}

