
/**
 * Simple implementation of a binary tree.
 *
 * @author Isabel PIedrahita, Vincent Arcila
 * @version 2/04/2019
 */
public class BinaryTree
{
    //Arbitrary number chosen to increase the spacing in the recursivePrint methods.
    static final int ADDSPACE = 10; 
    
    public Node root;
    
    public BinaryTree() {
        this.root = null;
    }
    
    public void insert(int n) {
        if(root == null) {
            root = new Node(n);
        }else {
            insertAux(n, root);
        }
    }
    
    static void recursivePrint(Node root)  { 
        recursivePrintAux(root, 0);  
    } 
    
    public boolean search(int n) {
        return searchAux(n, root);
    }  
        
    public Node insertAux(int n, Node node) {
        if(node == null) {
            node = new Node(n);
            return node;
        }
        
        if(n < node.data) {
            node.left = insertAux(n, node.left);
        } else if(n > node.data) {
            node.right = insertAux(n, node.right);
        } 
        
        return node;
    }
    
    static void recursivePrintAux(Node node, int space)  {  
        if (node == null){
            return;  
        }
        
        space += ADDSPACE;  
      
        recursivePrintAux(node.right, space);  
      
        System.out.print("\n");  
        for (int i = ADDSPACE; i < space; i++) { 
            System.out.print(" ");  
        }
        System.out.print(node.data + "\n");  
      
        recursivePrintAux(node.left, space);  
    } 
    
    public boolean searchAux(int n, Node node) {
        if(node == null) {
            System.out.println(n + " not found");
            return false;
        } else if(node.data == n) {
            System.out.println(n + " found");
            return true;
        }
        
        if(node.data > n) {
            return searchAux(n, node.left);
        } else if(node.data < n) {
            return searchAux(n, node.right);
        } else {
            return false;
        }
    }
}
