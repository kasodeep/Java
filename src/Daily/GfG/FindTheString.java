package Daily.GfG;

import java.util.HashMap;

public class FindTheString {

    public static String findString(int n, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) ans.append('0');

        HashMap<String, Integer> map = new HashMap<>();
        map.put(ans.toString(), 1);

        int cnt = k - 1;
        StringBuilder curr = new StringBuilder();
        curr.append(ans);

        while (true) {
            StringBuilder temp = new StringBuilder(curr.substring(1));
            temp.append((char) (cnt + '0'));

            if (!map.containsKey(temp.toString())) {
                map.put(temp.toString(), 1);
                ans.append((char) (cnt + '0'));
                curr = temp;
                cnt = k - 1;
            } else {
                cnt--;
            }
            if (cnt == -1) {
                break;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {

    }
}
