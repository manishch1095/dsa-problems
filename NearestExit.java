
import java.util.LinkedList;
import java.util.Queue;

public class NearestExit {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nearestExit(new char[][]{{'+','+','+'},{'.','.','.'},{'+','+','+'}}, new int[]{1,0}));
    }
}

class Solution {

    static int dRow[] = { 0, 1, 0, -1 };
    static int dCol[] = { -1, 0, 1, 0 };

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
 
    public boolean isValid(int row, int col, boolean[][] visited) {
        if(row < 0 || col < 0 || row >= visited.length || col >= visited[0].length)
            return false;

        if(visited[row][col])
            return false;
        return true;
    }


    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        return BFS(entrance[0], entrance[1], maze, visited);
    }

    public int BFS(int row, int col , char[][] grid, boolean[][] visited) {
        Queue<pair> q  = new LinkedList<>();
        int currDistance = 0;
        q.offer(new pair(row, col));

        int m,n;
        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {
                pair curr = q.poll();

                m = curr.first;
                n = curr.second;
                visited[m][n] = true;
                // System.out.println("exi found at row: " + m + " col: " + n + " currDistance:" + currDistance);
                if(!(m == row && n == col) && ((m == 0 || n == 0) || ( m == visited.length - 1  || n == visited[0].length - 1))) {
                    return currDistance;
                }
                for(int j = 0; j < 4; j++) {
                    int adjx = m + dRow[j];
                    int adjy = n + dCol[j];
                    if(isValid(adjx, adjy, visited) && grid[adjx][adjy] == '.'){
                                        visited[adjx][adjy] = true;
                                        q.offer(new pair(adjx, adjy));
                    }
                       
                }
            }
            currDistance++;
        }
        return -1;
    }
}