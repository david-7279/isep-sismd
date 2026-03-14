package main.java.assignments.java_programming_with_threads_and_shared_memory.thread;


import main.java.assignments.java_programming_with_threads_and_shared_memory.model.Order;
import main.java.assignments.java_programming_with_threads_and_shared_memory.model.OrderQueue;

// OrderTakers são producers (produzem pedidos)
public class OrderTaker extends Thread {
    OrderQueue orderQueue = new OrderQueue();

    // Contador partilhado entre todos os order takers
    private static int orderCount = 1;

    public OrderTaker(OrderQueue orderQueue) {
        // Usa a fila partilhada
        this.orderQueue = orderQueue;
    }

    public void run() {
        while (true) {
            try {
                // Criar novo pedido com número sequencial
                Order order = new Order(orderCount++);

                // Adiciona à fila
                orderQueue.put(order);

                System.out.println(this.getName() + " created " + order);

                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
