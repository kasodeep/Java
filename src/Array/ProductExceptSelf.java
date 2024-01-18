package Array;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] a) {
        int prod = 1;
        int flag = 0;
        int n = a.length;

        for (int num : a) {
            if (num == 0) flag++;
            else prod *= num;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (flag > 1) {
                arr[i] = 0;
            } else if (flag == 0) {
                arr[i] = (prod / a[i]);
            } else if (flag == 1 && a[i] != 0) {
                arr[i] = 0;
            } else
                arr[i] = prod;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {-1, 1, 0, -3, 3};
        int[] exceptSelf = productExceptSelf(a);

        for (int num : exceptSelf) {
            System.out.print(num + " ");
        }
    }
}
