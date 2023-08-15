package com.mrcl.entity;

public class DebitCard extends BankCard {

    private double balance = BankCard.getBalance();

    public DebitCard(double balance) {
        super(balance);
    }


    @Override
    public void addMoney(double money) {
        System.out.println("Пополнение на " + money);
        if (money > 0) {
            balance += money;
        }
    }

    @Override
    public boolean pay(double money) {
        System.out.println("Оплата на " + money);
        if (balance >= money && money > 0) {
            balance -= money;
            return true;
        }
        return false;
    }

    @Override
    public String getInfoForAccessMoney() {
        return "баланс дебетовой " + balance;
    }


}
