
import java.util.ArrayList;
import java.util.List;


public class ConnectedComponents {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}});
        System.out.println(ans);
    }
}

class Solution {

    public int countComponents(int n, int[][] edges) {
        boolean visited[] = new boolean[n];
        int connectedComponents = 0;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        };

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                connectedComponents++;
                DFS(adj, i, visited, n);
            }
        }
        return connectedComponents;
    }

    void DFS(List<List<Integer>> adj, int u, boolean[] visited, int n) {
        if (visited[u]) {
            return;
        }

        System.out.println(u);
        visited[u] = true;
        for(int neigbour: adj.get(u))
            DFS(adj, neigbour, visited, n);
    }
}