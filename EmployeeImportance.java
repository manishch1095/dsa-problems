import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeImportance {
    public static void main(String[] args) {
        EmployeeImportance employeeImportance = new EmployeeImportance();
        employeeImportance.getImportance(null, 0);
    }

    public int getImportance(List<Employee> employees, int employeeId) {
        Employee employee = employees.stream().filter(x -> x.id == employeeId).findAny().orElse(null);
                
        if(employee == null) 
            return 0;

        Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(x -> x.id, Function.identity()));

        int ans = 0;

        Set<Integer> visited = new HashSet<>();

        Stack<Integer> s = new Stack<>();

        s.push(employee.id);

        while(!s.isEmpty()) {
            int id = s.pop();
            
            if(visited.contains(id))
                continue;

            visited.add(id);

            ans += map.get(id).importance;

            for(Integer subordinateId : map.get(id).subordinates) {
                if(!visited.contains(subordinateId)) {
                    s.push(subordinateId);
                }
            }
        }
    
        return ans;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
