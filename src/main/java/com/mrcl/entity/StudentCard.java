package com.mrcl.entity;

public class StudentCard extends DebitCard {

    private static final double POINT_ALL_BUY = 0.01;
    private double pointCard;
    private double balance = BankCard.getBalance();

    public StudentCard(double balance) {
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
        System.out.println("Оплата студ карты на " + money);
        if (balance >= money && money > 0) {
            balance -= money;
            addPoint(money);
            return true;
        }
        return false;
    }

    private void addPoint(double money) {
        pointCard += money * POINT_ALL_BUY;
    }

    @Override
    public String getInfoForAccessMoney() {
        return "на балансе " + balance + " бонусная карта " + pointCard;
    }
}
