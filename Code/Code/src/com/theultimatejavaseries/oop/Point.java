package com.theultimatejavaseries.oop;
import java.util.Objects;

public class Point {
    private int x;
    private int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // auto generated code using vscode: Right CLick -> Source Action -> Generate hashCode and Equals...
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    // @Override
    // public boolean equals(Object obj) {

    //     // compares the address in memory
    //     if (this == obj) 
    //         return true;

    //     if (!(obj instanceof Point))
    //         return false;

    //     var other = (Point)obj;
    //     return other.x == x && other.y == y;
    // }

    // // whenever we override the equals method, we should also override the hashcode method
    // @Override
    // public int hashCode() {
    //   return Objects.hash(x, y);
    // }

    
}