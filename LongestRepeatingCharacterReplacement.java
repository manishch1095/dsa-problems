
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    
    public static void main(String[] args) {
        String  s = "AABABBA";
        Solution solution = new Solution();
        solution.characterReplacement(s, 1);        
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        
        int i = 0 , j = 0;

        int ans = 0;

        int max = Integer.MIN_VALUE;

        for( ; i < s.length(); i++) {
            Integer charCount = charMap.merge(s.charAt(i), 1, Integer::sum);
            max = Math.max(max, charCount);

            if(i - j + 1 - max >= k) {
                // valid window as
                ans = Math.max(ans, max);
            }

            while(i - j + 1 - max < k) {
                
            }

        }
        return 0;
    }
}