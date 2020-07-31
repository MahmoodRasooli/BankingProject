package banking.core;

import java.util.ArrayList;
import java.util.Date;
import banking.model.Account;
import banking.model.AccountStatus;

public class AccountManager
{
    private static ArrayList<Account> _repository = new ArrayList<Account>();    
    private final ClientManager _clientManager;
    private final EmployeeManager _employeeManager;

    public AccountManager() {
        super();

        _clientManager = new ClientManager();
        _employeeManager = new EmployeeManager();
    }

    public static void fillRepository(ArrayList<Account> repository) {
        _repository = repository;
    }

    public boolean createAccount(int accountNumber,
                              int clientId,
                              long initialAmount,
                              int creatorId,
                              String type,
                              StringBuilder errorMessage)
    {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setClientId(clientId);
        account.setBalance(initialAmount);
        account.setCreateDate(new Date());
        account.setCreateUser(creatorId);
        account.setStatus(AccountStatus.Active);
        account.setDeleted(false);
        account.setType(type);

        if(!validateAccountCreation(account, errorMessage))
            return false;

        return true;
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

    // Find account by AccountNumber
    public Account find(int accountNumber) {

        for(Account item : _repository) {
            if(item.getAccountNumber() == accountNumber){
                return item;
            }
        }
        
        return null;
    }

    // Validates if the entered information is valid
    private boolean validateAccountCreation(Account account, StringBuilder errorMessage) {

        // Checks if account number already exists
        if(find(account.getAccountNumber()) != null) {
            errorMessage.append("Account number exists.");
            return false;
        }

        // Validates the client
        if(!_clientManager.checkIfClientIsValid(account.getClientId(), errorMessage)) {
            return false;
        }

        // Validates the employee
        if(!_employeeManager.checkIfEmployeeIsValid(account.getCreateUser(), errorMessage))
            return false;

        return true;
    }
}
