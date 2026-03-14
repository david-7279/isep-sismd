package main.java.assignments.explicit_locks;

import main.java.assignments.explicit_locks.thread.Seller;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/*
    Modify the previous exercise to use explicit locks (Java's ReentrantLock) instead of semaphores.

    Requirements:
        - Replace the semaphore with a ReentrantLock to control access to the tickets object.
        - Use lock() and unlock() to protect critical sections.
        - Ensure that sellers can be interrupted safely without causing deadlocks.
        - Use a try-finally block to guarantee proper unlocking of resources.
 */


public class Main {
    public static void main(String[] args) {

        AtomicInteger tickets = new AtomicInteger(50);

        ReentrantLock lock = new ReentrantLock(true);

        Seller s1 = new Seller(lock, tickets);
        Seller s2 = new Seller(lock, tickets);
        Seller s3 = new Seller(lock, tickets);

        s1.start();
        s2.start();
        s3.start();
    }
}
