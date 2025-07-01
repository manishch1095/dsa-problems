import java.util.Stack;

/**
 * There are n people standing in a queue, and they numbered from 0 to n - 1 in left to right order. You are given an array heights of distinct integers where heights[i] represents the height of the ith person.

A person can see another person to their right in the queue if everybody in between is shorter than both of them. More formally, the ith person can see the jth person if i < j and min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]).

Return an array answer of length n where answer[i] is the number of people the ith person can see to their right in the queue.
 */
public class CanSeePersonsOnRight {
    public static void main(String[] args) {
        CanSeePersonsOnRight s = new CanSeePersonsOnRight();
        int[] ans = s.canSeePersonsCount(new int[] {10,6,8,5,11,9});
        for(int i: ans) {
            System.out.println(i);
        }
    }

    public int[] canSeePersonsCount(int[] heights) {
        int l = heights.length;
        int ans[] = new int[l];

        Stack<Integer> s = new Stack<>();

        for(int i = l - 1 ; i >= 0; i--) {
            int count = 0;
            while(!s.isEmpty() && heights[i] > heights[s.peek()]) {
                s.pop();
                count++;
            }
            if (!s.isEmpty()) {
                count++;
            }
            ans[i] = count;
            s.push(i);
        }
        return ans;
    }
}
