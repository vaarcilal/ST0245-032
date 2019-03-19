import java.util.*;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(){
        Fridge f1 = new Fridge(1,"");
        Fridge f2 = new Fridge(2,"");
        Fridge f3 = new Fridge(3,"");
        Fridge f4 = new Fridge(4,"");
        Fridge f5 = new Fridge(5,"");
        
        Stack<Fridge> fridges = new Stack();
        
        fridges.push(f1);
        fridges.push(f2);
        fridges.push(f3);
        fridges.push(f4);
        fridges.push(f5);
        
        Client c1 = new Client("a",3);
        Client c2 = new Client("b",2);
        
        Queue<Client> orders = new LinkedList<>();
        
        orders.add(c1);
        orders.add(c2);
        
        Store s = new Store(fridges, orders);
        
        s.printOrders();
    }
}
