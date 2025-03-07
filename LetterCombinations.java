
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("23");
    }
}

class Solution {

    List<String> ans = new ArrayList<>();

    Map<Character, List<Character>> digitToCharsMap = Map.ofEntries(
        Map.entry('2', Arrays.asList('a', 'b', 'c')),
        Map.entry('3', Arrays.asList('d', 'e', 'f')),
        Map.entry('4', Arrays.asList('g', 'h', 'i')),
        Map.entry('5', Arrays.asList('j', 'k', 'l')),
        Map.entry('6', Arrays.asList('m', 'n', 'o')),
        Map.entry('7', Arrays.asList('p', 'q', 'r', 's')),
        Map.entry('8', Arrays.asList('t', 'u', 'v')),
        Map.entry('9', Arrays.asList('w', 'x', 'y', 'z'))
    );

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return ans;
        recurseForDigit(digits, new StringBuilder(), 0);
        for(String s : ans){
            System.out.println(s);
        }
        return ans;
    }


    void recurseForDigit(String digits, StringBuilder curr, int index) {
        if(curr.length() == digits.length()){
            ans.add(curr.toString());
        }
        if(index < digits.length()) {
            System.out.println("index: " + index + " curr: " + curr );

            List<Character> chars = digitToCharsMap.get(digits.charAt(index));
            for(Character possibleChar : chars) {
                curr.append(possibleChar.toString());
                recurseForDigit(digits, curr, index + 1);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
}
