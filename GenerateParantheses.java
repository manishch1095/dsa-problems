import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {

    public static void main(String[] args) {
        
    }
     

    public static  List<String> generateParenthesis(int n) {

        return new ArrayList<>();
    }
}


class Solution {

    public void backtrack(String s, List<String> ans , int left , int right, int n) {   

        if(left == right && left == n) {
            ans.add(s);
            return;
        }

        if(left == 0 || left < n) {
            s = s + "(";
            backtrack(s, ans, left + 1, right, n);
            s = s.substring(0, s.length() - 1);
        }

        if(right < left) {
            s = s + ")";
            backtrack(s, ans, left, right + 1, n);
            s = s.substring(0, s.length() - 1);
        }
    }
}
