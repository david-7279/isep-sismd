package main.java.assignments.java_programming_with_threads_and_shared_memory.model;

import java.util.LinkedList;

// Uses LinkedList to implement a list of orders.
public class OrderQueue {
    LinkedList<Order> orderQueue = new LinkedList<Order>();

    public synchronized Order get() {
        while (orderQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        return orderQueue.removeFirst();
    }

    public synchronized void put(Order order) {
        orderQueue.add(order);
        notifyAll();
    }
}
