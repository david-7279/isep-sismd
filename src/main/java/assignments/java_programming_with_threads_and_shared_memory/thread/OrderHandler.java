package main.java.assignments.java_programming_with_threads_and_shared_memory.thread;


import main.java.assignments.java_programming_with_threads_and_shared_memory.model.Order;
import main.java.assignments.java_programming_with_threads_and_shared_memory.model.OrderQueue;

// OrderHandlers são consumers (processam pedidos
public class OrderHandler extends Thread {
    OrderQueue orderQueue = new OrderQueue();

    public OrderHandler(OrderQueue orderQueue) {
        // Usa a fila partilhada
        this.orderQueue = orderQueue;
    }

    public void run() {
        while (true) {
            try {
                // Obter pedido da fila
                Order order = orderQueue.get();

                Thread.sleep(1000);

                System.out.println(this.getName() + " processed " + order);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
