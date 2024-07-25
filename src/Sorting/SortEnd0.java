package Sorting;

public class SortEnd0 {

    public static void sort0(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 0, 3, 0, 4};
        sort0(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
