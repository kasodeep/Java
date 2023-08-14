package Basics;

/*
 * Variable : It is the title of a reserved region allocated in memory.
 *              In other words, it may be referred to as the name of a memory location
 * Data Types : Data Types specify the different sizes and values that can be stored in the variable.
 *              Based on the datatype of the variable, the os allocates memory and decides what can be stored in the memory.
 *  Naming Conventions :   Functions  -> camelCase
                           Classes -> PascalCase
                           packages -> lowercase
 */

/*
 * 1 byte = 8bits
 * Primitive - byte(1) , short(2) , char(2) , boolean(1) , int(4) , long(8) ,  float(4) , double(8)
 * Non-Primitive - String , Array , Class , Object , Interface
 */

public class Variables {

    public static void main(String[] args) {

        int x = 2, y = 4;
        System.out.println(x * y);

        int ascii = 'U';
        System.out.println(ascii);

    }
}
