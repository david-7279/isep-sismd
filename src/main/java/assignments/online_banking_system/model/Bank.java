package main.java.assignments.online_banking_system.model;

import java.math.BigDecimal;
import java.util.Map;

public class Bank {

    // Mapa que associa o ID da conta ao objeto Account
    private Map<Integer, Account> map;

    public Bank(Map<Integer, Account> map) {
        this.map = map;
    }

    // Devolve a conta correspondente ao ID fornecido
    public Account getAccount(int accountID) {
        return map.get(accountID);
    }

    // Calcula o saldo total de todas as contas do banco
    public BigDecimal getTotalBalance() {
        BigDecimal totalBalance = BigDecimal.ZERO;

        // Percorre todas as contas do banco
        for (Account acc : map.values()) {

            totalBalance = totalBalance.add(acc.getBalance());

        }

        return totalBalance;
    }

    public int getAccountSize() {
        return map.size();
    }
}
