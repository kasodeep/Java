package String;

public class CountAndSay {

    public String countAndSay(int n) {
        String out = "1";

        for (int i = 0; i < n - 1; i++) {
            char prevChar = out.charAt(0);
            int count = 1;
            StringBuilder tmp = new StringBuilder();

            for (int j = 1; j < out.length(); j++) {
                if (prevChar == out.charAt(j))
                    count++;
                else {
                    tmp.append(count).append(prevChar);
                    prevChar = out.charAt(j);
                    count = 1;
                }
            }
            tmp.append(count).append(prevChar);
            out = tmp.toString();
        }
        return out;
    }
}
