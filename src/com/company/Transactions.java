package com.company;

import java.util.ArrayList;

public class Transactions {

    private double amount;
    private String name;
    private String dateOfTransaction;
    private ArrayList<Transactions> transactions;
    private ArrayList<Accountnormal> kontanormal;
    private ArrayList<AccountExtra> kontaekstra;

    public Transactions(double amount, String nameOfTransaction, String dateOfTransaction) {
        this.amount = amount;
        this.name = nameOfTransaction;
        this.dateOfTransaction = dateOfTransaction;
    }



    public Transactions addTranscation(String name, double amount, String dateOfTransaction){
        Transactions transaction= new Transactions(amount, dateOfTransaction, name);
        return transaction;
    }


    public double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getDateOfTransaction() {
        return dateOfTransaction;
    }


}
