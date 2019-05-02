import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * @author Isabel Piedrahita, Vincent Arcila.
 * @version May first.
 */
public class BicolorableGraph {
    public boolean isBicolorable(int[][] graph, int root, int v) {
        int colorArr[] = new int[v];

        //-1 = no color yet
        //0 = purple
        //1 = orange
        for (int i = 0; i < v; ++i) {
            colorArr[i] = -1;
        }

        colorArr[root] = 1;

        LinkedList<Integer> BFSq = new LinkedList<Integer>();
        BFSq.add(root);

        while (!BFSq.isEmpty()) {
            int thisVertex = BFSq.poll();
            if (graph[thisVertex][thisVertex] == 1) {
                return false;
            }
            for (int i = 0; i < v; ++v) {
                if (graph[thisVertex][i] == 1 && colorArr[i] == -1) {
                    colorArr[v] = 1 - colorArr[thisVertex];
                    BFSq.add(v);
                } else if (graph[thisVertex][i] == 1 && colorArr[v] == colorArr[thisVertex]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[][] createMatrix(Integer n) {
        int matrix[][] = new int[n][n];
        return matrix;
    }

    public static void printMatrix(int[][] mat, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(mat[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args) throws FileNotFoundException, IOException {
        int G[][] = {{0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };
        int bc[][] = {{1, 0, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        FileReader reader = new FileReader("pruebas_punto2.txt");
        BufferedReader b = new BufferedReader(reader);

        Integer nodes, edges;
        String line;
        line = b.readLine();
        nodes = Integer.parseInt(line);
        line = b.readLine();
        edges = Integer.parseInt(line);
        int matrix[][] = createMatrix(nodes);
        while ((line = b.readLine()) != null) {
            if (line == "0") break;
            String[] strs = line.split(" ");
            // System.out.println(strs.length);
            // System.out.println(line);
            // System.out.println(strs[0]);
            if (strs.length == 1 ) {
                //System.out.println(strs[0]);
                BicolorableGraph bg = new BicolorableGraph();
                printMatrix(matrix, nodes);
                if (bg.isBicolorable(matrix, 0, nodes)) {
                    System.out.println("BICOLORABLE.");
                } else {
                    System.out.println("NOT BICOLORABLE.");
                }
                nodes = Integer.parseInt(strs[0]);
                matrix = createMatrix(nodes);
                line = b.readLine();
                continue;
            }
            matrix[ Integer.parseInt(strs[0]) ][ Integer.parseInt(strs[1]) ] = 1;
            matrix[ Integer.parseInt(strs[1]) ][ Integer.parseInt(strs[0]) ] = 1;
        }

        b.close();
    }
}
