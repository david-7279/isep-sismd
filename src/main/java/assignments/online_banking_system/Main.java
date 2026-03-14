package main.java.assignments.online_banking_system;

import main.java.assignments.online_banking_system.model.Account;
import main.java.assignments.online_banking_system.model.Bank;
import main.java.assignments.online_banking_system.service.TransferService;
import main.java.assignments.online_banking_system.thread.Transaction;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // Mapa que irá guardar todas as contas
        Map<Integer, Account> accounts = new HashMap<>();

        // Criar 10 contas com saldo inicial
        for (int i = 0; i < 10; i++) {
            accounts.put(i, new Account(i, BigDecimal.valueOf(1000)));
        }

        Bank bank = new Bank(accounts);

        TransferService transferService = new TransferService(bank);

        Random random = new Random();

        // Criar e iniciar várias threads de transações
        for (int i = 0; i < 5; i++) {

            Transaction transaction = new Transaction(bank, transferService, random);
            transaction.setName("Transaction-" + i);
            transaction.start();

        }
    }
}
