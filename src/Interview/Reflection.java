package Interview;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Reflection is an API that is used to examine or modify the behavior of methods, classes, and interfaces at runtime.
 * Reflection gives us information about the class to which an object belongs and also the methods of that class that can be executed by using the object.
 * <p>
 * Drawbacks: 1) Performance hit over regular getters and setters.
 * 2) Compromised access control as private members are exposed.
 * 3) Prone to more errors at runtime like NoSuchMethodFound.
 */
public class Reflection {
    public static void main(String[] args) {
        try {
            Class<?> personClass = Class.forName("Interview.Person");

            // Get the classname.
            System.out.println("Class name: " + personClass.getName());

            // Get the fields.
            System.out.println("Fields:");
            Field[] fields = personClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(" " + field.getName());
            }

            // Get the methods.
            System.out.println("Methods:");
            Method[] methods = personClass.getMethods();
            for (Method method : methods) {
                System.out.println(" " + method.getName());
            }

            // getting all the constructors.
            System.out.println("Constructors:");
            Constructor<?>[] constructors = personClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(" " + constructor.getName());
            }

            // Create an instance of person class.
            Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
            Object personInstance = constructor.newInstance("Deep", 20);

            // Access and modify the private fields.
            Field nameField = personClass.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(personInstance, "Parth");

            System.out.println(personInstance);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}


