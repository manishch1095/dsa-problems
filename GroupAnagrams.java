import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
        Solution solution = new Solution();
        System.err.println(solution.groupAnagrams(strs));
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> ans = new ArrayList<>();
        
        for(String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            map.computeIfAbsent(new String(ch), k ->  new ArrayList<String>()).add(str);
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}

