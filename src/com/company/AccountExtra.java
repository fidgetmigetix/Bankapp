package com.company;

import java.util.ArrayList;

public class AccountExtra extends Accountnormal{


    private double money;
    private ArrayList<Transactions> transactions;

    public AccountExtra(String nameofUser, String password) {
        super(nameofUser, password);
        this.money = 50;
        this.transactions = new ArrayList<>();
        System.out.println("U just received 50 cebulionow" +
                " w ramach otworzenia konta w SUPERBANK z.o.o \n");
        System.out.println("Twoj stan konta to: " + this.money +"\n");
    }

    @Override
    public ArrayList<Transactions> getTransactions() {
        return super.getTransactions();
    }

    @Override
    public void setTransactions(ArrayList<Transactions> transactions) {
        super.setTransactions(transactions);
    }

    @Override
    public Transactions getTransaction() {
        return super.getTransaction();
    }

    @Override
    public void setTransaction(Transactions transaction) {
        super.setTransaction(transaction);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void displaytransactions() {
        super.displaytransactions();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }





    public void setMoney(double money) {
        this.money = money;
    }




    public double getMoney() {
        return this.money;
    }

    public void tostring(){
        System.out.println("Twoje imie: " + this.getName() + "\n"+
                "Twoje haslo(uwazaj, zeby nie pokazywac XD: "+this.getPassword()+"\n"+
                "Stan konta: " + this.money +"\n");

    }

    @Override
    public String toString() {
        return "AccountExtra{" +"name: "+  getName()+ ","+ "password: " + getPassword() + "," +
                "money=" + money;
    }
}
