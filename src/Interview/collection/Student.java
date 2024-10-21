package Interview.collection;

import java.util.Comparator;
import java.util.Objects;

/**
 * Comparator: Has compare method with two arguments.
 * Comparable: Has compareTo method with one argument(for Arrays.sort()).
 * <p>
 * The Comparator is an external component to the objects being compared, whereas the Comparable is an interface implemented by the compared objects themselves.
 */
public class Student implements Comparator<Student> {

    private String name;

    private Integer rollNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                '}';
    }

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.rollNo, o2.rollNo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(rollNo, student.rollNo);
    }

    @Override
    public int hashCode() {
        // return Objects.hash(rollNo);
        return this.rollNo + this.name.hashCode();
    }
}
