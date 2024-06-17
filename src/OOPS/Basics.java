package OOPS;

public class Basics {
    /**
     * public - all packages
     * private - only class
     * default - self package
     * -> Static functions are those which can be called without the object of the class but directly with class name.
     * -> Classes are passed by reference, hence the attributes of object can be modified.
     */

    public static void main(String[] args) {
        // object!
        Student student = new Student("Deep", 32, 93.0);
        System.out.print("Name:" + student.name + " ");
        System.out.print("RollNo:" + student.rollNo + " ");
        // System.out.print("Percentage:" + student.percent + "%");

        // static
        System.out.println(Student.numberOfStudents);
    }
}
