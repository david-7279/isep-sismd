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

    @Override
    public void run() {

        while (!isInterrupted()) {
            try {

                int value = random.nextInt(100) + 1;
                BigDecimal amount = BigDecimal.valueOf(value);

                Bid bid = new Bid(userId, amount, LocalDateTime.now());

                boolean accepted = auctionService.placeBid(auctionItem, bid);

                if (accepted) {
                    System.out.println(getName() + " placed highest bid: " + amount);
                }

                System.out.println(this.getName() +
                                " NEW HIGHEST BID: " + amount +
                                " by user " + userId
                );

                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println(this.getName() + " was interrupted");
                break;
            }
        }
    }
}