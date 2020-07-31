package banking.core;

import java.io.IOException;
import java.io.StringWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import banking.model.Account;
import banking.model.AccountStatus;
import banking.model.Transaction;
//import org.json.simple.JSONObject;

public class AccountManager
{
    private static ArrayList<Account> _repository = new ArrayList<Account>();

    public AccountManager() { super(); }

    public static void fillRepository(ArrayList<Account> repository) {
        _repository = repository;
    }

    public void createAccount(int accountNumber,
                              String accountHolder,
                              int clientId,
                              long initialAmount,
                              long creatorId,
                              String type)
    {
        Account account = new Account();
        System.out.println("Enter the account number");
        account.setAccountNumber(accountNumber);

        System.out.println("Enter the name of account holder");
        account.setAccountHolder(accountHolder);

        System.out.println("Enter the initial amount");
        account.setBalance(initialAmount);

        System.out.println("Enter the account creator name");
        account.setCreateUser(clientId);

        account.setType(type);
        account.setStatus(AccountStatus.Active);
        account.setDeleted(false);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        account.setCreateDate(date);

        this._repository.add(account);
        //JSONObject JsonAccount = new JSONObject();
        FileManager fileManager = new FileManager();
        StringBuilder stringBuilder = new StringBuilder();
        fileManager.initiateAccountFile(stringBuilder);
    }

    public void showAccount()
    {

    }

    public void updateAccount()
    {

    }

    public void deleteAccount()
    {

    }

    public ArrayList<Account> getAll()
    {
        return _repository;
    }
}
