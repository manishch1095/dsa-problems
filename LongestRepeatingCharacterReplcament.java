
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplcament {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.characterReplacement("ABAB", 1);
        System.out.println(ans);
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        if(s.isEmpty() || k == 0)
            return 0;
        int l = s.length();

        if(l == 1)
            return 1;
        
        int i = 0, j = 0, maxCount = 0, ans = -1;

        Map<Character, Integer> charCountMap = new HashMap<>();
        
        for(; i < l; i++) {
            Character curr = s.charAt(i);
            Integer currCount = charCountMap.getOrDefault(curr, 0);
            charCountMap.put(curr, currCount + 1);
            maxCount = Math.max(maxCount, currCount + 1);

            if(i - j - maxCount + 1 <= k) {
                System.out.println("abhi theek h ");
            } else {
                //reduce window size
                System.out.println("redue window size ");
                currCount = charCountMap.getOrDefault(curr, 0);
                charCountMap.put(curr, currCount - 1);
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }

        return ans;
    }
}