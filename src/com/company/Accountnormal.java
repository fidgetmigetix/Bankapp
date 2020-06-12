package com.company;

import java.util.ArrayList;

public class Accountnormal extends Account {

    private double debt;
    private double money;
    private ArrayList<Transactions> transactions;

    public Accountnormal(String nameofUser, String password) {
        super(nameofUser, password);
        this.debt = 0;
        this.money = 0;
        this.transactions = new ArrayList<Transactions>();

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



    public double getDebt() {
        return this.debt;
    }


    public double getMoney() {
        return this.money;
    }

    public String toString(){
        return "Twoje imie: " + this.getNameofUser() + "\n"+
                "Twoje haslo(uwazaj, zeby nie pokazywac XD"+this.getPassword()+"\n"+
                "Stan konta: " + this.money +"\n"+
                "Twoj debet: "+ this.debt+"\n";
    }
}
