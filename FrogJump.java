
import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        Solution.frogJump(8, new int[]{7, 4, 4, 2, 6, 6, 3, 4});
    }
}

class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(jump(n, heights, dp));
        return 0;
    }

    public static int jump(int n , int[] heights, int[] dp) {

        if(n == 0) {
            return 0;
        }

        dp[0] = 0;
        dp[1] = Math.abs(heights[1]-heights[0]);

        for(int i = 2; i < n ; i++) {
            dp[i] = Math.min(Math.abs(heights[i] - heights[i-1]) + dp[i-1], Math.abs(heights[i] - heights[i-2]) + dp[i-2]);
        }
        return dp[n-1];
    }

}