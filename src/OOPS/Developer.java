package OOPS;

/*
 * <p>
 * Inheritance: super keyword is used to call the parent constructor.
 * extends keyword is used to implement inheritance in java.
 *
 * Polymorphism: one name, many forms.
 * Encapsulation: data protection & data hiding.
 * </p>
 * */
public class Developer extends Student {

    public Developer() {
    }

    public Developer(String name, int rollNo, double percent) {
        super(name, rollNo, percent);
    }

    // run-time polymorphism.
    public void walk() {
        System.out.println("Developer " + name + " is walking!");
    }
}
