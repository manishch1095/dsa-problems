public class LongestOneSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {0,1,1,1,0,1,1,0,1};
        System.out.println(solution.longestSubarray(nums));
    }
}
class Solution {
    public int longestSubarray(int[] nums) {

        int j = 0 , i = 0;
        int countZero = 0;
        int max = -1;
        int temp;
        for( ; i < nums.length ; i++) {
           if(nums[i] == 0) {
            countZero++;
           }

           while(countZero > 1) {
            temp = nums[j];
            if(nums[j] == 0) 
                countZero--;
            j++;
           }
           max = Math.max(i - j , max);
           System.out.println("i: " + i + " j: " + j + " max: " + max);
        
        }
        return max;
    }
}