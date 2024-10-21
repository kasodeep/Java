package Basics;

import java.awt.*;

/**
 * Variable: It is the title of a reserved region allocated in memory.
 * In other words, it may be referred to as the name of a memory location
 * <p>
 * Data Types: Data Types specify the different sizes and values that can be stored in the variable.
 * Based on the datatype of the variable, the os allocates memory and decides what can be stored in the memory.
 * <p>
 * Naming Conventions:
 * Functions/Variables -> camelCase
 * Classes -> PascalCase
 * packages -> lowercase
 * <p>
 * 1 byte = 8 bits
 * Primitive - byte(1), short(2), char(2), boolean(1), int(4), long(8),  float(4), double(8)
 * Non-Primitive - String, Array, Class, Object, Interface
 * <p>
 * Implicit Casting:
 * byte > short > int > long > float > double
 */
public class Variables {

    public static void main(String[] args) {
        int x = 2, y = 4;
        System.out.println(x * y);

        int ascii = 'U';
        System.out.println(ascii);

        // Referencing of objects.
        Point point1 = new Point(10, 10);
        Point point2 = point1;

        point1.x = 20;
        System.out.println(point2);
        System.out.println(100D / 2);
    }
}
