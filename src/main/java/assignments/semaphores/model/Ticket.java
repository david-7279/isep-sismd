package main.java.assignments.semaphores.model;

public class Ticket {
    private final int initialTickets;

    public Ticket(int initialTickets) {
        this.initialTickets = initialTickets;
    }

    public int getInitialTickets() {
        return initialTickets;
    }
}
