
import java.util.Arrays;

public class IntroductionToDp {
    public static void main(String[] args) {
        System.out.println(Solution.bottomUp(697));
    }
}
class Solution {

    static final long modulo = 1000000007;

    static long topDown(int n) {
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return down(n, dp);
    }

    static long down(int n , long[] dp) {
        if(n == 0 || n == 1){
            dp[n] = n;
            return dp[n];
        }

        if(dp[n] != -1){
            return dp[n];
        } else {
            dp[n] = (down(n-1, dp) + down(n-2, dp))%modulo;
        }
        return dp[n];
    }

    static long bottomUp(int n) {
       long[] dp = new long[n+1];
    
       if(n == 0 || n == 1) 
            return n;
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2 ; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%modulo;
            System.out.println(dp[i]);
        }
        return dp[n];
    }
}
