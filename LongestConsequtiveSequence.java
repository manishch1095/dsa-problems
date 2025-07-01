import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 */
public class LongestConsequtiveSequence {
    public static void main(String[] args) {
        LongestConsequtiveSequence s = new LongestConsequtiveSequence();
        System.out.println(s.longestConsecutive(new int[] {100,4,200,1,3,2}));
        System.out.println(s.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
    }

    public int longestConsecutive(int[] nums) {
        // Edge cases
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        
        // Initialize HashSet with capacity to avoid resizing
        Set<Integer> numSet = new HashSet<>(nums.length);
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 1;
        
        // Iterate over the set instead of the array to avoid duplicates
        for (int num : numSet) {
            // Skip if not the start of a sequence
            if (numSet.contains(num - 1)) {
                continue;
            }
            
            int currentNum = num;
            int currentStreak = 1;
            
            while (numSet.contains(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }
            
            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}