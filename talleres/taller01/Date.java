
/**
 * Write a description of class Date here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Date
{
    int day;
    int month;
    int year;
    
    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public void printDay(){
        System.out.println(this.day);
    }
    
    public void printMonth(){
        System.out.println(this.month);
    }
    
    public void printYear(){
        System.out.println(this.year);
    }
    
    public String toString(){
        return this.day + "/" + this.month + "/" + this.year;
    }
    
    public void compareDates(Date d){
        if(this.year > d.year){
            System.out.println("La fecha "+ d.toString() +" es anterior a " + this.toString()+".");
        }else if(d.year > this.year){
            System.out.println("La fecha "+ d.toString() +" es posterior a " + this.toString()+".");
        }else if(this.year == d.year){
            if(this.month < d.month){
                System.out.println("La fecha "+ d.toString() +" es posterior a " + this.toString()+".");
            }else if(d.month < this.month){
                System.out.println("La fecha "+ d.toString() +" es anterior a " + this.toString()+".");
            }else if(this.month == d.month){
                if(this.day < d.day){
                    System.out.println("La fecha "+ d.toString() +" es posterior a " + this.toString()+".");
                }else if(this.day > d.day){
                    System.out.println("La fecha "+ d.toString() +" es anterior a " + this.toString()+".");
                }else{
                    System.out.println("Ambas fechas son iguales.");
                }
            }
        }
    }
    
    public static void main(){
        Date d1 = new Date(1,1,2011);
        Date d2 = new Date(2,3,2018);
        Date d3 = new Date(4,3,2018);
        Date d4 = new Date(1,1,2011);
        d1.compareDates(d2);
        d1.compareDates(d4);
        d2.compareDates(d3);
        d3.compareDates(d2);
    }
}
