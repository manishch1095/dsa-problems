
import java.util.Comparator;
import java.util.PriorityQueue;

public class TotalCostToHireWorkers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalCost(new int[]{1,2,4,1}, 3, 3));
    }
}
class Solution {

    static class pair
    {
        public int first;
        public int second;
    
        public pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }

    public long totalCost(int[] costs, int k, int candidates) {
        
        Comparator<pair> workerComparator = (pair o1, pair o2) -> {
            int salaryComparison = Integer.compare(o1.first, o2.first);
            if(salaryComparison != 0)
                return salaryComparison;
            return Integer.compare(o1.second, o2.second);
        }; 

        PriorityQueue<pair> pq1 = new PriorityQueue<>(k, workerComparator);
        PriorityQueue<pair> pq2 = new PriorityQueue<>(k, workerComparator);

        int l = costs.length;

        int i , j ;
        //add to first heap
        for(i = 0; i < candidates ; i++) {
            pq1.add(new pair(costs[i], i));
        }

        int p1 = i - 1, p2 = Math.max(i, l - candidates);

        System.out.println("p1:" + p1 + " p2:" + p2);
        //add to second heap
        for(j = p2 ; j < l ; j++) {
            pq2.add(new pair(costs[j], j));
        }

        long totalCost = 0;
        while(k > 0) {
            PriorityQueue<pair> rs;

            boolean left;
            if(pq1.isEmpty())
            {
                rs = pq2;
                left = false;
            }
            else if(pq2.isEmpty()) {
                rs = pq1;
                left = true;
            }
            else if(pq2.peek().first < pq1.peek().first){
                rs = pq2;
                left = false;
            } else {
                rs = pq1;
                left = true;
            }
            pair element = rs.poll();
            System.out.println("left pq: " + left + " element: " + element.first + " index: " + element.second);
            totalCost += element.first;
            if(p2 - p1 > 1) {
                if(left) {
                    p1++;
                    pq1.add(new pair(costs[p1], p1));
                } else {
                    p2--;
                    pq2.add(new pair(costs[p2], p2));
                }
            }
            k--;
        }
        return totalCost;
    }
}