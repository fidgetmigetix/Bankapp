package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Transactions  {

    private Scanner scanner = new Scanner(System.in);
    private double amount;
    private String name;
    private String dateOfTransaction;
    private ArrayList<Transactions> transactions;
    private ArrayList<Accountnormal> kontanormal;
    private ArrayList<AccountExtra> kontaekstra;


    public Transactions(ArrayList<Transactions> transactions, ArrayList<Accountnormal> kontanormal,
                        ArrayList<AccountExtra> kontaekstra) {
        this.transactions = transactions;
        this.kontanormal = kontanormal;
        this.kontaekstra = kontaekstra;
    }

    public Transactions(String nameofUser, double amount, String nameOfTransaction, String data) {
        this.amount = amount;
        this.name = nameOfTransaction;
        this.dateOfTransaction = dateOfTransaction;
        this.dateOfTransaction=data;


    }


    public boolean withdrawe(String name, String password, double amount, String data) {
        AccountExtra konto = findAccountPlus(name, password);
        if(findAccountPlus(name, password)==konto) {
            if(konto.getMoney()>=amount){
                Transactions transaction = new Transactions(name, amount, "withdraw", data);
                double cash = konto.getMoney();
                konto.setMoney(cash - amount);
                konto.getTransactions().add(transaction);
                System.out.println("U have withdrawn: " + amount);
                System.out.println("U have now: " + konto.getMoney());
                return true;
            } else{
                System.out.println("u dont have enough cash");
                System.out.println("U have only: " + konto.getMoney());
                return false;
            }
        } else{

            System.out.println("U cant withdraw money we didnt find this account");
            return false;
        }

    }


    public boolean deposite(String name, String password, double amount,String data) {
        if(findAccountPlus(name,password)!=null){
            AccountExtra konto = findAccountPlus(name,password);
            Transactions transaction = new Transactions(name, amount, "deposit", data);
            double cash =konto.getMoney();
            konto.setMoney(cash+amount);
            konto.getTransactions().add(transaction);
            System.out.println("U have deposited: " + amount);
            return true;
        }else {
            System.out.println("We didnt find this account");
            return false;
        }
    }

    public boolean deposit(String name, String password, double amount, String data) {
        if(findAccount(name,password)!=null){
            Accountnormal konto = findAccount(name,password);
            Transactions transaction = new Transactions(name, amount, "deposit", data);
            double cash =konto.getMoney();
            konto.setMoney(cash+amount);
            konto.getTransactions().add(transaction);
            System.out.println("U have deposited: " + amount);
            return true;
        }else {
            System.out.println("We didnt find this account");
            return false;
        }
    }

    public boolean transferNtoE(Accountnormal konto, String nameAccount, double amount, String data) {
        if(findAccountPLUS(nameAccount)!=null){
            AccountExtra konto1= findAccountPLUS(nameAccount);
            double cash1= konto1.getMoney();
            double cash = konto.getMoney();
            if(cash>=amount){
                konto.setMoney(cash-amount);
                konto1.setMoney(cash1+amount);
                Transactions transac= new Transactions(nameAccount, amount,
                        "transfer from" + konto.getName() + " to " + konto1.getName(), data);
                konto.getTransactions().add(transac);
                konto1.getTransactions().add(transac);
                return true;
            }else {
                System.out.println("U dont have enough money");
                return false;
            }
        }else {
            System.out.println("There is no such an account");
            return false;
        }


    }

    public boolean transferEtoN(AccountExtra konto, String nameAccount, double amount, String data) {
        if(findAccount(nameAccount)!=null){
            Accountnormal konto1= findAccount(nameAccount);
            double cash1= konto1.getMoney();
            double cash = konto.getMoney();
            if(cash>=amount){
                konto.setMoney(cash-amount);
                konto1.setMoney(cash1+amount);
                Transactions transac= new Transactions(nameAccount, amount,
                        "transfer from" + konto.getName() + " to " + konto1.getName(), data);
                konto.getTransactions().add(transac);
                konto1.getTransactions().add(transac);
                return true;
            }else {
                System.out.println("U dont have enough money");
                return false;
            }
        }else {
            System.out.println("There is no such an account");
            return false;
        }


    }

    private AccountExtra findAccountPLUS(String name){
        for( int i=0; i<this.kontaekstra.size(); i++){
            AccountExtra checkedAccount= this.kontaekstra.get(i);
            if(checkedAccount.getName().equals(name)){
                return checkedAccount;
            }
        }
        return null;
    }

    private Accountnormal findAccount(String name){
        for( int i=0; i<this.kontanormal.size(); i++){
            Accountnormal checkedAccount= this.kontanormal.get(i);
            if(checkedAccount.getName().equals(name)){
                return checkedAccount;
            }
        }
        return null;

    }

    public boolean transferEtoE(AccountExtra konto, String nameAccount, double amount, String data) {
        if(findAccountPLUS(nameAccount)!=null){
            AccountExtra konto1= findAccountPLUS(nameAccount);
            double cash1= konto1.getMoney();
            double cash = konto.getMoney();
            if(cash>=amount){
                konto.setMoney(cash-amount);
                konto1.setMoney(cash1+amount);
                Transactions transac= new Transactions(nameAccount, amount,
                        "transfer from" + konto.getName() + " to " + konto1.getName(), data);
                konto.getTransactions().add(transac);
                konto1.getTransactions().add(transac);
                return true;
            }else {
                System.out.println("U dont have enough money");
                return false;
            }
        }else {
            System.out.println("There is no such an account");
            return false;
        }


    }

    public boolean transferNtoN(Accountnormal konto, String nameAccount, double amount, String data) {
        if(findAccount(nameAccount)!=null){
            Accountnormal konto1= findAccount(nameAccount);
            double cash1= konto1.getMoney();
            double cash = konto.getMoney();
            if(cash>=amount){
                konto.setMoney(cash-amount);
                konto1.setMoney(cash1+amount);
                Transactions transac= new Transactions(nameAccount, amount,
                        "transfer from" + konto.getName() + " to " + konto1.getName(), data);
                konto.getTransactions().add(transac);
                konto1.getTransactions().add(transac);
                return true;
            }else {
                System.out.println("U dont have enough money");
                return false;
            }
        }else {
            System.out.println("There is no such an account");
            return false;
        }


    }


    public Transactions withdrawn(String name, String password, double amount, String data) {
        Accountnormal konto = findAccount(name, password);
        if(konto.getMoney()>=amount) {
            Transactions transaction = new Transactions(name, amount, "withdraw", data);
            double cash = konto.getMoney();
            konto.setMoney(cash - amount);
            konto.getTransactions().add(transaction);
            System.out.println("U have now: " + konto.getMoney());
            return transaction;
        } else{
            System.out.println("U cant withdraw money, cause u dont have any");
            return null;
        }
    }



    private AccountExtra findAccountPlus(String name, String password){
        for( int i=0; i<this.kontaekstra.size(); i++){
            AccountExtra checkedAccount= this.kontaekstra.get(i);
            if((checkedAccount.getName().equals(name))&&(checkedAccount.getPassword().equals(password))){
                return checkedAccount;
            }
        }
        return null;

    }

    private Accountnormal findAccount(String name,String password){
        for( int i=0; i<this.kontanormal.size(); i++){
            Accountnormal checkedAccount= this.kontanormal.get(i);
            if((checkedAccount.getName().equals(name))&&(checkedAccount.getPassword().equals(password))){
                return checkedAccount;
            }
        }
        return null;

    }

    @Override
    public String toString() {
        return "Transactions{" +
                "amount=" + amount +
                ", name='" + name + '\'' +
                ", dateOfTransaction='" + dateOfTransaction + '\'' +
                '}';
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
