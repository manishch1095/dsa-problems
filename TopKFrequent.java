import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(k, new TopKComparator());

        Map<Integer, Integer> cMap = new HashMap<>();
        for(int num : nums) {
            cMap.put(num, cMap.getOrDefault(num,  0)  + 1);
        }

        for(Map.Entry<Integer, Integer> entry : cMap.entrySet()) {
            q.add(entry);
        }
        int[] res = new int[k];
        int count = 0;
        while (!q.isEmpty() && count < k) {
            Map.Entry<Integer, Integer> value = q.poll();
            res[count++] = value.getKey();
            System.out.println(value);
        }
        // ... the rest of the function//+
        return res;
    }
}

class TopKComparator implements Comparator<Map.Entry<Integer, Integer>> {

    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        if(Objects.equals(o1.getValue(), o2.getKey())) {
            return o1.getKey() >= o2.getKey() ? 1 : -1;
        } else return o2.getValue() - o1.getValue(); 
    }

}