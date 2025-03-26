package advenced.prototype;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements Prototype {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        loadEmployeeData();
    }

    public EmployeeService(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    private void loadEmployeeData() {
        // Database connection
        // read employee data from database
        this.employees.add(new Employee("Abdurahmon", "Mirmaxsudov", 20, new ArrayList<>(List.of(
                Address.builder()
                        .city("Tashkent")
                        .country("Uzbekistan")
                        .street("Something")
                        .postalCode(1000)
                        .build()
        ))));
        this.employees.add(new Employee("Qudratilla", "Salomov", 20, new ArrayList<>(List.of(
                Address.builder()
                        .city("Tashkent")
                        .country("Uzbekistan")
                        .street("Something")
                        .postalCode(3000)
                        .build(),
                Address.builder()
                        .city("Tashkent 2")
                        .country("Uzbekistan")
                        .street("Something 2")
                        .postalCode(2000)
                        .build()
        )
        )));
        this.employees.add(new Employee("Sardorbek", "Safaraliyev", 20, new ArrayList<>(List.of(
                Address.builder()
                        .city("Tashkent 3")
                        .country("Uzbekistan")
                        .street("Something 3")
                        .postalCode(5000)
                        .build()
        ))));
        this.employees.add(new Employee("Muhammad Ali", "Fayzullayev", 21, new ArrayList<>(List.of(
                Address.builder()
                        .city("Tashkent 5")
                        .country("Uzbekistan")
                        .street("Something 5")
                        .postalCode(42000)
                        .build()
        ))));
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
//        return (Prototype) super.clone(); // Shallow Copy.

        List<Employee> newEmployees = this.employees.stream()
                .map(
                        e -> new Employee(e.getFirstName(), e.getLastName(), e.getAge(), e.getAddresses()
                                .stream()
                                .map(Address::clone)
                                .toList())
                ).toList();

        return new EmployeeService(newEmployees);
    }
}