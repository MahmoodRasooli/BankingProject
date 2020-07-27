package banking.core;

import java.util.Date;
import java.util.Scanner;

import banking.model.Account;

public class AccountHandler {

    Scanner input = new Scanner(System.in);

    Account account = new Account();

    public void createAccount()
    {
        System.out.println("Enter the account number");
        account.setAccountNumber(input.nextInt());

        System.out.println("Enter the name of account holder");
        account.setAccountHolder(input.next());

        System.out.println("Enter the initial amount");
        account.setBalance(input.nextInt());

        do
        {
            System.out.println("Choose your account type");
            System.out.println("1. Deposit");
            System.out.println("2. Current");
            if(input.next().equals('1'))
                account.setType("deposit");
            else if(input.next().equals('2'))
                account.setType("current");
            else
                System.out.println("Invalid option");
        }while(!(input.next().equals('1') || input.next().equals('2')));
    }

    public void showAccount()
    {
        System.out.println("Account number: " + account.getAccountNumber());
        System.out.println("Account holder: " + account.getAccountHolder());
        System.out.println("Current balance :" + account.getBalance());
        System.out.println("Account type: " + account.getType());
    }

    public void updateAccount()
    {

    }
}
