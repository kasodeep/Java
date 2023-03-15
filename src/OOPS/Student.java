package OOPS;

public class Student {

   // Attributes of the class.
   String name;
   int rollno;
   double percent;

   // Static attribute - Only one copy for the entire class.
   private static int numberOfStudents;

   // Final Attribute - The value cannot be changes once initialized.
   final String COLLEGE_NAME = "VJTI";

   // Constructor
   public Student() {
      numberOfStudents++;
   }

   // When parameterized constructor is created, it overrides default hence need to
   // explicitly specify the default one.
   public Student(String name, int rollno, double percent) {
      this.name = name;
      this.rollno = rollno;
      this.percent = percent;
      numberOfStudents++;
   }

   // Getters and Setters
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getRollno() {
      return rollno;
   }

   public void setRollno(int rollno) {
      this.rollno = rollno;
   }

   public double getPercent() {
      return percent;
   }

   public void setPercent(int percent) {
      this.percent = percent;
   }

   public static int getNumberOfStudents() {
      return numberOfStudents;
   }

   public String getCOLLEGE_NAME() {
      return COLLEGE_NAME;
   }
}
