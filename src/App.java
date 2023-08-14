/*
  Public : This is a visibility or access specifier that defines the component's visibility.
  Static : The keyword 'static' indicates that the method that follows this keyword can be invoked without the object or the dot(.) operator. 
  String[] args : Command Line Argument that are stored in string arrays.
 */

/*
    JVM - Class Loader, Memory Area, Execution Engine->Interpreter + JIT + GC
    JRE - JVM + Runtime Libraries
    JDK - JRE + Development Tools
 */

/*
    javac .\Main.java
    java Main
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! ");
        System.out.println(args[0]);
    }
}
