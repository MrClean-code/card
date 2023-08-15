package com.mrcl;

import com.mrcl.entity.*;

public class Main {
    public static void main(String[] args) {
        BankCard creditCard = new CreditCard(10000, 10000);
        System.out.println(creditCard.getInfoForAccessMoney());

        creditCard.pay(5000); // 5000 10000
        creditCard.pay(5000); // 0 10000
        creditCard.pay(5000); // 0 5000
        creditCard.addMoney(6000); // 1000 10000
        creditCard.addMoney(4000); // 5000 10000
        creditCard.pay(2000); // 3000 10000


        System.out.println(creditCard.getInfoForAccessMoney());




    }
}
