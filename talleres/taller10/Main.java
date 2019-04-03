
/**
 * Tests for the simple binary tree implemented in class BinaryTree.
 *
 * @author Isabel Piedrahita, Vincent Arcila
 * @version 2/04/2019
 */
public class Main
{
    public static void main() {
        BinaryTree bin = new BinaryTree();
        
        bin.insert(6);
        bin.insert(3);
        bin.insert(9);
        bin.insert(1);
        bin.insert(5);
        bin.insert(7);
        bin.insert(10);
        
        bin.recursivePrint(bin.root);
        
        bin.search(7);
        bin.search(13);
    }
}
