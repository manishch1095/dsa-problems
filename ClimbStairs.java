
import java.util.Arrays;

public class ClimbStairs {
    
}
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int count = climb(n, dp);
        System.out.println(count);
        return count;
    }

    public int climb(int n , int[] dp) {
        if(dp[n] != -1) 
            return dp[n];
        else if(n == 2 || n == 1) {
            dp[n] = n;
            return n;
        }
        else {
            dp[n] = climb(n-1, dp) + climb(n-2, dp);
        }
        return dp[n];
    }
}