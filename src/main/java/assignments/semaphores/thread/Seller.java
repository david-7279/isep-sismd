package main.java.assignments.semaphores.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Seller extends Thread {

    // Um Semaphore controla quantas threads podem aceder simultaneamente.
    // Protege recursos. Cada thread precisa de permissão para usar um recurso.
    private final Semaphore semaphore;
    AtomicInteger numTicket;

    public Seller(Semaphore semaphore, AtomicInteger numTicket) {
        this.semaphore = semaphore;
        this.numTicket = numTicket;
    }

    public void run() {
        while (!isInterrupted()) {
            try {
                semaphore.acquire();

                if (numTicket.get() <= 0) {
                    System.out.println("No more ticket for " + this.getName());
                    break;
                }

                int ticketSold = numTicket.decrementAndGet();
                System.out.println("Num: " + ticketSold + " for " + this.getName());

            } catch (InterruptedException e) {
                System.out.println(this.getName() + " was interrupted");
                break;
            } finally {
                semaphore.release();
            }
        }
    }
}
