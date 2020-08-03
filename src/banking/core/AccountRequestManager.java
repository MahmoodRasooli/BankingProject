package banking.core;

import banking.model.Account;
import banking.model.AccountRequest;

import java.util.ArrayList;

public class AccountRequestManager
{
    private static ArrayList<AccountRequest> _repository = new ArrayList<>();
    private final AccountManager _accountManager;
    private final ClientManager _clientManager;
    private final EmployeeManager _employeeManager;

    public static void fillRepository(ArrayList<AccountRequest> repository) { _repository = repository; }

    public AccountRequestManager() {
        super();
        _accountManager = new AccountManager();
        _clientManager = new ClientManager();
        _employeeManager = new EmployeeManager();
    }

    public boolean createAccountRequest(int clientId, long initialAmount, int creatorId, String type, StringBuilder errorMessage) {
        _accountManager.create(clientId, initialAmount, creatorId, type, errorMessage);
        return true;
    }

    public boolean updateAccountRequest() { return true; }
}