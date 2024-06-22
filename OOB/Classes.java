public class Classes {
    public static void main(String[] args) {
        // creatingObjects();
        memoryAllocation();
    }

    public static void creatingObjects() {
        var textBox1 = new TextBox();
        textBox1.setText("Box 1");
        System.out.println(textBox1.getText().toUpperCase());

        var textBox2 = new TextBox();
        textBox2.setText("Box 2");
        System.out.println(textBox1.getText());
    }

    public static void memoryAllocation() {
         /**
         * Heap: stores objects
         */

         /**
         * Stack: stores short lived variables
         * - primatives
         * - varialbes whcih stores references ot objects on the heap
         */

        var textBox1 = new TextBox();

        /**
         * TextBox object:
         * - Storied on the heap
         * 
         * 
         * Variable:
         * - Allocated memory on the stack.
         * - In this memory location it will store the address of the TextBox obbject on the heap
         */

        var textBox2 = textBox1;
        // both textBox1 and textBox2 are referencing the same TextBox object on the heap.
        // the two varaible on the stack which reference the same TextBox object

        textBox2.setText("Hello World");        
        System.out.println(textBox2.getText()); // "Hello World
    }
}
