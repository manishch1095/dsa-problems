
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.numBusesToDestination(new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}}, 15, 12));
    }
}

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        Map<Integer, List<Integer>> stopToRouteMap = new HashMap<>();
        for(int r = 0 ; r < routes.length ; r++) {
            for(int stop : routes[r]) {
                List<Integer> stopRoutes = stopToRouteMap.getOrDefault(stop, new ArrayList<>());
                stopRoutes.add(r);
                stopToRouteMap.put(stop, stopRoutes);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        Set<Integer> visited = new HashSet<>();

        for(int route : stopToRouteMap.get(source)) {
            q.offer(route);
            visited.add(route);
        }

        int busCount = 1;

        while(!q.isEmpty()) {
            Integer size = q.size();

            for(int i = 0 ; i < size ; i++) {
                Integer route = q.remove();

                for(Integer stop : routes[route]) {
                    System.out.println("route: " + route + "  stop: " + stop);
                    if(stop == target) {
                        return busCount;
                    }
                    for(Integer r : stopToRouteMap.get(stop)) {
                        if(!visited.contains(r)){
                            visited.add(r);
                            q.offer(r);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}