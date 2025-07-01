import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an array of strings words and an integer k, return the k most frequent strings.

    Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 */
public class TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> s = solution.topKFrequent(new String[] {"i","love","leetcode","i","love","coding"}, 2);
        s.stream().forEach( x -> System.out.println(x));
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap();

        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if(a.getSecond() != b.getSecond())
                return a.getSecond() - b.getSecond();
            return b.getFirst().compareTo(a.getFirst());
        });

        for(String word: words) {
            wordCount.merge(word, 1, Integer::sum);
        }

        List<String> ans = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            // System.out.println("word: " + entry.getKey() + " count: " + entry.getValue());
            pq.add(new Pair<String,Integer>(entry.getKey(), entry.getValue()));
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        while(!pq.isEmpty()) {
            ans.add(pq.poll().getFirst());
        }
        Collections.reverse(ans);
        return ans;
    }
}
