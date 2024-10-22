package Interview.execptions;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * When exception occurs the resources are closed automatically.
 * However, some resource throws an exception on closing, and hence it will be suppressed.
 * While the original exception will climb up in the call stack.
 */
public class TryWithHer {

    private static void printFile() throws IOException {
        try (FileInputStream input = new FileInputStream("file.txt")) {
            int data = input.read();

            while (data != -1) {
                System.out.print((char) data);
                data = input.read();
            }
        }

        try (FileInputStream input = new FileInputStream("file.txt");
             BufferedInputStream bufferedInput = new BufferedInputStream(input)
        ) {
            int data = bufferedInput.read();

            while (data != -1) {
                System.out.print((char) data);
                data = bufferedInput.read();
            }
        } catch (Exception e) {
            Throwable[] suppressed = e.getSuppressed();
            throw e;
        }
    }
}
