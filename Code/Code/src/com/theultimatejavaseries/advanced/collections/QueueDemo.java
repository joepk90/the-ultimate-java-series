package com.theultimatejavaseries.advanced.collections;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Queue Interface:
 * - the Queue interface represents a queue of objects.
 * - queues are used to process jobs in the order they are received.
 */

public class QueueDemo {
    public static void show() {
        Queue<String> queue = new ArrayDeque<String>();
        queue.add("c");
        queue.add("a");
        queue.add("b");

        // if the que get's full, the add method throws an exception,
        // whereas the offer method returns false
        // queue.offer("d");
        // d -> b -> a -> c

        // peek method returns null if no array elements exist
        var peekFront = queue.peek();
        System.out.println(peekFront); // c

        // element method throws an exception if no array elements exist
        var peekEleemnt = queue.element();
        System.out.println(peekEleemnt); // c

        var removeAndReturnFirstElement = queue.remove();
        // poll method throws an exception if no array elements exist
        // var pollAndReturnFirstElement = queue.poll();
        System.out.println(removeAndReturnFirstElement); // c

        System.out.println(queue); // [a, b]
    }

}
