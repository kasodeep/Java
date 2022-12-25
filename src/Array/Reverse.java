package Array;

public class Reverse {

    static void reverseArray(int arr[]) {

        int temp;
        int start = 0, end = arr.length - 1;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void printArray(int arr[], int size) {

        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6 };
        reverseArray(arr);
        System.out.print("Reversed array is \n");
        printArray(arr, 6);
    }
}
