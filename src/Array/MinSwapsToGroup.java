package Array;

public class MinSwapsToGroup {

    public static int minSwap(int[] arr, int n, int k) {
        int count = 0;
        int elementsInWindow = 0, maxElements;
        int i;

        for (i = 0; i < n; i++) if (arr[i] <= k) count++;
        for (i = 0; i < count; i++) if (arr[i] <= k) elementsInWindow++;

        maxElements = elementsInWindow;
        while (i < n) {
            if (arr[i] <= k) elementsInWindow++;
            if (arr[i - count] <= k) elementsInWindow--;

            maxElements = Math.max(elementsInWindow, maxElements);
            i++;
        }
        return count - maxElements;
    }
}
