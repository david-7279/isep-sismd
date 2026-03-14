package main.java.assignments.explicit_locks.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Seller extends Thread {

    // Um ReentrantLock serve para proteger uma secção crítica. Só uma thread de cada vez pode entrar.
    // Protege código. Serve para evitar race conditions numa secção crítica.
    private ReentrantLock lock;
    private AtomicInteger ticket;

    public Seller(ReentrantLock lock, AtomicInteger ticket) {
        this.lock = lock;
        this.ticket = ticket;
    }

    public void run() {
        while (!isInterrupted()) {

            boolean acquired = false;

            try {
                // Permite que a thread seja interrompida enquanto espera pelo lock.
                lock.lockInterruptibly();
                acquired = true;

                if (ticket.get() <= 0) {
                    System.out.println("No more tickets for " + this.getName());
                    break;
                }

                int remaining = ticket.decrementAndGet();

                System.out.println(this.getName() + " sold a ticket. Remaining: " + remaining);

            } catch (InterruptedException e) {
                System.out.println(this.getName() + " was interrupted");
                throw new RuntimeException(e);
            } finally {
                if (acquired) {
                    lock.unlock();
                }
            }
        }
    }
}
