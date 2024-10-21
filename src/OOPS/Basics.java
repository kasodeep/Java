package OOPS;

public class Basics {

    public static void main(String[] args) {
        Student student = new Student("Deep", 32, 93.0);

        System.out.print("Name:" + student.name + " ");
        System.out.print("RollNo:" + student.rollNo + " ");
        System.out.println(Student.numberOfStudents);
    }
}
