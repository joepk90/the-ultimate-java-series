import java.util.Date;
import java.awt.*;
import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        // HelloWorld.variables();
        // HelloWorld.primativeTypes();
        // HelloWorld.referenceTypes();
        // HelloWorld.referenceVsPrimativeTypes();
        // HelloWorld.strings();
        HelloWorld.arrays();
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
        System.out.println(now);
    }

    public static void referenceVsPrimativeTypes() {
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2;
        System.out.println(point2); // point 2 x will also equal 2
    }

    public static void strings() {
        // String message = new String("Hello World"); // redundant use of string
        // operator
        // String message = "Hello World"; // short hand to declare string variables
        String message = "Hello World" + "!!"; // string concatination
        System.out.println(message.endsWith("!!"));
        System.out.println(message.startsWith("!!"));
        System.out.println(message.length());
        System.out.println(message.indexOf("e")); // 1
        System.out.println(message.indexOf("sky")); // -1
        System.out.println(message.replace("!", "*")); // -1
        System.out.println(message); // original string not changed - strings are immutable
        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());
        System.out.println(message.trim()); // remove white space at start or end of string

        // escaping strings
        String escapedMessage = "Hello \"Joe\"";
        String escapedBackSlash = "c:\\Windows\\"; // escaping backslashes
        String escapedNewLine = "c:\nWindows\\"; // escaping backslashes
        String escapedTab = "c:\tWindows\\"; // escaping backslashes
        System.out.println(escapedMessage);
        System.out.println(escapedBackSlash);
        System.out.println(escapedNewLine);
        System.out.println(escapedTab);
    }

    public static void arrays() {
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;

        System.out.println(Arrays.toString(numbers));

        // java arrays have a fixed length - 5
        int[] numbers2 = { 2, 3, 5, 1, 4 };
        System.out.println(numbers.length);

        Arrays.sort(numbers2);
        System.out.println(Arrays.toString(numbers2));
    }

}