import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LetterTilesPossibilities {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numTilePossibilities("AB");
    }
}
class Solution {
    private Map<Character, Integer> charCount = new HashMap<>();
    private Set<String> ans = new HashSet<>();
    private int count;
    
    public int numTilePossibilities(String tiles) {
        for(char c : tiles.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        backtrack(tiles, "", 0, tiles.length());
        for(String val : ans) {
            System.out.println(val);
        }
        System.out.println(count);
        return count;
    }

    public void backtrack(String tiles, String s, int l , int m) {
        if(l >= m) {
            ans.add(s);
            return;
        }

        s = s + tiles.charAt(l);
        backtrack(tiles, s, l+1, m);

        s = s.substring(0, s.length() - 1);
        backtrack(tiles, s, l+1, m);
    }
}