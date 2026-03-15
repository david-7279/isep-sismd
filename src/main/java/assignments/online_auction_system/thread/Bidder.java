package main.java.assignments.online_auction_system.thread;

import main.java.assignments.online_auction_system.model.AuctionItem;
import main.java.assignments.online_auction_system.model.Bid;
import main.java.assignments.online_auction_system.service.AuctionService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

public class Bidder extends Thread {

    private final int userId;
    private final AuctionItem auctionItem;
    private final AuctionService auctionService;
    private final Random random;

    public Bidder(int userId, AuctionItem auctionItem, AuctionService auctionService, Random random) {
        this.userId = userId;
        this.auctionItem = auctionItem;
        this.auctionService = auctionService;
        this.random = random;
    }

    private Bid generateBid() {

        // Gerar valor aleatório para a bid
        int value = random.nextInt(100) + 1;
        BigDecimal amount = BigDecimal.valueOf(value);

        // Criar objeto Bid
        return new Bid(userId, amount, LocalDateTime.now());
    }

    private void logBidResult(Bid bid, boolean accepted) {

        if (accepted) {
            System.out.println(getName() + " NEW HIGHEST BID: " + bid.getAmount() + " by user " + userId);
        } else {
            System.out.println(getName() + " bid rejected: " + bid.getAmount());
        }
    }

    @Override
    public void run() {

        while (!isInterrupted()) {
            try {

                Bid bid = generateBid();

                // Tentar colocar bid no leilão
                boolean accepted = auctionService.placeBid(auctionItem, bid);

                logBidResult(bid, accepted);
                
                // Esperar antes de nova tentativa
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted");
                interrupt(); // restaurar estado de interrupção
                break;
            }
        }
    }
}