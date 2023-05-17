import java.util.Date;
import java.awt.*;

public class HelloWorld {
    public static void main(String[] args) {
        // HelloWorld.variables();
        // HelloWorld.primativeTypes();
        // HelloWorld.referenceTypes();
        HelloWorld.referenceVsPrimativeTypes();
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
}