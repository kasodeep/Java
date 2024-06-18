package Interview;

public class WrapperClasses {

    /*
     * For every primitive type we have class and this class extends the Object class.
     * */
    public static void main(String[] args) {
        int num = 7;
        Integer x = num; // auto-boxing.
        int y = x; // auto-unboxing.
    }
}
