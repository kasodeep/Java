package Sorting;

public class LexicographicalOrder {

    public static void sort(String[] fruits) {
        int n = fruits.length;

        for (int i = 0; i < n; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (fruits[j].compareTo(fruits[min]) < 0) {
                    min = j;
                }
            }
            String temp = fruits[i];
            fruits[i] = fruits[min];
            fruits[min] = temp;
        }
    }

    public static void main(String[] args) {
        String[] fruits = {"papaya", "apple", "watermelon", "orange"};
        sort(fruits);

        for (String string : fruits) {
            System.out.print(string + " ");
        }
    }
}
