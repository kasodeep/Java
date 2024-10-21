package Interview.streams;

public class Employee {

    private int age;

    private int salary;

    private String department;

    public Employee(int age, int salary, String department) {
        this.salary = salary;
        this.department = department;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
