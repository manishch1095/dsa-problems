
import java.security.cert.CRLReason;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumOfIslands {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans =  solution.numIslands(new char[][]{
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
          });
        System.out.println("Number of islands:" + ans);
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
 

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int ans = 0;

        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < grid[i].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    ans+=1;
                    DFS(i, j , grid, visited);
                }
            }
        }

        return ans;
    }

    public boolean isValid(int row, int col, boolean[][] visited) {
        if(row < 0 || col < 0 || row >= visited.length || col >= visited[0].length)
            return false;

        if(visited[row][col])
            return false;
        return true;
    }

    public void DFS(int row, int col , char[][] grid, boolean[][] visited) {

        Stack<pair> st = new Stack<pair>();
        st.push(new pair(row, col));

        while(!st.empty()) {
            pair curr = st.pop();

            row = curr.first;
            col = curr.second;

            if(!isValid(row, col, visited) || grid[row][col] == '0') 
                continue;
            

            visited[row][col] = true;

            // System.out.println(row + ' ' + col);

            for(int i = 0; i < 4; i++) 
            {
                int adjx = row + dRow[i];
                int adjy = col + dCol[i];
                st.push(new pair(adjx, adjy));
            }
        }
    }


}