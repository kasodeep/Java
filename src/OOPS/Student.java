package OOPS;

/**
 * Classes And Objects: ✅
 * this -> can be used to access the current object or call default constructor.
 */
public class Student {
    public static int numberOfStudents;

    final String COLLEGE_NAME = "VJTI";

    protected String name;

    protected int rollNo;

    private double percent;

    public Student() {
        numberOfStudents++;
    }

    static {
        System.out.println("This block will be executed once.");
        System.out.println("Runs when the class loader loads the class.");
    }

    // Two types of initializer blocks.
    {
        System.out.println("A new student has been created.");
    }

    /*
     * When parameterized constructor is created, it overrides default hence need to explicitly specify the default one.
     */
    public Student(String name, int rollNo, double percent) {
        this(); // to increment the number of students.
        this.name = name;
        this.rollNo = rollNo;
        this.percent = percent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public void walk() {
        System.out.println(name + " is walking!");
    }

    // compile time polymorphism.
    public void walk(int steps) {
        System.out.println(name + " is walking! " + steps + " steps!");
    }
}