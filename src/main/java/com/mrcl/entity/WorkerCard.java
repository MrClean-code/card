package com.mrcl.entity;

public class WorkerCard extends CreditCard{

    private double pointCard;
    private static final double POINT_TO_BIG_BUY = 0.05;
    private double cashBack;
    private static final double CASH_MONEY = 0.00005;
    private double needMoney;
    private double creditLimit;
    private double balance = BankCard.getBalance();


    public WorkerCard(double balance, double creditLimit) {
        super(balance, creditLimit);
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
            addCash(money);
        }

    }

    @Override
    public boolean pay(double money) {
        System.out.println("Оплата работника на " + money);
        if (balance >= money && money > 0) {
            balance -= money;
            addPoint(money);
            return true;
        } else if (creditLimit + balance >= money) {
            needMoney = money - balance;
            balance = 0;
            creditLimit -= needMoney;
            addPoint(money);
            return true;
        }
        return false;
    }

    private void addCash(double money) {
        cashBack += money * CASH_MONEY;
    }

    private void addPoint(double money) {
        if (money >= 3000) {
            pointCard += money * POINT_TO_BIG_BUY;
        }
    }

    @Override
    public String getInfoForAccessMoney() {
        return "баланс карты " + balance + " \t на кредитке " + creditLimit + " \n" +
                " бонусная карта " + pointCard + " кэшбэк " + cashBack;
    }

}
