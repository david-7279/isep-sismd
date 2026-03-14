package main.java.assignments.java_programming_with_threads_and_shared_memory;


import main.java.assignments.java_programming_with_threads_and_shared_memory.model.OrderQueue;
import main.java.assignments.java_programming_with_threads_and_shared_memory.thread.OrderHandler;
import main.java.assignments.java_programming_with_threads_and_shared_memory.thread.OrderTaker;

/*
    Create an application that simulates a multithreaded ordering application in which multiple order takers.
    Each running the application in a separate thread, generate orders (just a number) that are added to the queue
    that runs in the application’s main thread. The orders are then handled by multiple order-handling threads,
    which remove orders from the queue and display them in the console.
 */
public class Main {
    public static void main(String[] args) {

        // Fila partilhada
        OrderQueue orderQueue = new OrderQueue();

        // Criar order takers (producers)
        OrderTaker taker1 = new OrderTaker(orderQueue);
        OrderTaker taker2 = new OrderTaker(orderQueue);

        // Criar handlers (consumers)
        OrderHandler handler1 = new OrderHandler(orderQueue);
        OrderHandler handler2 = new OrderHandler(orderQueue);

        // Iniciar threads
        taker1.start();
        taker2.start();

        handler1.start();
        handler2.start();
    }
}
