package com.company;

import java.util.ArrayList;

public class AccountExtra extends Account{

    private double debt;
    private double money;
    private ArrayList<Transactions> transactions;

    public AccountExtra(String nameofUser, String password) {
        super(nameofUser, password);
        this.debt = 0;
        this.money = 50;
        this.transactions = new ArrayList<Transactions>();
        System.out.println("U just received 50 cebulionow" +
                " w ramach otworzenia konta w Smieszny Bank z.o.o \n");
        System.out.println("Twoj stan konta to: " + this.money +"\n" +
                "Oraz Twoj debet to: 0");
    }

    @Override
    public String getNameofUser() {
        return super.getNameofUser();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    public void debil(){
        System.out.println("DEBIL");
    }



    public double getDebt() {
        return this.debt;
    }


    public double getMoney() {
        return this.money;
    }
}
