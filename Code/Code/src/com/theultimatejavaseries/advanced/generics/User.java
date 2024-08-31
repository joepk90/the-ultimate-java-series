package com.theultimatejavaseries.advanced.generics;

public class User implements Comparable<User> {
    private int points;

    // default contructor added to prevent compilition errors of existing usages
    public User() {
        this.points = 0;
    }

    public User(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(User other) {
        // if (points < other.points)
        // return -1;
        // if (points == other.points)
        // return 0;
        // return -1;

        // same expression as above
        return points - other.points;
    }

    @Override
    public String toString() {
        return "Point=" + points;
    }
}
