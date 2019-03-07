
public class Node <T> {
    private T data;
    private Node<T> next;
    
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    public void setData(T newData) {
        this.data = newData;
    }
    
    public T getData() {
        return this.data;
    }
    
    public void setNext(Node<T> newNext) {
        this.next = newNext;
    }
    
    public Node<T> getNext(){
        return this.next;
    }
}
