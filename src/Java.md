### Java

- Java is a multi-platform, object-oriented language that can be used as a platform in itself.
- It is a fast, secure, reliable programming language for coding everything from mobile apps and enterprise software to
  big data applications and server-side technologies.
- It is a static typed language, type correctness checked before running.

### Compilation

1. We write code in files with extension: `.java`
2. The `javac` compiler converts the code into `byte` code.

### Execution

1. The JVM loads the different class loaders and the libraries, finding main to start execution.
2. Bootstrap {java.util}, Extension {java.sql}, Application {jars} are the different class loaders present.
3. Bytecode instructions are executed by Interpreter and JIT.

#### JVM

- Java Virtual Machine is a `virtual` environment which `executes` the byte code.
- It converts the byte code into `machine` code.
- It a program in itself.

#### JRE

- Stands for Java Runtime Environment.
- It includes JVM + Java APIs (The standard library code)

#### JDK

- Stands for Java Development Kit.
- JRE + Java Compiler + (Set of other tools)

```shell
javac Main.java
java -cp <path> Main.class
```

### Structure

- The Java files are usually not stored directly inside the source directory, but in subdirectories matching their
  package structure.

### Scope

1. Member Variables (Class Level Scope)
2. Local Variables (Method Level Scope)
3. Loop Variables (Block Scope)

- Formal parameters: These are the parameters that are defined during function method definition.
- Actual parameters: These are the parameters which are passed during the function/method call in other Function.

- Pass by Value: It is a process in which the function parameter values are simply copied to another variable(from
  actual to formal parameters). This is known as call by value.
- Pass by Reference: It is a process in which the copy of reference of actual parameter is passed to the function. This
  is called by call by reference.

### JShell
    Terminal shell to execute code temporary.

### Memory Model

- Each method has its own `Stack`.
- Heap is an `open` space where objects are stored.
- Objects have address in the stack.
