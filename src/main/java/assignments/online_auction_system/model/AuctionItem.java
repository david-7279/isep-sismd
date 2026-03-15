package main.java.assignments.online_auction_system.model;

import java.util.concurrent.locks.ReentrantLock;

public class AuctionItem {

    private final int id;
    private final String name;

    // Guarda diretamente o maior bid
    private Bid highestBid;

    // Lock da auction para controlar acesso concorrente ao bid
    // "true" ativa fairness e evita starvation: as threads recebem o lock por ordem de espera
    private final ReentrantLock lock = new ReentrantLock(true);

    public AuctionItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean placeBid(Bid bid) {
        lock.lock();
        try {

            // se ainda não existe bid
            if (highestBid == null) {
                highestBid = bid;
                return true;
            }

            // verifica se o novo bid é maior
            if (bid.getAmount().compareTo(highestBid.getAmount()) > 0) {
                highestBid = bid;
                return true;
            }

            return false;

        } finally {
            lock.unlock();
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Bid getHighestBid() {
        return highestBid;
    }
}
