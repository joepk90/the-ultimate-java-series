public class Loops {
    static public void main(String[] args) {
        Loops.forLoops();
    }

    public static void forLoops() {
        for (int i = 0; i < 5; i++)
            System.out.println("Hello World " + i);

        for (int i = 5; i > 0; i--) {
            System.out.println("Hello World " + i);
        }   
    }
}
