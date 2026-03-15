package main.java.assignments.online_auction_system.service;

import main.java.assignments.online_auction_system.model.AuctionItem;
import main.java.assignments.online_auction_system.model.Bid;

import java.math.BigDecimal;

public class AuctionService {

    public AuctionService() {
    }

    public boolean placeBid(AuctionItem auctionItem, Bid bid) {

        if (auctionItem == null) {
            throw new IllegalArgumentException("Auction item cannot be null");
        }

        if (bid == null) {
            throw new IllegalArgumentException("Bid cannot be null");
        }

        if (bid.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Bid must be greater than zero");
        }

        return auctionItem.placeBid(bid);
    }
}
