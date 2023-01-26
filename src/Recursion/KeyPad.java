package Recursion;

public class KeyPad {
    
        static void combination(String dig, String[] kp, String res){ 

            // Base-Case
            if(dig.length() == 0){
                System.out.print(res + " ");
                return;
            }

            // Self-Work
            int currNum = dig.charAt(0) - '0';
            String currChoices = kp[currNum]; 

            // Recursive Work
            for(int i = 0; i < currChoices.length(); i++){ 
                combination(dig.substring(1), kp, res + currChoices.charAt(i));
            }
        }

    public static void main(String[] args) {
        
        String dig = "253";
        String[] kp = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combination(dig, kp, "");
    }
}
