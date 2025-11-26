package Basics;

/**
 * Class: A user defined blue-print consisting of attributes/fields and methods.
 * <p>
 * Body - The body of class which consists of attributes, methods, constructors.
 * <p>
 * Objects: They are the instance of a class.
 * <p>
 * Object has three characteristics:
 * Identity - Unique name of the object
 * State - Attributes of an object
 * Behavior - Methods or logic executed on the object
 *
 * <p>
 * i) Private: The methods and/or data members declared as private are accessible only within the class where they are declared.
 * <p>
 * ii) Public: The methods that are declared public are accessible from everywhere in the program. There is no restriction on the scope of public data members.
 * <p>
 * iii) Protected: The methods declared as protected are accessible within the same package or subclasses in different packages.
 * <p>
 * iv) Default: When no access modifier is specified for a method – It is said to be having the default access modifier by default. Default access modifiers are accessible only within the same package.
 */
public class ClassExample {

    public static boolean is_LeapYear(int y) {
        boolean a = (y % 4) == 0;
        boolean b = (y % 100) != 0;
        boolean c = ((y % 100 == 0) && (y % 400 == 0));
        return a && (b || c);
    }

    public static String middle(String s) {
        if (s.length() % 2 == 0) {
            return s.substring(s.length() / 2, s.length() / 2 + 2);
        } else {
            return s.substring(s.length() / 2, s.length() / 2 + 1);
        }
    }

    public static void main(String[] args) {
        B b = new B();
    }

    static class A {
        static { System.out.println("A static"); }
        { System.out.println("A instance"); }
        A() { System.out.println("A constructor"); }
    }

    static class B extends A {
        static { System.out.println("B static"); }
        { System.out.println("B instance"); }
        B() { System.out.println("B constructor"); }
    }
}
