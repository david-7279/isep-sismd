package main.java.assignments.online_banking_system.model;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final int id;
    private BigDecimal balance;

    // Lock da conta para controlar acesso concorrente ao saldo
    // "true" ativa fairness: as threads recebem o lock por ordem de espera FIFO(First-In-First-Out)
    private final ReentrantLock lock = new ReentrantLock(true);

    public Account(int id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    // Adiciona dinheiro ao saldo da conta
    public void deposit(BigDecimal amount) {
        // lock.lock();

        // entra na secção crítica
        if (!lock.tryLock()) {
            return;
        }

        try {

            if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Amount must be greater than zero");
            }

            balance = balance.add(amount);

        } finally {
            lock.unlock(); // garante libertação do lock
        }
    }

    // Remove dinheiro do saldo da conta
    public void withdraw(BigDecimal amount) {
        // lock.lock();

        // entra na secção crítica
        if (!lock.tryLock()) {
            return;
        }

        try {

            if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Amount must be greater than zero");
            }

            balance = balance.subtract(amount);

        } finally {
            lock.unlock(); // garante libertação do lock
        }
    }

    public int getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    // Permite acesso ao lock da conta (usado em transferências)
    public ReentrantLock getLock() {
        return lock;
    }
}
