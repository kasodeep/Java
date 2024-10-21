package Interview.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * filter, map, sorted, limit, skip are all intermediate functions.
 * The parallel method is not always better.
 */
public class StreamExample {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Rishabh", 32, "Engineering"),
                new Employee("Akash", 25, "Sales"),
                new Employee("Jenil", 10, "Engineering"),
                new Employee("Meet", 30, "Sales"),
                new Employee("Parth", 27, "HR"),
                new Employee("Akshay", 17, "Engineering")
        );

        List<String> engineeringEmployeeOver25 = employees.stream()
                .filter(employee -> employee.getAge() > 25)
                .filter(employee -> ("Engineering").equals(employee.getDepartment()))
                .map(Employee::getName)
                .sorted()
                .toList();

        double averageAgeOfEmployees = employees.stream()
                .mapToDouble(Employee::getAge)
                .average()
                .orElse(0.0);

        Map<String, Double> averageAgeByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getAge)
                ));
    }

    static class Employee {
        private String name;
        private int age;
        private String department;

        public Employee(String name, int age, String department) {
            this.name = name;
            this.age = age;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }
    }
}
