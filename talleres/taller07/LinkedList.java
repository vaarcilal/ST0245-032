import java.util.*;
import java.lang.IndexOutOfBoundsException;

/**
 * Write a description of class LinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedList<T> {
    private Node<T> head = null;
    private int size = 0;
    
    public LinkedList() {}
    
    public void insert(T data, int index)  throws IndexOutOfBoundsException {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        
        Node<T> toAdd = new Node(data);
        if (index == 0) {
            if (head == null) {
                head = toAdd;
                size ++;
                
                return;
            }
            
            toAdd.setNext(head);
            head = toAdd;
            
            size ++;
            
            return;
        }
        
        Node<T> prev = head;
        Node<T> current = head.getNext();
        
        for(int i = 1; i < index; i++){
            prev = current;
            current = current.getNext();
        }
        
        toAdd.setNext(current);
        prev.setNext(toAdd);
        size ++;
    }
    
    public void remove(int index)  throws IndexOutOfBoundsException {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        
        Node<T> prev = head;
        Node<T> current = head.getNext();
        
        for(int i = 1; i < index; i++){
            prev = current;
            current = current.getNext();
        }
        
        prev.setNext(current.getNext());
        current.setNext(null);
        size --;
    }
    
    public int getSize() {
        return size;
    }
    
    public void printArray() {
        Node<T> current = head;
        System.out.println(head.getData());
        for(int i = 1; i < size; i++){
            current = current.getNext();
            System.out.println(current.getData());
        }
    }
    
    public Node<T> getNode(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        
        Node<T> current = head;
        
        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }
        
        return current;
    }
    
    public boolean contains(T val) {
        Node<T> current = head;
        System.out.println(head.getData());
        for(int i = 1; i < size; i++){
            current = current.getNext();
            if(Objects.equals(current.getData(), val)) {
                return true;
            }
        }
        return false;
    }
    
    public T getData(int index) throws IndexOutOfBoundsException {
        return getNode(index).getData();
    }
}
