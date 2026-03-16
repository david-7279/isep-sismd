package main.java.assignments.online_banking_system.thread;

import main.java.assignments.online_banking_system.model.Account;
import main.java.assignments.online_banking_system.model.Bank;
import main.java.assignments.online_banking_system.service.TransferService;

import java.math.BigDecimal;
import java.util.Random;

public class Transaction extends Thread {

    private Bank bank;
    private TransferService transferService;
    private Random random;

    public Transaction(Bank bank, TransferService transferService, Random random) {
        this.bank = bank;
        this.transferService = transferService;
        this.random = random;
    }

    private BigDecimal generateRandomAmount() {
        double value = random.nextInt(100) + 1;
        BigDecimal amount = BigDecimal.valueOf(value);

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        return amount;
    }

    @Override
    public void run() {

        // A thread executa continuamente até ser interrompida
        while (!isInterrupted()) {
            try {

                // Escolhe duas contas aleatórias do banco
                int fromId = random.nextInt(bank.getAccountSize());
                int toId = random.nextInt(bank.getAccountSize());

                Account from = bank.getAccount(fromId);
                Account to = bank.getAccount(toId);

                // Evita transferências para a mesma conta ou contas inválidas
                if (from == to || from == null || to == null) continue;

                // Gera um valor aleatório entre 1 e 100
                BigDecimal amount = generateRandomAmount();

                // Executa a transferência entre contas
                transferService.transfer(from, to, amount);

                // Pausa a thread para evitar uso excessivo de CPU
                Thread.sleep(1000);

            } catch (InterruptedException e) {

                // Caso a thread seja interrompida, termina a execução
                System.out.println(getName() + " was interrupted");
                break;
            }
        }
    }
}
