package Array;

import java.util.Scanner;

public class SubArraySum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array: ");

        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int i = 0, j = 0, sum = 0;
        while (j < n) {
            sum += arr[j];

            // If sum gets bigger, remove the last element.
            if (sum > s) {
                while (sum > s && i < j) {
                    sum -= arr[i++];
                }
            }

            if (sum == s) {
                System.out.print(i + " ");
                System.out.print(j);
                break;
            }
            j++;
        }
    }
}
