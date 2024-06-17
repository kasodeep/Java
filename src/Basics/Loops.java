package Basics;

/* Continue : The continue keyword is used to end the current iteration in a for loop (or a while loop), and continues to the next iteration.
   Break : The break command allows you to terminate and exit a loop ( do while / for / while ) or switch commands from any point other than the logical end.
*/
public class Loops {

    public static void main(String[] args) {
        // Continue, Labels
        first:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (i == 1 && j == 1)
                    continue first;
                System.out.println(i + " " + j);

            }
        }

        // Break, Labels
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (i == 1 && j == 1)
                    break outer;
                System.out.println(i + " " + j);

            }
        }
    }
}
