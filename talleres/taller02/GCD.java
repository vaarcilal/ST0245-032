
/**
 * Excercise 1 of workshop #2. A recursive implementation of Euclides' algorithm.
 *
 * @author Isabel Piedrahita
 * @version 1/2019
 */
public class GCD
{
    public static int gcd(int p, int q) {
        if (q == 0){
            return p;
        }else{
            return gcd(q, p%q);
        }
    }
}
