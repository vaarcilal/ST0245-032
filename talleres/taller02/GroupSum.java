
/**
 * Excercise 2 of workshop #2. A recursive algorithm that returns weather a targeted number can be achieved by adding the numbers inside an int array.
 *
 * @author Isabel Piedrahita
 * @version 1/2019
 */
public class GroupSum
{
    public static boolean groupSum(int start, int[] nums, int target) {
        if(start == nums.length){
            return target == 0;
        }
        return groupSum(start+1,nums,target)|| groupSum(start+1,nums,target-nums[start]);
    }
}
