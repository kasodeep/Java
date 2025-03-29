package OOPS;

/**
 * Abstraction: We don't want to create the object of this current class.
 * Interfaces: It tries to provide true abstraction.
 */
abstract public class Car {

    String brand;

    int price;

    abstract void start(); // this method needs to be overridden.
}

class Audi extends Car {

    @Override
    void start() {
        System.out.println("Audi, Start!");
    }
}
