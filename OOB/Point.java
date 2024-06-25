import java.util.Objects;

public class Point {
    private int x;
    private int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {

        // compares the address in memory
        if (this == obj) 
            return true;

        if (!(obj instanceof Point))
            return false;

        var other = (Point)obj;
        return other.x == x && other.y == y;
    }

    // whenever we override the equals method, we should also override the hashcode method
    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
}