package com.company;

import java.util.ArrayList;

public class Administrator {

    private ArrayList<Transactions> transactions;
    private ArrayList<AccountExtra> accountExtras;
    private ArrayList<Accountnormal> accountnormals;

    private final String name="Administrator";
    private final String password="bardzodobrze";

    public Administrator(ArrayList<Transactions> transactions,
                         ArrayList<AccountExtra> accountExtras, ArrayList<Accountnormal> accountnormals) {
        this.transactions = transactions;
        this.accountExtras = accountExtras;
        this.accountnormals = accountnormals;


    }

    public Administrator( ) {
        this.transactions = new ArrayList<Transactions>();
        this.accountExtras = new ArrayList<AccountExtra>();
        this.accountnormals = new ArrayList<Accountnormal>();

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    private AccountExtra findAccountPLUS(String name){
        for( int i=0; i<this.accountExtras.size(); i++){
            AccountExtra checkedAccount= this.accountExtras.get(i);
            if(checkedAccount.getName().equals(name)){
                return checkedAccount;
            }
        }
        return null;
    }

    private Accountnormal findAccount(String name){
        for( int i=0; i<this.accountnormals.size(); i++){
            Accountnormal checkedAccount= this.accountnormals.get(i);
            if(checkedAccount.getName().equals(name)){
                return checkedAccount;
            }
        }
        return null;

    }

    public AccountExtra findAccountPlus(String name,String password){
        for( int i=0; i<this.accountExtras.size(); i++){
            AccountExtra checkedAccount= this.accountExtras.get(i);
            if((checkedAccount.getName().equals(name))&&(checkedAccount.getPassword().equals(password))){
                return checkedAccount;
            }
        }
        return null;

    }

    public Accountnormal findAccount(String name,String password){
        for( int i=0; i<this.accountnormals.size(); i++){
            Accountnormal checkedAccount= this.accountnormals.get(i);
            if((checkedAccount.getName().equals(name))&&(checkedAccount.getPassword().equals(password))){
                return checkedAccount;
            }
        }
        return null;

    }

    public boolean addAccount(String name, String password, boolean isItPremium){
        if(isItPremium){
//            if(findAccountPLUS(name)==null){
//                System.out.println("Nie udalo sie stworzyc");
//                System.out.println("To konto juz istnieje, sporobuj zalogowac sie");
//                return false;
//            } else {
//                System.out.println("Nie udalo sie stworzyc");
//                System.out.println("To konto juz istnieje, sporobuj zalogowac sie");
//                AccountExtra konto= new AccountExtra(name, password);
//                System.out.println("Stworzyles konto!");
//                accountExtras.add(konto);
//                return true;
            AccountExtra kontoP = findAccountPlus(name, password);
            accountExtras.add(kontoP);
            return true;
            } else {
            Accountnormal konto = findAccount(name, password);
            accountnormals.add(konto);
            return false;

//            if(findAccount(name)==null){
//                System.out.println("Nie udalo sie stworzyc");
//                System.out.println("To konto juz istnieje, sporobuj zalogowac sie");
//                return false;
//            } else {
//                Accountnormal kontop= new Accountnormal(name, password);
//                System.out.println("Stworzyles konto kozaq");
//                accountnormals.add(kontop);
//                return true;
//            }
        }
    }

    public void addTransaction (String name1, double amount, String nameofTransaction, String date){
        transactions.add(new Transactions(name1, amount, nameofTransaction, date));

    }
}
