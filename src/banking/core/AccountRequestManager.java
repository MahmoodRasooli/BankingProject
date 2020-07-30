package banking.core;

import banking.model.AccountRequest;

import java.util.ArrayList;

public class AccountRequestManager
{
    private static ArrayList<AccountRequest> _repository = new ArrayList<>();

    public static void fillRepository(ArrayList<AccountRequest> repository) { _repository = repository; }

    public AccountRequestManager() { super(); }

    public void createAccountRequest()
    {

    }

    public void accountRequestStatus()
    {

    }

    public void search()
    {

    }

    public ArrayList<AccountRequest> getAll()
    {
        return _repository;
    }

    public void query()
    {

    }
}