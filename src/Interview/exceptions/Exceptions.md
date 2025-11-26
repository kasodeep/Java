### Checked exceptions

They must be explicitly caught or propagated as described in Basic try-catch-finally Exception Handling. Unchecked
exceptions do not have this requirement. They don't have to be caught or declared thrown.

### Checked exceptions

In Java extend the java.lang.Exception class. Unchecked exceptions extend the
java.lang.RuntimeException.

### Exception Wrapping

- Exception wrapping is when you catch an exception, wrap it in a different exception and throw that
  exception.

- The second reason is that you may not want your top level components to know anything about the bottom level
  components,
  nor the exceptions they throw.

- We might not be able to identify the root cause of the error, and debugging might take some time.
