package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class BANK {

    private String nameofBank;
    private ArrayList<Accountnormal> kontanormal;
    private ArrayList<AccountExtra> kontaekstra;
    private ArrayList<Transactions> transactions;

    public BANK( ArrayList<Accountnormal> kontanormal, ArrayList<AccountExtra> kontaekstra,
                ArrayList<Transactions> transactions) {
        this.nameofBank = "SUPERBANK";
        this.kontanormal = kontanormal;
        this.kontaekstra = kontaekstra;
        this.transactions = transactions;
    }


    public String getNameofBank() {
        return nameofBank;
    }

    public void setNameofBank(String nameofBank) {
        this.nameofBank = nameofBank;
    }

    public ArrayList<Accountnormal> getKontanormal() {
        return kontanormal;
    }

    public void setKontanormal(ArrayList<Accountnormal> kontanormal) {
        this.kontanormal = kontanormal;
    }

    public ArrayList<AccountExtra> getKontaekstra() {
        return kontaekstra;
    }

    public void setKontaekstra(ArrayList<AccountExtra> kontaekstra) {
        this.kontaekstra = kontaekstra;
    }

    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transactions> transactions) {
        this.transactions = transactions;
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

    public  Accountnormal findAccount(String name,String password){
        for( int i=0; i<this.kontanormal.size(); i++){
            Accountnormal checkedAccount= this.kontanormal.get(i);
            if((checkedAccount.getName().equals(name))&&(checkedAccount.getPassword().equals(password))){
                return checkedAccount;
            }
        }
        return null;

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




    public AccountExtra findAccountPlus(String name,String password){
        for( int i=0; i<this.kontaekstra.size(); i++){
            AccountExtra checkedAccount= this.kontaekstra.get(i);
            if((checkedAccount.getName().equals(name))&&(checkedAccount.getPassword().equals(password))){
                return checkedAccount;
            }
        }
        return null;

    }

    public boolean addAccount(String name, String password, boolean isItPremium){
        if(isItPremium){
            if(findAccountPLUS(name)==null){
                AccountExtra konto= new AccountExtra(name, password);
                System.out.println("Stworzyles konto!");
                kontaekstra.add(konto);
                return true;
            } else {
                System.out.println("Nie udalo sie stworzyc");
                System.out.println("To konto juz istnieje, sporobuj zalogowac sie");

                return false;
            }
        } else {
            if(findAccount(name)==null){
                Accountnormal kontop= new Accountnormal(name, password);
                System.out.println("Stworzyles konto kozaq");
                kontanormal.add(kontop);
                return true;
            } else {
                System.out.println("Nie udalo sie stworzyc");
                System.out.println("To konto juz istnieje, sporobuj zalogowac sie");
                return false;
            }
        }
    }


//    public void znalezionekontonromal(String name, String password){
//        if(findAccount(name, password)!=null){
//            findAccount(name, password).toString();
//        }else{
//            System.out.println("nie znaleziono");
//        }
//
//    }

    public void displaycustomers(){
        System.out.println("Konta normalne: ");
//        for(int i=0; i<kontanormal.size(); i++){
//            System.out.println(i +" "+ kontanormal.get(i).getName() + "password: " + kontanormal.get(i).getPassword());
//        }
        System.out.println(Arrays.toString(kontanormal.toArray()));

        System.out.println("Konta PLUS: ");
//        for(int i=0; i<kontaekstra.size(); i++){
//            System.out.println(i +" "+ kontaekstra.get(i).getName() + "password: " + kontaekstra.get(i).getPassword());
//        }
        System.out.println(Arrays.toString(kontaekstra.toArray()));

    }

    public void displaytransactions(){
        for(int i=0; i < transactions.size(); i++){
            System.out.println(i + transactions.get(i).toString());
        }
    }




}
