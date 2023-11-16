package Daily.LeetCode;

public class BinaryStrings {

    public static String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            Character curr = nums[i].charAt(i);
            ans.append(curr == '0' ? '1' : '0');
        }

        return ans.toString();
    }

    public static void main(String[] args) {

    }
}
