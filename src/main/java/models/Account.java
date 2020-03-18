package models;

import java.text.DecimalFormat;

public class Account {
    int number;
    double balance;
    double intrestRate;

    public Account(int number, double balance, double intrestRate) {
        this.number = number;
        this.balance = balance;
        this.intrestRate = intrestRate;
    }

    public Account(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getIntrestRate() {
        return intrestRate;
    }

    public void setIntrestRate(double intrestRate) {
        this.intrestRate = intrestRate;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("###.##");
        return String.format("AccountNumber : %s \nBalance : %s \nIntrestRate : %s",
                this.number, this.balance, df.format(this.intrestRate));
    }
}
