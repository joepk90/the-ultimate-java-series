package com.theultimatejavaseries.fundamentals;

import java.util.Date;
import java.util.Scanner;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;

public class Types {
    public static void main(String[] args) {
        // Types.variables();
        // Types.primativeTypes();
        // Types.referenceTypes();
        // Types.referenceVsPrimativeTypes();
        // Types.strings();
        // Types.arrays();
        // Types.multidemnsionalArrays();
        // Types.constants();
        // Types.arithmaticExpressions();
        // Types.orderOfOperations();
        // Types.casting();
        // Types.mathClass();
        // Types.formattingNumbers();
        Types.readingInput();
    }

    public static void variables() {
        // int age = 30, temporature = 20; // declare variables on the same line
        int age = 30;
        age = 35;
        System.out.println(age);
    }

    @SuppressWarnings("unused")
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
        point1.x = 2; // this will update the value of x of the Point reference object also assigned
                      // to the point1 variable
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
        System.out.println(message); // Hello World (previous method did not mutate the original string, because
                                     // strings are immutable
        System.out.println(message.toLowerCase()); // hello world!!
        System.out.println(message.toUpperCase()); // HELLO WORLD!!
        System.out.println(message.trim()); // remove white space at start or end of string

        // escaping strings
        String escapedMessage = "Hello \"Joe\"";
        String escapedBackSlash = "c:\\Windows\\"; // escaping backslashes
        String escapedNewLine = "c:\nWindows\\"; // new line
        String escapedTab = "c:\tWindows\\"; // tab
        System.out.println(escapedMessage); // Hello "Joe"
        System.out.println(escapedBackSlash); // c:\Windows\
        System.out.println(escapedNewLine); // c: {NEW LINE} Windows\
        System.out.println(escapedTab); // c: Windows\
    }

    public static void arrays() {
        // old array declaration syntax
        int[] numbers = new int[5]; // array length is set to 5
        numbers[0] = 1;
        numbers[1] = 2;
        // numbers[10] = 3; // throws an Exception (error)

        System.out.println(numbers); // returns memory address: I@28a3868
        System.out.println(Arrays.toString(numbers)); // [1, 2, 0, 0, 0]

        // new array declaration syntax
        int[] numbers2 = { 2, 3, 5, 1, 4 }; // java arrays have a fixed length - 5 in this circumstance because it is
                                            // declared with 5
        System.out.println(numbers.length); // 5

        Arrays.sort(numbers2);
        System.out.println(Arrays.toString(numbers2)); // [1, 2, 3, 4, 5]
    }

    public static void multidemnsionalArrays() {
        // int[][][] numbers = new int[2][3][5]; // 3 dimensional array
        int[][] numbers = new int[2][3]; // 2 dimensional array
        numbers[0][0] = 1;
        System.out.println(Arrays.toString(numbers)); // [I@2b2fa4f7, [I@1dbd16a6] - prints the reference, because array
                                                      // values points to another array
        System.out.println(Arrays.deepToString(numbers)); // [[1, 0, 0], [0, 0, 0]] - prints the array values

        int[][] numbersBracketSyntax = { { 1, 2, 3 }, { 4, 5, 6 } }; // 2 dimensional array
        System.out.println(Arrays.deepToString(numbersBracketSyntax)); // [[1, 2, 3], [4, 5, 6]]
    }

    public static void constants() {
        // by convention, constants are declared using capital letters
        @SuppressWarnings("unused")
        final float PI = 3.14F;
        // PI = 1; // final prevents pi from being reasigned
    }

    public static void arithmaticExpressions() {
        // arithmatic expressions
        // int result = 10 + 3; // 13
        // int result = 10 - 3; // 7
        // int result = 10 * 3; // 30
        int result = 10 / 3; // 3 - devision of a whole number will equal a whole number
        System.out.println(result);

        double result2 = (double) 10 / (double) 3; // 3.333333333....
        System.out.println(result2);

        // increment expresions
        int x = 1;
        // x++; // ++x also works
        int y = x++;

        System.out.println("x: "); // 2 (x has been incremented)
        System.out.println(x); // 2 (x has been incremented)
        System.out.println("y: "); // 1 (y has been copied before x was incremented)
        System.out.println(y); // 1 (y has been copied before x was incremented)

        // using prefix to increment
        int x2 = 1;
        int y2 = ++x2;
        System.out.println("x2: "); // 2
        System.out.println(x2); // 2
        System.out.println("y2: "); // 2
        System.out.println(y2); // 2

        // augmented/compound assignment operators
        int x3 = 1;
        // x3 = x3 + 2; // 3
        x3 += 2; // 3 (producers the same result as the line above)

        // other augmented/compound assignment operator examples
        // x3 -= 2;
        // x3 *= 2;
        // x3 /= 2;
        System.out.println(x3);
    }

    public static void orderOfOperations() {

        /**
         * Priority Order:
         * - ()
         * - * /
         * - +-
         */

        int x = 10 + 3 * 2;
        System.out.println(x); // 16

        int y = (10 + 3) * 2;
        System.out.println(y); // 26
    }

    public static void casting() {

        /**
         * Imlicit Casting
         * implicit casting occurs when there is no chance of data loss
         * byte > short > int > long > float > double
         */

        // short > int
        short x = 1; // 2 bytes
        int y = x + 2; // 4 bytes
        System.out.println(y); // 3

        // int > double
        double x2 = 1.1;
        double y2 = x2 + 2; // double and int (int will be casted to a double: 2.0)
        System.out.println(y2); // 3.1

        /**
         * Explicit Casting
         */

        // double > int
        double x3 = 1.1;
        int y3 = (int) x3 + 2; // double and int (double will be casted to an int: 1)
        System.out.println(y3); // 3

        // string > int
        String x4 = "1";
        int y4 = Integer.parseInt(x4) + 2;
        System.out.println(y4); // 3

        // string > double
        String x5 = "1.1";
        double y5 = Double.parseDouble(x5) + 2;
        System.out.println(y5); // 3.1
    }

    public static void mathClass() {

        // round: rounding to a whole number
        int roundResult = Math.round(1.1F);
        System.out.println(roundResult); //

        // ceil: converts a decimal number to the immediate largest integer
        int ceilResult = (int) Math.ceil(1.1F);
        System.out.println(ceilResult); // 2

        // floor: returns a value of type double, the largest integer that is less than
        // or equal to the specified value.
        int floorResult = (int) Math.floor(1.1F);
        System.out.println(floorResult); // 1

        // max: returns the larger number
        int maxResult = (int) Math.max(1, 2);
        System.out.println(maxResult); // 2

        // min: returns the smaller number
        int minResult = (int) Math.min(1, 2);
        System.out.println(minResult); // 1

        // random: returns floating point number between 0 - 1
        double randomResult = Math.random();
        System.out.println(randomResult);

        // random (custom): return int between 0 - 100
        // int randomResult100 = (int) Math.round(Math.random() * 100);
        int randomResult100 = (int) (Math.random() * 100);
        System.out.println(randomResult100);
    }

    public static void formattingNumbers() {

        // instantiating a new NumberFormat is not possible because it is abstract.
        // NumberFormat currency = new NumberFormat();

        // getCurrencyInstance is a factory method returning and returns an instance of
        // NumberFormat
        // NumberFormat currency = NumberFormat.getCurrencyInstance();
        // String currencyResult = currency.format(1234567.891);
        // System.out.println(currencyResult); // ¤1,234,567.89

        // getPercentInstance is a factory method and returns an instance of
        // NumberFormat
        // NumberFormat percent = NumberFormat.getPercentInstance(); //
        // String percentResult = percent.format(0.1);
        // System.out.println(percentResult); // 10%

        // simplified version using method chaining
        String currencyResult = NumberFormat.getCurrencyInstance().format(1234567.891);
        System.out.println(currencyResult);// ¤1,234,567.89

        String percentResult = NumberFormat.getPercentInstance().format(0.1);
        System.out.println(percentResult); // 10%

    }

    public static void readingInput() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Age: ");
        byte age = scanner.nextByte();
        System.out.println("You are " + age);

        System.out.print("Name: ");
        // String name = scanner.next();
        // next reads one token at a time (so only the first word is captured)
        // for example: John Smith will output John
        // To solve this use nextLine

        String name = scanner.nextLine().trim(); // trim unnecccesary white space before and after any tokens
        System.out.println("You are " + name);
    }

}