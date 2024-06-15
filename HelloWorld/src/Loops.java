import java.util.Scanner;

public class Loops {
    static public void main(String[] args) {
        // Loops.forLoops();
        Loops.whileLoops();
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
        while(!input.equals("quit")) {
            System.out.print("Input: ");
            input = scanner.next().toLowerCase();
            System.out.println(input);
        }

        scanner.close();

    }
}
