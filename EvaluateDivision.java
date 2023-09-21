import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    public static void main(String args[]) {
        List<List<String>> equations = Arrays.asList(
            Arrays.asList("a","b"),
            Arrays.asList("b","c")
        );

        List<List<String>> queries = Arrays.asList(
            Arrays.asList("a","c"),
            Arrays.asList("b","a"),
            Arrays.asList("a","e"),
            Arrays.asList("a","a"),
            Arrays.asList("x","x")
        );

        double [] values = new double[]{2.0, 3.0};

        CalcEquation calcEquation = new CalcEquation();
        double[] ans = calcEquation.calcEquation(equations, values, queries);
        for(double val : ans) {
            System.out.println(val);
        }
    }

     
}

class CalcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
         Map<String, Map<String, Double>> graph = makeGraph(equations, values);
         double[] result = new double[queries.size()];

        
         for(int i = 0; i < queries.size(); i++) {
            result[i] = DFS(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());
         }
        return result;
    }

    public Map<String, Map<String, Double>> makeGraph(List<List<String>> equations, double[] values) {

        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i = 0; i < equations.size() ; i++) {
            List<String> equation = equations.get(i);
            String a  = equation.get(0);
            String b  = equation.get(1);
            map.putIfAbsent(a, new HashMap<String, Double>());
            map.get(a).put(b, values[i]);

            map.putIfAbsent(b, new HashMap<String, Double>());

            map.get(b).put(a, 1/values[i]);
        }
        return map;
    }

    public double DFS(String src, String dest, Map<String, Map<String, Double>> graph , Set<String> visited){
        if(graph.containsKey(dest) == false) {
            //case when dest is not present in graph
            return -1.0;
        }

        if(graph.get(src).containsKey(dest)) {
            // in case dest is directly connected to src
            return graph.get(src).get(dest);
        }

        visited.add(dest);

        for(Map.Entry<String, Double> entry : graph.get(src).entrySet()) {
            if(!visited.contains(entry.getKey())) {
                double value = DFS(entry.getKey(), dest, graph, visited);


                if(value != -1.0) {
                    return value* entry.getValue();
                }
            }
        }
        return -1.0;
    } 
}
