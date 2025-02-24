import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.subsets(new int[] {1,2,3});
    }
}
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int l = nums.length;
        subsequence(nums, 0, l-1, new ArrayList<>());
        return ans;
    }

    public void subsequence(int[] nums, int i, int l, List<Integer> currSubsequence) {
        System.out.println("i: " + i + " l: " + l);

        if(i >= l) {
            if(currSubsequence.size() == 0) {
                ans.add(new ArrayList<Integer>());
            } else {
                ans.add(new ArrayList<>(currSubsequence));
            }
            return;
        }

        // System.out.println("i: " + i + " l: " + l);
        currSubsequence.stream().forEach((x) -> System.out.print(x + " "));
        System.out.println();
        //choice 1 : include current element in subsequence
        currSubsequence.add(nums[i]);
        subsequence(nums, i + 1, l, currSubsequence);

        //choice 2: do not include current element in subsequence
        currSubsequence.remove(currSubsequence.size() - 1);
        subsequence(nums, i + 1, l, currSubsequence);
    }
}