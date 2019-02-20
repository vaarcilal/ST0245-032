
/**
 * Adds numbers in an array and times how long it takes to do so with arrays ranging in length from 1700 to 1720 elements
 *This algorithm has a complexity of O(n)
 *
 *La gráfica representa una linea horizontal con un pico anormal al prinicpio, esto probablemente se debe a que allí se considera el tiempo requerido para iniciar la 
 * máquina virtual.
 *
 */
public class TallerCincoPuntoDos
{
    public static void main(){
        for(int i=1700 ; i<=1720 ; i++){
            double startTime = System.nanoTime();
            int[] a = new int[i];
            System.out.println(i);
            System.out.println(arrSum(a));
            double endTime = System.nanoTime();
            double timeElapsed = endTime - startTime;
            System.out.println(timeElapsed/1000000);
            System.out.println();
        }
    }
    
    private static int arrSum(int[] arr){
        int sum = 0;
        for(int i=0 ; i < arr.length ; i++){
            sum += arr[i]; //n+c
        }
        return sum;
    }
}
