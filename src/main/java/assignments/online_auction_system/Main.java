package main.java.assignments.online_auction_system;

import main.java.assignments.online_auction_system.model.AuctionItem;
import main.java.assignments.online_auction_system.service.AuctionService;
import main.java.assignments.online_auction_system.thread.Bidder;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // Item do leilão (partilhado por todas as threads)
        AuctionItem auctionItem = new AuctionItem(1, "Japanese Katana");

        // Serviço de leilão
        AuctionService auctionService = new AuctionService();

        // Gerador de números aleatórios
        Random random = new Random();

        // Número de utilizadores (threads)
        int numberOfBidders = 5;

        Bidder[] bidders = new Bidder[numberOfBidders];

        // Criar as threads
        for (int i = 0; i < numberOfBidders; i++) {

            bidders[i] = new Bidder(
                    i + 1, // userId
                    auctionItem,
                    auctionService,
                    random
            );

            bidders[i].setName("Bidder- " + (i + 1));
            bidders[i].start();
        }
    }
}
