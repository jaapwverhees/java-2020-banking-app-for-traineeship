package controller;

import models.Account;

import java.util.ArrayList;

public class AccountController {
    ArrayList<Account> accounts;


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
        else{
            return (account.getBalance() * account.getIntrestRate()) - account.getBalance();
        }
    }
}
