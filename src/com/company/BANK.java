package com.company;

import java.util.ArrayList;

public class BANK {

    private String nameofBank;
    private ArrayList<Accountnormal> kontanormal;
    private ArrayList<AccountExtra> kontaekstra;

    public BANK() {
        this.nameofBank = "SUPERBANK";
        this.kontanormal = new ArrayList<Accountnormal>();
        this.kontaekstra = new ArrayList<AccountExtra>();
    }

    private Accountnormal findAccount(String name){
        for( int i=0; i<this.kontanormal.size(); i++){
            Accountnormal checkedAccount= this.kontanormal.get(i);
            if(checkedAccount.getNameofUser().equals(name)){
                return checkedAccount;
            }
        }
        return null;

    }

    private Accountnormal findAccount(String name,String password){
        for( int i=0; i<this.kontanormal.size(); i++){
            Accountnormal checkedAccount= this.kontanormal.get(i);
            if((checkedAccount.getNameofUser().equals(name))&&(checkedAccount.getPassword().equals(password))){
                return checkedAccount;
            }
        }
        return null;

    }

    private AccountExtra findAccountPLUS(String name){
        for( int i=0; i<this.kontaekstra.size(); i++){
            AccountExtra checkedAccount= this.kontaekstra.get(i);
            if(checkedAccount.getNameofUser().equals(name)){
                return checkedAccount;
            }
        }
        return null;
    }


    private AccountExtra findAccountPlus(String name,String password){
        for( int i=0; i<this.kontanormal.size(); i++){
            AccountExtra checkedAccount= this.kontaekstra.get(i);
            if((checkedAccount.getNameofUser().equals(name))&&(checkedAccount.getPassword().equals(password))){
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


    public String znalezionekontonromal(String name, String password){
        Accountnormal kontonor= findAccount(name,password);
        return kontonor.toString();
    }




}
