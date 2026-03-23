package main.java.assignments.online_banking_system.service;

import main.java.assignments.online_banking_system.model.Account;
import main.java.assignments.online_banking_system.model.Bank;

import java.math.BigDecimal;

public class TransferService {

    public TransferService(Bank bank) {
    }

    // Realiza uma transferência entre duas contas
    public void transfer(Account from, Account to, BigDecimal amount) {

        Account first;
        Account second;

        // Define a ordem dos locks com base no ID da conta
        // Isto evita deadlocks entre threads
        if (from.getId() < to.getId()) {
            first = from;
            second = to;
        } else {
            first = to;
            second = from;
        }

        // Bloqueia as duas contas envolvidas na transferência
        first.getLock().lock();
        second.getLock().lock();

        try {

            // Executa a transferência
            from.withdraw(amount);
            to.deposit(amount);

            System.out.println(Thread.currentThread().getName() +
                    " transfer " + amount +
                    "$ from Account: " + from.getId() +
                    " to Account: " + to.getId()
            );

        } finally {
            // Liberta os locks (ordem inversa da aquisição)
            second.getLock().unlock();
            first.getLock().unlock();
        }
    }
}
