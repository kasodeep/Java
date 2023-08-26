package Sorting;

import java.util.Scanner;

public class SortOneTwoZero {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int n = scn.nextInt();

        int[] num = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            num[i] = scn.nextInt();
        }

        sortArr(num, n);
        for (int i = 0; i < n; i++) {
            System.out.print(num[i] + " ");
        }
    }

    public static void sortArr(int[] num, int n) {
        int i;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (i = 0; i < n; i++) {
            switch (num[i]) {
                case 0 -> count0++;
                case 1 -> count1++;
                case 2 -> count2++;
            }
        }

        i = 0;
        while (count0 > 0) {
            num[i++] = 0;
            count0--;
        }
        while (count1 > 0) {
            num[i++] = 1;
            count1--;
        }
        while (count2 > 0) {
            num[i++] = 2;
            count2--;
        }
    }
}
