package com.mrcl.entity;

public abstract class BankCard {
    private static double balance;

    public BankCard(double balance) {
        this.balance = balance;
    }

    public abstract void addMoney(double money);

    public abstract boolean pay(double money);

    public abstract String getInfoForAccessMoney();

    public static double getBalance(){
        return balance;
    }
}
