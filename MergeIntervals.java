import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        
        Solution solution = new Solution();
        solution.merge(new int[][] {{1,2}});
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
               if(o1[0] > o2[0]) {
                return 1;
               } else {
                return -1;
               }
                
            }

        });
        List<int[]> ans = new ArrayList<>();
        for(int[] interval : intervals) {
            if(ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[1]) {
                ans.add(interval);
            } else {
                int l = ans.size();
                int[] last = ans.get(l - 1);
                last[1] = interval[1];
                ans.set(l-1, last);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
