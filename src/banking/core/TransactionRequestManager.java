package banking.core;

import banking.model.Transaction;
import banking.model.TransactionRequest;

import java.util.ArrayList;

public class TransactionRequestManager
{
    private static ArrayList<TransactionRequest> _repository = new ArrayList<>();
    private final AccountManager _accountManager;
    private final ClientManager _clientManager;
    private final EmployeeManager _employeeManager;

    public static void fillRepository(ArrayList<TransactionRequest> repository) { _repository = repository; }

    public TransactionRequestManager() {
        super();
        _accountManager = new AccountManager();
        _clientManager = new ClientManager();
        _employeeManager = new EmployeeManager();
    }

    public boolean createTransactionRequest() { return true; }

    public ArrayList<TransactionRequest> getAll()
    {
        return _repository;
    }
}