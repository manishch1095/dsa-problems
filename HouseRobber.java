
import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{2,7,9,3,1}));
    }
}

class Solution {

   Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int rob(int[] nums) {

        int l = nums.length ;
        return recursive(nums, l - 1);
    }

    public int recursive(int[] nums , int i) {
    
        if(i == 0) return nums[0] ;

        if(i == 1) return Math.max(nums[0], nums[1]);

        if(map.containsKey(i))
            return map.get(i);
        else {
            map.put(i, Math.max(recursive(nums, i - 1), recursive(nums, i - 2) + nums[i]));
        }
        return map.get(i);
    }
}