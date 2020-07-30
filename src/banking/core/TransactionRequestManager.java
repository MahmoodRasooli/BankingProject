package banking.core;

import banking.model.Transaction;
import banking.model.TransactionRequest;

import java.util.ArrayList;

public class TransactionRequestManager
{
    private static ArrayList<TransactionRequest> _repository = new ArrayList<>();

    public static void fillRepository(ArrayList<TransactionRequest> repository) { _repository = repository; }

    public TransactionRequestManager() { super(); }

    public void createTransactionRequest()
    {

    }

    public void transactionRequestStatus()
    {

    }

    public void search()
    {

    }

    public ArrayList<TransactionRequest> getAll()
    {
        return _repository;
    }

    public void query()
    {

    }
}