package Sorting;

public class MooreVoting {

    static int majorityElement(int[] a, int size) {
        int count = 0;
        int candidate = 0;

        for (int num : a) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        int sum = 0;
        for (int num : a) if (num == candidate) sum++;
        return sum > size / 2 ? candidate : -1;
    }
}
