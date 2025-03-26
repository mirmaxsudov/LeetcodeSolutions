package advenced.prototype;

import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employees = employeeService.getEmployees();

        EmployeeService employeeService1 = (EmployeeService) employeeService.clone();
        List<Employee> employees1 = employeeService1.getEmployees();

        // ====================== Showing hashcode of employees & employees1 ======================

        System.out.println("Employees " + employees.hashCode());
        System.out.println("Employees 1 " + employees1.hashCode());

        System.out.println();

        // ====================== Showing hashcode of employees.getFirst() & employees1.getFirst() ======================

        Employee employee = employees.getFirst();
        Employee employee1 = employees1.getFirst();

        System.out.println("employee.hashCode() = " + employee.hashCode());
        System.out.println("employee1.hashCode() = " + employee1.hashCode());

        System.out.println();

        // ====================== Showing hashcode of employees & employees1 (Deleted address) ======================

        employee.getAddresses().removeFirst();

        System.out.println("employee.hashCode() = " + employee.hashCode());
        System.out.println("employee1.hashCode() = " + employee1.hashCode());

        System.out.println();

        System.out.println("employee = " + employee);
        System.out.println("employee1 = " + employee1);

    }
}