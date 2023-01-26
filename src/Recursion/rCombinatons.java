package Recursion;

import java.util.Arrays;

public class rCombinatons {
    
	static int count;
	static void combinationUtil(int arr[], int n, int r, int index, int data[], int i) {

		if (index == r) {
			count++;
			return;
		}

		// When no more elements are there to put in data[]
		if (i >= n)
			return;

		// Current is included, put next at next location.
		data[index] = arr[i];
		combinationUtil(arr, n, r, index + 1, data, i + 1);

		// Current is excluded, replace it with next.
		combinationUtil(arr, n, r, index, data, i + 1);
	}

	static void printCombination(int arr[], int n, int r) {

        // index to access data, and i to access array
		Arrays.sort(arr);
		int data[] = new int[r];
		combinationUtil(arr, n, r, 0, data, 0);
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, };
		int r = 2;
		int n = arr.length;
		printCombination(arr, n, r);
		System.out.println(count);
	}
}
