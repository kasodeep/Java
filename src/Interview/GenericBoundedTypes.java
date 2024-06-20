package Interview;

import java.util.List;

/*
 * Bounded type parameters in Java generics allow you to restrict the types that can be used as arguments in a generic class, interface or methods.
 * Upper Bounded: This type specifies the types that can be used as arguments to be a subtype of a particular class.
 * Lower Bounded: It restricts the types that can be used as arguments to be a subtype of a particular class or interface.
 * */
public class GenericBoundedTypes {

    public static void main(String[] args) {

    }

    // bounded type parameter.
    public static <T extends Number & Comparable<T>> void finaMax(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty!");
        }

        T max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            T current = list.get(i);
            if (current.compareTo(max) > 0) max = current;
        }
        System.out.println(max);
    }
}
