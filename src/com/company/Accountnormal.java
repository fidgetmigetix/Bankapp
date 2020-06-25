package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Accountnormal {

    private Scanner scanner= new Scanner(System.in);
    private String name;
    private String password;

    private double money;
    private ArrayList<Transactions> transactions;
    private Transactions transaction;


    public Accountnormal(String nameofUser, String password) {
        this.name= nameofUser;
        this.password=password;
        this.money = 0;
        this.transactions = new ArrayList<Transactions>();


        System.out.println("Twoj stan konta to: " + this.money +"\n");
    }

    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transactions> transactions) {
        this.transactions = transactions;
    }

    public Transactions getTransaction() {
        return transaction;
    }

    public void setTransaction(Transactions transaction) {
        this.transaction = transaction;
    }



    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public boolean deposit(double amount){
//        this.money+=amount;
//        System.out.println("U have just deposited amount " + amount + ". And ur account balance is "
//        + this.money);
//
//        return true;
//    }


//    public boolean withdraw(double amount){
//        Transactions trans = transaction.withdrawn(name, password, amount);
//        if(trans.withdrawn(name, password, amount)!=null){
//            transactions.add(trans);
//            return true;
//        }else {
//            return false;
//        }


//        double amount = scanner.nextInt();
//        if(this.money>=amount){
//            this.money-=amount;
//            System.out.println("U withdrawed " + amount + " and ur balance is " + this.money);
//            Transactions transaction = new Transactions(this.name, amount, "withdrawfrom" + this.getName(),
//                    data);
//            transactions.add(transaction);
//            return true;
//        }else {
//            System.out.println("U cant withdraw that much money cause u dont have such a " +
//                    "amount in ur bank account");
//            return false;
//        }
//    }

    public void displaytransactions(){
        for(int i=0; i < transactions.size(); i++){
            System.out.println(i + transactions.get(i).toString());
        }
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
        return "Accountnormal{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }
}
