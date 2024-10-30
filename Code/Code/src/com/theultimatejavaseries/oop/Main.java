package com.theultimatejavaseries.oop;

import com.theultimatejavaseries.projects.mortgageproject.TaxCalculator2018;
import com.theultimatejavaseries.projects.mortgageproject.TaxCalculator2019;
import com.theultimatejavaseries.projects.mortgageproject.TaxReport;

public class Main {

    public static void main(String[] args) {
        // Main.employeeClassUsage();
        // Main.InheritanceExample();
        // Main.upcastingAndDowncasting();
        // Main.comparingObjects();
        // Main.polymorphism();
        // Main.abstractClassesAndMethods();
        Main.dependancyInjection();
    }

    public static void employeeClassUsage() {
        var employee = new Employee(50_000, 20);
        Employee.printNumberOfEmployees();

        int wage = employee.calculateWage(10);
        System.out.println(wage);
    }

    public static void InheritanceExample() {
        var control = new TextBox();
        control.disable();
        System.out.println(control.isEnabled());

        var textBox = new TextBox();
        textBox.setText("Hello World");
        // Hello World is printed instead of TextBox@251a69d7
        // becase the method is being overidden
        System.out.println(textBox.toString());

        // this acheives the same result becuase by default the println function calls
        // the toString method
        System.out.println(textBox);

    }

    // reducing coupling
    public static void initialiseBrowser(String[] args) {
        var browser = new Browser();

        // because every method is private ( except navigate) coupling is reduced
        // as there is only one method which can be accessed from the outside
        browser.navigate("");
    }

    public static void objectClassDocumentation() {

        // OBJECT METHODS
        // var obj = new Object()
        // obj.getClass();
        // obj.equals();
        // obj.hashCode();
        // obj.toString();
        // obj.notify();
        // obj.notifyAll();

        // OBJECT HASHCODE
        var box1 = new TextBox();

        // returns integer calculated based on the address of this object in memory
        // it does NOT actually return the address of this object in memory.
        // it returns the hashcode of this object, which the hashed address in memory
        System.out.println(box1.hashCode());

        var box2 = box1;
        System.out.println(box2.hashCode()); // returns the same value

        // OBJECT EQUALITY
        System.out.println(box1.equals(box2)); // returns true

        var box3 = new TextBox();
        System.out.println(box1.equals(box3)); // returns false

        // OBJECT TOSTRING
        // returns string represenation of an object
        // returns the full name of the class + the hashcode
        System.out.println(box1.toString());

    }

    public static void upcastingAndDowncasting() {

        // because we are casting the control arguemnt to a TextBox instance
        // in the upcastingAndDowncasting method, this code will cause an exception
        // we cannot cast the parent class to a child class (a more specialised type)
        // a check has been added to the upcastingAndDowncasting to prevent the
        // exception
        // var control = new UIControl(true); // no longer possible because UIControl is
        // an abstract class
        // Main.show(control);

        /**
         * Upcasting
         * - textBox is an instance of the UIControl class (required argument)
         * - it is being passed to a method which requires a UIControl object (it's
         * parent)
         */
        var textBox = new TextBox();

        Main.show(textBox);
    }

    public static void show(UIControl control) {
        if (control instanceof TextBox) {
            var textBox = (TextBox) control;
            textBox.setText("Hello World");
        }

        System.out.println(control);
    }

    public static void comparingObjects() {
        var point1 = new Point(1, 2);
        var point2 = new Point(1, 2);
        System.out.println(point1 == point2); // false

        // the below statement returns true because we have overidden the equals method
        // in the Point class
        System.out.println(point1.equals(point2)); // true

        // this is handled gracefully because of the check in the overridden equals
        // method on the Point class
        System.out.println(point1.equals(new TextBox())); // false

        // comparing the object address in memory
        System.out.println(point1.equals(point1)); // true

        // override hashcode method
        System.out.println(point1.hashCode()); // 994
        System.out.println(point2.hashCode()); // 994

    }

    public static void polymorphism() {
        UIControl[] controls = { new TextBox(), new CheckBox() };

        // PROBLEM:
        // procedual way of rendering an instance of the controls array
        // not dynamic...
        // for (var control : controls ) {
        // if (control instanceof TextBox) {
        // render TextBox
        // } else if (control instanceof CheckBox) {
        // render CheckBox
        // }
        // }

        // SOLUTION (using polymorphism)
        for (var control : controls) {
            control.render();
        }

    }

    public static void abstractClassesAndMethods() {
        // the following is not possible the UIControl is an abstract class
        // and the render method is an abstract method
        // UIControl uicontrol = new UIControl();
        // uicontrol.render();
    }

    public static void dependancyInjection() {
        System.out.println("TAX CALCULATOR LOGIC: ");
        // constuctor injection (poor mans dependancy injection)
        var report = new TaxReport(new TaxCalculator2018(100_000));
        System.out.println("tax calculator 2018 report:");
        report.show();

        // setter injection
        report.setCalculator(new TaxCalculator2019());
        System.out.println("tax calculator 2019 report:");
        report.show();

        // method injection
        report.show(new TaxCalculator2018(100_000));
    }
}
