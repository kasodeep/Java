package Interview;

public class BuffersBuilder {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Deep");
        System.out.println(sb.capacity()); // It gives me 16 extra space, continuous memory location.
        sb.append(10D);

        /*
         * StringBuffer is thread safe, and StringBuilder is not thread safe.
         * */
    }
}
