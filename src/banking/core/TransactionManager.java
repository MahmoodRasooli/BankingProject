package banking.core;

import java.util.ArrayList;
import java.util.List;
import banking.model.Transaction;

public class TransactionManager
{
    private static ArrayList<Transaction> _repository = new ArrayList<Transaction>();

    public TransactionManager() {
        super();            
    }

    public static void fillRepository(ArrayList<Transaction> repository) {
        _repository = repository;
    }

    public boolean deposit(String accountNumber, int clientId, int employeeId, long amount) {
        return true;
    }

    public boolean withdraw(String accountNumber, int clientId, int employeeId, long amount) {
        return true;
    }

    public boolean transfer(String sourceAccountNumber, String targetAccountNumber, int clientId, int employeeId,
            long amount)
    {
        return true;
    }

    public ArrayList<Transaction> getAll()
    {
        return _repository;
    }
}