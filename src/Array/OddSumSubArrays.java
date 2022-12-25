package Array;

// If n is odd, the number of odd subarrays is the previous number of even subarrays + 1.
public class OddSumSubArrays {

    static int oddSubArrays(int arr[]) {

        int odd = 0, even = 0, sum = 0;

        for (int num : arr) {
            if (num % 2 == 1) {
                int temp = odd;
                odd = even;
                even = temp;
                odd++;
            } else {
                even++;
            }
            sum += odd;
        }
        return sum;
    }

    // Time Complexity - O(n), Auxillary Space - O(1)
    public static void main(String[] args) {

        int arr[] = { 1, 3, 5 };
        System.out.println(oddSubArrays(arr));
    }
}
