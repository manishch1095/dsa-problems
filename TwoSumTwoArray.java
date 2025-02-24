
import java.util.HashMap;
import java.util.Map;

public class TwoSumTwoArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = solution.twoSum(new int[] {2,7,11,15}, 9);
        for(int a : array) {
            System.out.println(a);
        }
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < numbers.length - 1 ; i ++) {
            if(map.containsKey(target - numbers[i])) {
                return new int[] {i, map.get(target - numbers[i])} ;
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }
}
