import java.util.*;
public class Heap {
    int[] heap;
    int numElements;
    int maxElements;

    //------------------CONSTRUCTORS-------------------------
    
    public Heap (int max) {
        numElements = 0;
        maxElements = max;
        heap = new int[max];
    }
   
    public Heap (int[] vector, int max) {
        heap = vector;
        numElements = vector.length;
        maxElements = max;
    }

    //------------------USEFUL AUXILIAR METHODS-------------------------
    
    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    
    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
    
    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2 ;
    }
    
    public boolean hasLeftChild(int index) {
        return (getLeftChildIndex(index) < numElements);
    }
    
    public boolean hasRightChild(int index) {
        return (getRightChildIndex(index) < numElements);
    }
    
    public boolean hasParent(int index) {
        return (getParentIndex(index) >= 0);
    }
    
    public int getLeftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }
    
    public int getRightChild(int index) {
        return heap[getRightChildIndex(index)];
    }
    
    public int getParent(int index) {
        return heap[getParentIndex(index)];
    }
    
    public void swap(int index1, int index2) {
        int aux = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = aux;
    }
    
    public void makeRoom() {
        if(numElements == maxElements) {
            heap = Arrays.copyOf(heap, maxElements * 2);
            maxElements *= 2;
        }
    }
    
    //------------------REQUIRED METHODS-------------------------
    
    public boolean EmptyHeap() {
        return (numElements == 0);
    }

    public void bubbleUp () {
        int index = numElements-1;
        while(hasParent(index) && getParent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
    
    public void bubbleDown () {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallestChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallestChildIndex = getRightChildIndex(index);
            }
            if(heap[index] < heap[smallestChildIndex]) {
                break;
            } else {
                swap(index, smallestChildIndex);
            }
            index = smallestChildIndex;
        }
    }

    public void insert(int element) {
        makeRoom();
        heap[numElements] = element;
        numElements++;
        bubbleUp();
    }

    public int first() {
        try{
            return  heap[0];
        }catch(IllegalStateException e) {
            System.out.println("There is nothing in the heap yet!");
            return -1;
        }
    }

    public int peek() {
        try{
            int firstItem = heap[0];
            heap[0] = heap[numElements - 1];
            numElements--;
            bubbleDown();
            return firstItem;
        }catch(IllegalStateException e) {
            System.out.println("There is nothing in the heap yet!");
            return -1;
        }
    }
    
    //-------------------DRIVER CODE---------------------
    
    public static void main() {
        System.out.println("Testing constructor 1");
        System.out.println();
        Heap h1 = new Heap(3);
        h1.insert(10);
        h1.insert(15);
        h1.insert(20);
        h1.insert(17);
        h1.insert(8);
        for(int i = 0 ; i < h1.numElements ; i++) {
            System.out.println(h1.heap[i]);
        }
        System.out.println();
        System.out.println(h1.peek());
        System.out.println();
        for(int i = 0 ; i < h1.numElements ; i++) {
            System.out.println(h1.heap[i]);
        }
        
        System.out.println();
        
        System.out.println("Testing constructor 2");
        System.out.println();
        int[] vals = {8, 8, 9, 15, 20, 17, 10};
        Heap h2 = new Heap(vals, 1);
        for(int i = 0 ; i < h2.numElements ; i++) {
            System.out.println(h2.heap[i]);
        }
        System.out.println();
        System.out.println(h1.peek());
        System.out.println();
        for(int i = 0 ; i < h2.numElements ; i++) {
            System.out.println(h2.heap[i]);
        }
    }
}
