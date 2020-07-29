package banking.core;

import java.io.IOException;
import java.io.StringWriter;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import banking.model.Account;
import banking.model.AccountStatus;
import org.json.simple.JSONObject;

public class AccountManger
{
    Scanner input = new Scanner(System.in);

    Account account = new Account();
    JSONObject jsonAcount = new JSONObject();
    //       355414093403750
    //       355413093403752
    //       0901 725 7950

    public void createAccount()
    {
        System.out.println("Enter the account number");
        account.setAccountNumber(input.nextInt());

        System.out.println("Enter the name of account holder");
        account.setAccountHolder(input.next());

        System.out.println("Enter the initial amount");
        account.setBalance(input.nextInt());

        System.out.println("Enter the account creator name");
        account.setCreateUser(input.nextInt());

        do
        {
            System.out.println("Choose your account type");
            System.out.println("1. Deposit");
            System.out.println("2. Current");
            if(input.next().equals("1"))
                account.setType("deposit");
            else if(input.next().equals("2"))
                account.setType("current");
            else
                System.out.println("Invalid option");
        }while(!(input.next().equals("1") || input.next().equals("2")));

        account.setStatus(AccountStatus.Active);
        account.setDeleted(false);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        account.setCreateDate(date);


        jsonAcount.put("account number", account.getAccountNumber());
        jsonAcount.put("account holder", account.getAccountHolder());
        jsonAcount.put("account balance", account.getBalance());
        jsonAcount.put("account type", account.getType());
        jsonAcount.put("account create date", account.getCreateDate());
        jsonAcount.put("account creator name", account.getCreateUser());
        jsonAcount.put("account status", account.getStatus());
        jsonAcount.put("is account deleted?", account.isDeleted());
        System.out.println("Account succesfully created");
    }

    public void showAccount()
    {
        StringWriter accountOut = new StringWriter();
        try
        {
            jsonAcount.writeJSONString(accountOut);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String jsonAccountText = accountOut.toString();
        System.out.print(jsonAccountText);
    }

    public void updateAccount()
    {

    }

    public void deleteAccount()
    {

    }
}
