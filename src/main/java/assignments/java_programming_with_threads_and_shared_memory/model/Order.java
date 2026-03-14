package main.java.assignments.java_programming_with_threads_and_shared_memory.model;

// Object that represents an order
public class Order {
    private int number;

    public Order(int number) {
        this.number = number;
    }

    public String toString() {
        return "Order: " + number;
    }
}