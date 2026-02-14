package tasks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance690 {
    public static void main(String[] args) {

    }

    Map<Integer, Employee> mp = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees)
            mp.put(employee.id, employee);

        int sum = 0;

        Employee targetEmp = mp.get(id);
        sum += targetEmp.importance;

        sum += sum(targetEmp.subordinates);

        return sum;
    }

    public int sum(List<Integer> subordinates) {
        int sum = 0;
        for (Integer subordinate : subordinates) {
            Employee emp = mp.get(subordinate);
            sum += emp.importance;
            if (!emp.subordinates.isEmpty())
                sum += sum(emp.subordinates);
        }
        return sum;
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}