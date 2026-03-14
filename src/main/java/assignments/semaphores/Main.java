package main.java.assignments.semaphores;

import main.java.assignments.semaphores.thread.Seller;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/*
    Create an application that simulates a concurrent ticket selling system.
    The number of tickets available is stored in a shared tickets object
    There may exist N different sellers attempting to sell tickets, each represented by a separate thread.
    Implement a solution where semaphores are used strictly for controlling access to the shared tickets object,
    rather than simulating the ticket availability itself.

    Requirements:
        - Ensure that concurrent access to the tickets object is safely managed
        - Each seller must check ticket availability before proceeding with a sale.
        - The solution must allow sellers to be interrupted safely.
        - Demonstrate how semaphores help in avoiding race conditions while allowing multiple sellers to operate efficiently.

 */
public class Main {
    public static void main(String[] args) {

        int initialTickets = 100;
        AtomicInteger tickets = new AtomicInteger(initialTickets);

        Semaphore semaphore = new Semaphore(1);

        Seller seller1 = new Seller(semaphore, tickets);
        Seller seller2 = new Seller(semaphore, tickets);
        Seller seller3 = new Seller(semaphore, tickets);

        seller1.start();
        seller2.start();
        seller3.start();
    }
}
