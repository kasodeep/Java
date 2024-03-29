package Array;

public class BikerAltitude {

    /**
     * @param arr - This arr contains the altitudes of mountains.
     * @return - It returns the maximum altitude reached by the biker.
     */
    static int maxAltitude(int[] arr) {
        int curr_Altitude = 0;
        int max_Altitude = 0;

        for (int num : arr) {
            curr_Altitude += num;
            if (max_Altitude < curr_Altitude)
                max_Altitude = curr_Altitude;
        }
        return max_Altitude;
    }

    // Time Complexity - O(n), Auxiliary Space - O(1)
    public static void main(String[] args) {
        int[] arr = {-5, 1, 5, 0, -7};
        System.out.println(maxAltitude(arr));
    }
}
