public class MinCostStairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[] {10,15,20}));
    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {

        return minCost(cost, cost.length - 1);
    }

    public int minCost(int[] cost, int i) {
        if(i == 0) return 0;
        if(i == 1) return 0;

        return Math.min(cost[i-1] + cost[i-1], cost[i-2] + cost[i-2]);

    }
}