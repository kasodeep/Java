package Greedy;

import java.util.Scanner;

/**
 * Given the number of days S to survive on an island.
 * You can buy food on all days except sunday.
 * You are also given the food units consumed by you each day as M.
 * Also the max food you can buy on every day is N.
 */
public class Survive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter S, N, M: ");
        int S = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        int totalFood = S * M;
        int result;
        if (M > N || (S >= 6 && (7 * M) > (6 * N))) {
            result = -1;
        } else {
            result = (int) Math.ceil((double) totalFood / N);
        }
        System.out.println(result);
    }
}
