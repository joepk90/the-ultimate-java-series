import java.util.Scanner;

public class Loops {
    static public void main(String[] args) {
        // Loops.forLoops();
        Loops.whileLoops();
        // Loops.doWhileLoops();
    }

    public static void forLoops() {
        for (int i = 0; i < 5; i++)
            System.out.println("Hello World " + i);

        for (int i = 5; i > 0; i--) {
            System.out.println("Hello World " + i);
        }   
    }

    public static void whileLoops() {
        int i = 1;
        while(i > 0) {
            System.out.println("Hello World " + i);
            i--;
        }

        Scanner scanner = new Scanner(System.in);

        String input = "";
        
        while(true) {
        // break statement required to avoid infinite loop
        // alternatively use the input.equals("quit") comparison to stop the loop

            System.out.print("Input: ");
            input = scanner.next().toLowerCase();

            // move control  to the beginning of the loop (prevent printing to the console but continue looping)
            if (input.equals("pass"))
                continue;

            if (input.equals("quit"))
                break;

            System.out.println(input);

            // alternative approach to prevent "quit" being printed to the console
            // if (!input.equals("quit"))
            //     System.out.println(input);
        }

        scanner.close();

    }

    public static void doWhileLoops() {

        Scanner scanner = new Scanner(System.in);

        String input = "";

        /**
         * Do While Loops
         * always get execeted at least once, even if the condition is false
         */
        do {
            System.out.print("Input: ");
            input = scanner.next().toLowerCase();
            System.out.println(input);
        } while(!input.equals("quit"));

        scanner.close();
    }
}
