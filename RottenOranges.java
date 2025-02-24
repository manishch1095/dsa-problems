
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();


        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0)  {
                    q.add(new Pair.of(m,j));
                }
            }
        }

        while(!q.isEmpty()) {
            int element = q.poll();

        }
        
        return 0;
    }
}