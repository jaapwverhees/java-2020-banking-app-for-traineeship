package controller;

import models.Account;

import java.util.ArrayList;

public class AccountController {
    private ArrayList<Account> accounts;


    public AccountController(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public double getBalanceAccount(int number) throws Exception {
        Account account = checkValidNumber(number);
        if (account != null) {
            return account.getBalance();
        }
        throw new Exception("invalid number, account does not exists");
    }

    public Account checkValidNumber(int number) {
        for (Account account : accounts) {
            if (account.getNumber() == number) return account;
        }
        return null;
    }

    public double updateBalance(int accountNumber, double update) throws Exception {
        Account account = checkValidNumber(accountNumber);
        if (account == null) throw new Exception("invalid number, account does not exists");
        else {
            if (account.getBalance() + update < 0.0f) {
                throw new Exception("Cant Allow Negative result");
            } else {
                account.setBalance(account.getBalance() + update);
            }
            return account.getBalance();
        }
    }

    public double calculateIntrestOneYear(int accountNumber) throws Exception {
        Account account = checkValidNumber(accountNumber);
        if (account == null) throw new Exception("invalid number, account does not exists");
        else {
            return ((account.getBalance() / 100) * account.getIntrestRate());
        }
    }

    public void TranferFunds(int accountTranferFrom, int accountToRecieve, double amount) throws Exception {
        Account withdrawAccount = checkValidNumber(accountTranferFrom);
        if (withdrawAccount == null) throw new Exception("invalid number, withdraw account does not exists");
        Account recieveAccount = checkValidNumber(accountToRecieve);
        if (recieveAccount == null) throw new Exception("invalid number, receiving account does not exists");

        if (withdrawAccount.getBalance() - amount < 0) throw new Exception("insufficent funds");

        withdrawAccount.setBalance(withdrawAccount.getBalance() - amount);
        recieveAccount.setBalance(recieveAccount.getBalance() + amount);
        accounts.add(accountTranferFrom, withdrawAccount);
        accounts.add(accountToRecieve, recieveAccount);
    }
}
