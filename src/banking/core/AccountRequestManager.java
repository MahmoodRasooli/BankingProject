package banking.core;

import banking.model.Account;
import banking.model.AccountRequest;

import java.util.ArrayList;

public class AccountRequestManager
{
    private static ArrayList<AccountRequest> _repository = new ArrayList<>();
    private final ClientManager _clientManager;
    private final EmployeeManager _employeeManager;

    public static void fillRepository(ArrayList<AccountRequest> repository) { _repository = repository; }

    public AccountRequestManager() {
        super();
        _clientManager = new ClientManager();
        _employeeManager = new EmployeeManager();
    }

    public boolean createAccountRequest() { return true; }

    public boolean updateAccountRequest() { return true; }
}