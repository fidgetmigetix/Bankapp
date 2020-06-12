package com.company;

import java.util.ArrayList;

public abstract class Account {

    private double debt;
    private double money;
    private String nameofUser;
    private String password;
    private ArrayList<Transactions> transactions;


    public Account(String nameofUser, String password) {
        this.nameofUser = nameofUser;
        this.password = password;
        this.transactions= new ArrayList<Transactions>();

    }


    public String getNameofUser() {
        return nameofUser;
    }

    public String getPassword() {
        return password;
    }

    public double getDebt() {
        return debt;
    }

    public double getMoney() {
        return money;
    }
}
