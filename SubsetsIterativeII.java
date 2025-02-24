public class SubsetsIterativeII {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.printSubSeq("ABC");
    }
}
class Solution {

    private int n;

    public void backtrack(int first, String curr, String s) {
        // Add the current subset to the output
        if(curr.isEmpty()) {
            System.out.println("{}");
        } else {
            System.out.println(curr);
        }
        // Generate subsets starting from the current index
        for (int i = first; i < n; ++i) {
            curr = curr + s.charAt(i);
            backtrack(i + 1, curr, s);
            curr = curr.substring(0, curr.length() - 1);
        }
    }

    public void printSubSeq(String s) {
        n = s.length();
        backtrack(0, "", s); // One call generates all subsets
    }
}