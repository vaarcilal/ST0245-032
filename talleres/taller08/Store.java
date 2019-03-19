import java.util.*;
/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store
{
    private Stack<Fridge> fridges;
    private Queue<Client> orders;
    
    public Store(Stack<Fridge> fridges, Queue<Client> orders){
        this.fridges = fridges;
        this.orders = orders;
    }
    
    public void printOrders(){
        int size = orders.size();
        for(int i = 0; i < size ; i++){
            Client current = orders.poll();
            for(int j = 0 ; j < current.num ; j++){
                Fridge currentFridge = fridges.pop();
                System.out.println(current.name + " " + currentFridge.code);
            }
        }
    }
}