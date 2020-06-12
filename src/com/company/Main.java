package com.company;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static Scanner scanner = new Scanner(System.in);




    public static void main(String[] args) {

        BANK SUPERBANK = new BANK();
        boolean isUp = true;


        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$ \n" +
                           "    WELCOME TO THE BANK      \n" +
                           "$$$$$$$$$$$$$$$$$$$$$$$$$$$$ \n");
        menu();

        while(isUp){

            System.out.println("Choose option : ");

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
                    int repeats=0;

                    while (!prawda)
                    {
                        try
                        {
                            scanner.nextLine();
                            ans=scanner.nextBoolean();
                            prawda = true;

                        }
                        catch(InputMismatchException e){
                            repeats++;
                            System.out.println("Wrong input, try writing true or false only");
                            if(repeats>5) {
                                System.out.println("Didnt go well, try another time :)");
                                System.exit(0);
                            }
                        }
                    }

                    System.out.println(ans);

                    scanner.nextLine();


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

                    }

                    break;




                case 3://create SUper ACCOUNT
                    scanner.nextLine();
                    System.out.println("Czy bedzie to konto premium (true/false)?");

                    boolean ans1=true;
                    boolean prawda1= false;
                    int repeats1=0;

                    while (!prawda1)
                    {
                        try
                        {
                            scanner.nextLine();
                            ans1=scanner.nextBoolean();
                            prawda1 = true;

                        }
                        catch(InputMismatchException e){
                            repeats1++;
                            System.out.println("Wrong input, try writing true or false only");
                            if(repeats1>5) {
                                System.out.println("Didnt go well, try another time :)");
                                System.exit(0);
                            }
                        }
                    }
                    scanner.nextLine();
                    System.out.println("Write your name: ");
                    String name= scanner.nextLine();
                    boolean xd = check(name);


                   while(!xd){
                      System.out.println("Write your name \n");
                      name= scanner.nextLine();
                      xd=check(name);
                  }




                    System.out.println("Create Password: ");
                    String password= scanner.nextLine();


                    System.out.println("U have just created an standard account");

                    SUPERBANK.addAccount(name, password, ans1);
                    SUPERBANK.znalezionekontonromal(name,password);

                    break;


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
                "Press 4 to display every customer \n" +
                "Press 0 to close BANK APP \n");
    }
}
