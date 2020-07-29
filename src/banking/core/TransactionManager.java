package banking.core;

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