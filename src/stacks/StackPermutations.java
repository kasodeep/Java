package stacks;


import java.util.*;

public class StackPermutations {

    public static boolean checkStackPermutation(List<Integer> input, List<Integer> output) {
        Stack<Integer> s = new Stack<>();
        int j = 0;

        for (Integer num : input) {
            s.push(num);

            while (!s.empty() && s.peek().equals(output.get(j))) {
                s.pop();
                j++;
            }

            if (j < output.size() && s.peek().equals(output.get(j))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8));
        List<Integer> output = new ArrayList<>(Arrays.asList(8, 7, 6, 5, 4));

        if (input.size() != output.size()) {
            System.out.println("Not Possible");
            return;
        }

        if (checkStackPermutation(input, output)) {
            System.out.println("Yes");
        } else {
            System.out.println("Not Possible");
        }
    }
}
