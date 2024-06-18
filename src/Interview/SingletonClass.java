package Interview;

/**
 * It allows us to create only one object.
 * Step1: Declare static data member which is instance of singleton class.
 * Step2: Create private constructor.
 * Step3: Create static factory method which allows us to create and access the object.
 */
public class SingletonClass {

    private static SingletonClass instance = null;

    private SingletonClass() {

    }

    public static SingletonClass getInstance() {
        if (instance == null)
            instance = new SingletonClass();
        return instance;
    }
}

