
import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {

        Integer n = isConnected.length;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i< n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i< n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int connectedComponents = 0;
        boolean visited[] = new boolean[n];
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