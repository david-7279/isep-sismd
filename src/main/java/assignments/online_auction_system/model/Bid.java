package main.java.assignments.online_auction_system.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Bid {

    private final int userId;
    private final BigDecimal amount;
    private final LocalDateTime timestamp;

    public Bid(int userId, BigDecimal amount, LocalDateTime timestamp) {

        // Garantir que o amount da bid e correto
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Bid amount must be greater than zero");
        }

        this.userId = userId;
        this.amount = amount;
        this.timestamp = Objects.requireNonNull(timestamp, "Timestamp cannot be null");
    }

    public int getUserId() {
        return userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Bid{userId=" + userId +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}
