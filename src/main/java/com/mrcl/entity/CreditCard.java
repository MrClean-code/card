package com.mrcl.entity;

public class CreditCard extends BankCard {
    private double creditLimit;
    private double balance = BankCard.getBalance();
    private double needMoney;

    public CreditCard(double balance, double creditLimit) {
        super(balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void addMoney(double money) {
        System.out.println("Пополнение на " + money);
        if (money > 0) {
            if (creditLimit < creditLimit + needMoney && money < needMoney) {
                creditLimit += money;
                needMoney -= money;
            } else if (creditLimit < creditLimit + needMoney && money >= needMoney && needMoney > 0) {
                creditLimit += needMoney;
                needMoney = money - needMoney;
                balance += needMoney;
                needMoney -= money;
            } else {
                balance += money;
            }
        }
    }

    @Override
    public boolean pay(double money) {
        System.out.println("Оплата на " + money);
        if (balance >= money && money > 0) {
            balance -= money;
            return true;
        } else if (creditLimit + balance >= money) {
            needMoney = money - balance;
            balance = 0;
            creditLimit -= needMoney;
            return true;
        }
        return false;
    }

    @Override
    public String getInfoForAccessMoney() {
        return "баланс карты " + balance + " \t на кредитке " + creditLimit;
    }
}


