package OOPS;

public class Basics {

   /**
    * public - all packages
    * private - only class
    * default - self package
    * -> static functions are those which can be called without the object of the
    * class but directly with class name.
    * -> Classess are passed by reference, hence the attributes of object can be
    * modified.
    */

   public static void main(String[] args) {

      Student student = new Student("Deep", 32, 93.0);
      System.out.print("Name:" + student.name + " ");
      System.out.print("RollNo:" + student.rollno + " ");
      System.out.print("Percentage:" + student.percent + "%");
   }
}
