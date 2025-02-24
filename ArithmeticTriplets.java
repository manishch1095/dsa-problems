import java.util.HashMap;
import java.util.Map;

public class ArithmeticTriplets {
    public static void main(String[] args) {
        ArithremeticTriplet s = new ArithremeticTriplet();
        int arr[] = new int[] { 0, 1, 4, 6, 7, 10 };
        System.out.println(s.arithmeticTriplets(arr, 3));
    }
}

class ArithremeticTriplet {
    public int arithmeticTriplets(int[] nums, int diff) {
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }
        ;

        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i] + diff) && indexMap.containsKey(nums[i] + 2 * diff)) {
                count++;
            }
        }
        return count;
    }
}