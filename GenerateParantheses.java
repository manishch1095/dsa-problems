import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(3);
    }
}


class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack("", 0, 0, n);
        return ans;
    }

    public void backtrack(String s, int left , int right, int n) {   

        if(left == right && left == n) {
            ans.add(s);
            return;
        }

        if(left == 0 || left < n) {
            s = s + "(";
            backtrack(s,  left + 1, right, n);
            s = s.substring(0, s.length() - 1);
        }

        if(right < left) {
            s = s + ")";
            backtrack(s, left, right + 1, n);
            s = s.substring(0, s.length() - 1);
        }
    }
}
