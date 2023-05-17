import java.util.Date;
import java.awt.*;

public class HelloWorld {
    public static void main(String[] args) {
        // HelloWorld.variables();
        // HelloWorld.primativeTypes();
        // HelloWorld.referenceTypes();
        // HelloWorld.referenceVsPrimativeTypes();
        HelloWorld.strings();
    }

    public static void variables() {
        // int age = 30, temporature = 20; // declare variables on the same line
        int age = 30;
        age = 35;
        System.out.println(age);
    }

    public static void primativeTypes() {
        int viewsCount = 123_456_789; // underscores can be used to make ints more readeable
        long viewsCountLong = 3_123_456_789L; // long - notice the ending suffex "L"
        float price = 10.99F; // float - notice the ending suffex "F"
        char letter = 'A'; // char uses single quotes
        boolean isEligible = false;
    }

    public static void referenceTypes() {
        Date now = new Date();
        // now.getTime()
        System.out.println(now); // shortcut: sout
    }

    public static void referenceVsPrimativeTypes() {
        byte x = 1;
        byte y = x;
        x = 2;
        System.out.println(y); // prints 1, because y is a primative type and set to 1 when we reference x

        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2; // this will update the value of x of the Point reference object also assigned to the point1 variable
        System.out.println(point2); // point 2 x will also equal 2
    }

    public static void strings() {
        // String message = new String("Hello World"); // redundant use of string
        // operator
        // String message = "Hello World"; // short hand to declare string variables
        String message = "Hello World" + "!!"; // string concatination
        System.out.println(message.endsWith("!!")); // true 
        System.out.println(message.startsWith("!!")); // false
        System.out.println(message.length()); // 13
        System.out.println(message.indexOf("e")); // 1
        System.out.println(message.indexOf("sky")); // -1
        System.out.println(message.replace("!", "*")); // Hello World**
        System.out.println(message); // Hello World (previous method did not mutate the original string, because strings are immutable
        System.out.println(message.toLowerCase()); // hello world!!
        System.out.println(message.toUpperCase()); // HELLO WORLD!!
        System.out.println(message.trim()); // remove white space at start or end of string
    }
}