
import java.util.Arrays;

public class MaxKSumPairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,1,3,4,3};
        System.out.println(solution.maxOperations(nums, 6));
    }
}

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0 , j = nums.length - 1;

        int sum = 0, count = 0;
        while(i < j) {
            sum = nums[i] + nums[j];
            if(sum == k) {
                count++;
                i++;
                j--;
            } else if(sum > k)
                j--;
            else 
                i++;
        }
        return count;
    }
}