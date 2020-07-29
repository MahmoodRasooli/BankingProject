package banking.core;

<<<<<<< HEAD
import banking.model.Transaction;

public class TransactionManager
{
    Transaction transaction = new Transaction();

    public void deposit(int deposit)
    {

    }

    public void withdraw(int withdraw)
    {

    }

    public boolean transfer(int transfer, int senderAccountNumber, int recieverAccountNumber)
    {
        return false;
    }

    public void search()
    {

    }

    public void getAll()
    {

    }

    public void query()
    {

    }
}
=======
import java.util.ArrayList;
import java.util.List;

import banking.model.Transaction;

public class TransactionManager {
    private static List<Transaction> _repository = new ArrayList<Transaction>();

    public TransactionManager() {
        super();            
    }

    public static void fillRepository(List<Transaction> repository) {
        _repository = repository;
    }

    public boolean feposit(String accountNumber, int clientId, int employeeId, long amount) {
        return true;
    }

    public boolean widthraw(String accountNumber, int clientId, int employeeId, long amount) {
        return true;
    }

    public boolean transfer(String sourceAccountNumber, String targetAccountNumber, int clientId, int employeeId,
            long amount) {
        return true;
    }
}
>>>>>>> 591f26a2cf66f22b0e3b1d6c7d1976b138e893db
