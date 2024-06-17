package Basics;

/*
    Class : A user defined blue-print consisting of attributes and methods.
    Body - The body of class which consists of attributes, objects, methods.
    Objects : They are the instance of a class.
    Object has three characteristics - 
 	* Identity - Unique name of the object
 	* State - Attributes of an object
 	* Behavior - Methods or logic executed on the object
 */

/*
 * i) Private :The methods and/or data members declared as private are accessible only within the class where they are declared.
 * ii) Public : The methods that are declared public are accessible from everywhere in the program. There is no restriction on the scope of public data members.
 * iii) Protected :  The  methods  declared  as  protected  are accessible within  the  same  package  or  subclasses  in different  packages.
 * iv) Default : When no access modifier is specified for a  method – It is said to be having the default access modifier by default. Default access modifiers are accessible only within the same package.
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

    }
}
