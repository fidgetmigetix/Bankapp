package com.company;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Co do samego programu to nie sprawdza on zawsze wejscia liczby, poniewaz zaimplementowalem ja tylko w niektorych przypadkach.
// Moglem zeobic lepsza robote w transactions uzywajac generics, zeby nie powielac bezsensownie kodu.
// Jesli chcielibysmy polaczyc to z baza danych, to nalezaloby utowrzyc connection z baza danych(w moim przypadku lokalna)
// po czym za kazdym razem, kiedy tworzymy obiekt konta(plus czy normal) to tworzymy table Transactions
// i dodajemy po kazdej transakcji dodatkowo do table Transakcje.

// prosilbym rowniez o podazanie za instrukcja inputa, poniewaz nie zawsze jest on sprawdzany i moze wyrzucic
// exception

// Po jakims czasie zorientowalem sie rowniez, ze moglem inna kolekcje wybrac na konta niz ArrayList,
// np. HashSet i to nie pozwalaloby na duplikaty kont

// Moglem tez uzyc nowej zmiennej id w klasie account, aby dokladnie okreslac do jakiego konta chce wyslac pieniadze


public class Main {
    public static Scanner scanner = new Scanner(System.in);




    public static void main(String[] args) {

        ArrayList<Accountnormal> kontan = new ArrayList<>();
        ArrayList<AccountExtra> kontae = new ArrayList<>();
        ArrayList<Transactions> transactions = new ArrayList<>();

        BANK SUPERBANK = new BANK(kontan, kontae, transactions);

        Administrator administrator = new Administrator(transactions, kontae, kontan);

        Transactions transactionsALL = new Transactions(transactions, kontan, kontae);


        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$ \n" +
                           "    WELCOME TO THE BANK      \n" +
                           "$$$$$$$$$$$$$$$$$$$$$$$$$$$$ \n");

        boolean isUp = true;

        while(isUp){

            System.out.println("Choose option : ");
            menu();

            int wybor = scanner.nextInt();

            switch(wybor){

                case 0:
                    System.exit(0);
                case 1://menu
                    menu();
                    break;
                case 2://log in
                    scanner.nextLine();

                    System.out.println("Welcome again, please enter your name and password in order to " +
                            "log into account");

                    System.out.println("Is it a premium account? Choose true or false: ");
                    boolean ans=true;
                    boolean prawda= false;



                    while(true) {

                        Scanner keyboard = new Scanner(System.in);
                        System.out.println("Type: ");

                        if(keyboard.hasNextBoolean()){
                            ans = keyboard.nextBoolean();

                            break;
                        }

                    }

//                    while (!prawda)
//                    {
//                        try
//                        {
//
//                            ans=scanner.nextBoolean();
//                            prawda = true;
//
//                        }
//                        catch(InputMismatchException e){
//                            repeats++;
//                            System.out.println("Wrong input, try writing true or false only");
//                            ans=scanner.nextBoolean();
//                            if(repeats>5) {
//                                System.out.println("Didnt go well, try another time :)");
//                                System.exit(0);
//                            }
//                        }
//                    }






                    System.out.print("Name: ");
                    String Name=scanner.nextLine();
                    boolean ss= check(Name);
                    while(!ss){
                        System.out.print("Name: ");
                        Name=scanner.nextLine();
                        ss=check(Name);
                    }

                    System.out.print("Password: ");
                    String Password=scanner.nextLine();

                    if(ans){
                         AccountExtra konto = SUPERBANK.findAccountPlus(Name, Password);


                        boolean logi= true;

                        while(logi){
                            System.out.println("Welcome to your account " + konto.getName());
                            menulog();
                            int x= scanner.nextInt();
                            switch(x){
                                case 1://print menu
                                {
                                    menulog();
                                    break;
                                }
                                case 2://log out
                                {
                                    logi=false;
                                    break;
                                }
                                case 3://withdraw
                                {

                                    System.out.println("How much woould u like to withdraw");
                                    double amoun = scanner.nextInt();
                                    System.out.println("And write the present date");
                                    scanner.nextLine();
                                    String data = scanner.nextLine();

                                    transactionsALL.withdrawe(konto.getName(), konto.getPassword(), amoun, data);
                                    administrator.addTransaction(konto.getName(), amoun, "withdraw", data);

                                    break;
                                }
                                case 4://deposit
                                {
                                    System.out.println("What amount would u like to deposit");

                                    double amountd = 0;
                                    while (true) {//sprawwdza czy to double
                                        System.out.println("Type a amount:");
                                        try {
                                            amountd = Double.parseDouble(scanner.next());
                                            break; // will only get to here if input was a double
                                        } catch (NumberFormatException ignore) {
                                            System.out.println("Invalid input");
                                        }
                                    }
                                    System.out.println("And write the present date");
                                    scanner.nextLine();
                                    String data = scanner.nextLine();

                                    transactionsALL.deposite(konto.getName(), konto.getPassword(), amountd, data);
                                    administrator.addTransaction(konto.getName(), amountd, "deposit", data);

                                    break;
                                }
                                case 5://display transactions
                                {
                                    konto.displaytransactions();

                                    break;
                                }

                                case 6: // send money to account within PLus
                                {

                                    System.out.println("To who would like to send this");
                                    scanner.nextLine();

                                    String name = scanner.nextLine();

                                    System.out.println("What amount would u like to send");

                                    double amount = 0;
                                    while (true) {//sprawwdza czy to double
                                        System.out.println("Type a amount:");
                                        try {
                                            amount = Double.parseDouble(scanner.next());
                                            break; // will only get to here if input was a double
                                        } catch (NumberFormatException ignore) {
                                            System.out.println("Invalid input");
                                        }
                                    }
                                    System.out.println("And write the present date");
                                    scanner.nextLine();
                                    String data = scanner.nextLine();

                                    transactionsALL.transferEtoE(konto, name, amount, data);
                                    administrator.addTransaction(konto.getName(), amount, "transfer", data);
                                    break;
                                }
                                case 7: // send money to normal account
                                {

                                    System.out.println("To who would like to send this");
                                    scanner.nextLine();
                                    String name = scanner.nextLine();

                                    System.out.println("What amount would u like to send");

                                    double amount = 0;
                                    while (true) {//sprawwdza czy to double
                                        System.out.println("Type a amount:");
                                        try {
                                            amount = Double.parseDouble(scanner.next());
                                            break; // will only get to here if input was a double
                                        } catch (NumberFormatException ignore) {
                                            System.out.println("Invalid input");
                                        }
                                    }
                                    System.out.println("And write the present date");
                                    scanner.nextLine();
                                    String data = scanner.nextLine();

                                    transactionsALL.transferEtoN(konto,name, amount, data);
                                    administrator.addTransaction(konto.getName(), amount, "transfer", data);

                                    break;
                                }
                                case 8://show account
                                {
                                    konto.tostring();

                                    break;
                                }
                                case 0://exit
                                {
                                    System.exit(0);
                                    break;
                                }
                            }

                        }
                    }else {
                        if(SUPERBANK.findAccount(Name,Password)!=null) {
                            Accountnormal konton = SUPERBANK.findAccount(Name, Password);

                            boolean login = true;

                            while (login) {
                                System.out.println("Welcome to your account " + konton.getName());
                                menulog();
                                int x = scanner.nextInt();
                                switch (x) {
                                    case 1://menu
                                    {
                                        menulog();
                                        break;
                                    }
                                    case 2://log out
                                    {
                                        login = false;
                                        break;
                                    }
                                    case 3://withdraw
                                    {
                                        System.out.println("How much woould u like to withdraw");
                                        double amount = scanner.nextInt();
                                        System.out.println("And write the present date");
                                        scanner.nextLine();
                                        String data = scanner.nextLine();

                                        transactionsALL.withdrawn(konton.getName(), konton.getPassword(), amount, data);
                                        administrator.addTransaction(konton.getName(), amount, "withdraw", data);

                                        break;
                                    }
                                    case 4://deposit
                                    {
                                        System.out.println("What amount would u like to deposit");

                                        double amountd = 0;
                                        while (true) {//sprawwdza czy to double
                                            System.out.println("Type a amount:");
                                            try {
                                                amountd = Double.parseDouble(scanner.next());
                                                break; // will only get to here if input was a double
                                            } catch (NumberFormatException ignore) {
                                                System.out.println("Invalid input");
                                            }
                                        }
                                        System.out.println("And write the present date");
                                        scanner.nextLine();
                                        String data = scanner.nextLine();

                                        transactionsALL.deposit(konton.getName(), konton.getPassword(), amountd, data);
                                        administrator.addTransaction(konton.getName(), amountd, "deposit", data);

                                        break;
                                    }
                                    case 5://display transactions
                                    {
                                        konton.displaytransactions();

                                        break;
                                    }
                                    case 6: // send money to account within PLus
                                    {

                                        System.out.println("To who would like to send this");
                                        scanner.nextLine();
                                        String name = scanner.nextLine();

                                        System.out.println("What amount would u like to send");

                                        double amount = 0;
                                        while (true) {//sprawwdza czy to double
                                            System.out.println("Type a amount:");
                                            try {
                                                amount = Double.parseDouble(scanner.next());
                                                break; // will only get to here if input was a double
                                            } catch (NumberFormatException ignore) {
                                                System.out.println("Invalid input");
                                            }
                                        }
                                        System.out.println("And write the present date");
                                        scanner.nextLine();
                                        String data = scanner.nextLine();

                                        transactionsALL.transferNtoE(konton, name, amount, data);
                                        administrator.addTransaction(konton.getName(), amount, "transfer", data);
                                        break;
                                    }
                                    case 7: // send money to normal account
                                    {

                                        System.out.println("To who would like to send this");
                                        String name = scanner.nextLine();

                                        System.out.println("What amount would u like to send");

                                        double amount = 0;
                                        while (true) {//sprawwdza czy to double
                                            System.out.println("Type a amount:");
                                            try {
                                                amount = Double.parseDouble(scanner.next());
                                                break; // will only get to here if input was a double
                                            } catch (NumberFormatException ignore) {
                                                System.out.println("Invalid input");
                                            }
                                        }
                                        System.out.println("And write the present date");
                                        scanner.nextLine();
                                        String data = scanner.nextLine();

                                        transactionsALL.transferNtoN(konton, name, amount, data);
                                        administrator.addTransaction(konton.getName(), amount, "transfer", data);

                                        break;
                                    }

                                    case 8://show account
                                    {
                                        konton.tostring();
                                        break;

                                    }
                                    case 0://exit
                                    {
                                        System.exit(0);
                                        break;
                                    }
                                }


                            }
                        }else {
                            System.out.println("We didnt find that account");
                            System.exit(0);
                        }
                    }
                    break;


                    case 3://create  ACCOUNT
                    scanner.nextLine();
                    System.out.println("Czy bedzie to konto premium (true/false)?");

                    boolean ans1=true;
                    boolean prawda1= false;
                    int repeats1=0;

                    while(true) {

                        Scanner keyboard = new Scanner(System.in);
                        System.out.println("Type: ");

                        if(keyboard.hasNextBoolean()){
                            ans1 = keyboard.nextBoolean();

                            break;
                        }

                    }

//                    while (!prawda1)
//                    {
//                        try
//                        {
//
//                            ans1=scanner.nextBoolean();
//                            prawda1 = true;
//
//                        }
//                        catch(InputMismatchException e){
//                            repeats1++;
//                            System.out.println("Wrong input, try writing true or false only");
//                            if(repeats1>5) {
//                                System.out.println("Didnt go well, try another time :)");
//                                System.exit(0);
//                            }
//                        }
//                    }
//
                    System.out.println("Write ur name");
                    String name= scanner.nextLine();
                    boolean xd = check(name);


                   while(!xd){
                      System.out.println("Write your name \n");
                      name= scanner.nextLine();
                      xd=check(name);
                  }

                   System.out.println("Create Password: ");
                    String password= scanner.nextLine();


                    if(ans1){

                    }
                    if(SUPERBANK.addAccount(name, password, ans1)){
                        administrator.addAccount(name,password,ans1);
                    }



                    //SUPERBANK.znalezionekontonromal(name,password);

                    break;


                case 4:
                {
                    String haslo1, login1;
                    System.out.println("Wprowadz login :");
                    scanner.nextLine();
                    login1 = scanner.nextLine();

                    System.out.println("Wprowadz haslo: ");
                    haslo1 = scanner.nextLine();

                    if(administrator.getName().equals(login1) && administrator.getPassword().equals(haslo1)) {

                        System.out.println("Welcome to the administrator account");


                        boolean ewq = false;
                        while (!ewq) {
                            System.out.println("What u want to do my man");
                            menuadmi();


                            int wyi = scanner.nextInt();

                            switch (wyi) {
                                case 2: {
                                    ewq = true;
                                    break;
                                }
                                case 3: {
                                    SUPERBANK.displaycustomers();
                                    break;
                                }
                                case 4: {
                                    SUPERBANK.displaytransactions();
                                    break;
                                }
                            }
                        }


                    }else {
                        System.out.println("Incorrect login and password, dont try to brake into administrator");
                        System.exit(0);
                    }
                    break;

                }


            }
        }

    }

    public static boolean check(String s) {
        if (s.isEmpty()) {
            return false;
        }
        if (!Character.isJavaIdentifierStart(s.charAt(0))) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (!Character.isJavaIdentifierPart(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }




    static void menu(){
        System.out.println("Press 1 to view menu \n" +
                "Press 2 to login into account \n"+
                "Press 3 to create account in our SUPER BANK \n"+
                "Press 4 to log in into administrator account \n"+
                "Press 0 to close BANK APP \n");
    }

    static void menulog(){
        System.out.println("Press 1 to view menu \n" +
                "Press 2 to log out from account \n"+
                "Press 3 to withdraw money \n"+
                "Press 4 to deposit money \n"+
                "Press 5 to display all transactions \n"+
                "Press 6 to send money to account within Accounts Plus+ \n"+
                "Press 7 to send money to account within Normal Accounts \n"+
                "Press 8 to display informations about account \n"+
                "Press 0 to close BANK APP \n");
    }

    static void menuadmi(){
        System.out.println("Press 1 to view menu \n"+
                "Press 2 to log out from account \n"+
                "Press 3 to display every customer \n" +
                "Press 4 to display all transactions \n");
    }

    static void doubleinput(){
        double amountd = 0;
        while (true) {
            System.out.println("Type a amount:");
            try {
                amountd = Double.parseDouble(scanner.next());
                break; // will only get to here if input was a double
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }
        }
    }
}
