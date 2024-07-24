package Greedy;

public class SmallestNumberDigits {

    public String smallestNumber(int s, int d) {
        StringBuilder ans = new StringBuilder();
        if (9 * d < s) return "-1";

        for (int i = d - 1; i >= 0; i--) {
            if (s > 9) {
                ans.append(9);
                s -= 9;
            } else {
                if (i == 0) ans.append(s);
                else {
                    ans.append((s - 1));
                    i--;

                    while (i > 0) {
                        ans.append(0);
                        i--;
                    }
                    ans.append(1);
                    break;
                }
            }
        }

        return ans.reverse().toString();
    }
}