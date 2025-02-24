
import java.util.ArrayList;
import java.util.List;

public class SubsetsBacktracking {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.subsets(new int[] {1,2,3});
    }
}
class Solution {

    private List<List<Integer>> output = new ArrayList();
    private int n;

    public void backtrack(int first, List<Integer> curr, int[] nums) {
        // Add the current subset to the output
        output.add(new ArrayList(curr));
        // Generate subsets starting from the current index
        for (int i = first; i < n; ++i) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        List<Integer> currCombo = new ArrayList<Integer>();
        backtrack(0, currCombo, nums); // One call generates all subsets
        return output;
    }
}