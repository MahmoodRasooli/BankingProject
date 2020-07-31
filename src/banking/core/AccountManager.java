package banking.core;

import java.util.ArrayList;
import java.util.Date;
import banking.model.Account;
import banking.model.AccountStatus;

public class AccountManager {
    private static ArrayList<Account> _repository = new ArrayList<Account>();
    private final ClientManager _clientManager;
    private final EmployeeManager _employeeManager;

    public AccountManager() {
        super();

        _clientManager = new ClientManager();
        _employeeManager = new EmployeeManager();
    }

    // Fills the _repository at the starting point of application
    public static void fillRepository(ArrayList<Account> repository) {
        _repository = repository;
    }

    // Returns a list containing all accounts
    public ArrayList<Account> getAll() {
        return new ArrayList<Account>(_repository);
    }

    // Find account by AccountNumber
    public Account find(int accountNumber) {

        for (Account item : _repository) {
            if (item.getAccountNumber() == accountNumber) {
                return item;
            }
        }

        return null;
    }

    public boolean create(int clientId, long initialAmount, int creatorId, String type, StringBuilder errorMessage) {
        Account account = new Account();
        account.setAccountNumber(getNewAccountNumber());
        account.setClientId(clientId);
        account.setBalance(initialAmount);
        account.setCreateDate(new Date());
        account.setCreateUser(creatorId);
        account.setStatus(AccountStatus.Active);
        account.setIsDeleted(false);
        account.setType(type);

        if (!validateAccountCreation(account, errorMessage))
            return false;

        _repository.add(account);
        if (!FileManager.writeToFile(_repository, EntityType.Account, errorMessage)) {
            _repository.remove(account);
            return false;
        }

        return true;
    }

    public boolean update(int accountNumber, long balance, String type, AccountStatus status,
            StringBuilder errorMessage) {

        if (!checkIfAccountIsValid(accountNumber, errorMessage))
            return false;

        Account account = find(accountNumber);

        // Validates the client
        if (!_clientManager.checkIfClientIsValid(account.getClientId(), errorMessage)) {
            return false;
        }

        account.setType(type);
        account.setBalance(balance);
        account.setStatus(status);

        if (!FileManager.writeToFile(_repository, EntityType.Account, errorMessage))
            return false;

        return true;
    }

    public boolean delete(int accountNumber, StringBuilder errorMessage) {

        if (!checkIfAccountIsValid(accountNumber, errorMessage)) {
            return false;
        }

        Account account = find(accountNumber);
        account.setIsDeleted(true);

        if (!FileManager.writeToFile(_repository, EntityType.Account, errorMessage))
            return false;

        return true;
    }

    // Returns a new account number
    // Use this method to assign a new account number when creating new account
    public static int getNewAccountNumber() {
        int maxAccountNumber = 0;
        for (Account item : _repository) {
            if (item.getAccountNumber() > maxAccountNumber)
                maxAccountNumber = item.getAccountNumber();
        }

        return maxAccountNumber == 0 ? 100000 : maxAccountNumber + 1;
    }

    // Validates a given account
    public boolean checkIfAccountIsValid(int accountNumber, StringBuilder errorMessage) {
        Account account = find(accountNumber);

        if (account == null || account.getIsDeleted()) {
            errorMessage.append("Account does not exist.");
            return false;
        }

        // if (account.getStatus() != AccountStatus.Active) {
        // errorMessage.append("Account is not active.");
        // return false;
        // }

        return true;
    }

    // Validates if the entered information is valid
    private boolean validateAccountCreation(Account account, StringBuilder errorMessage) {

        // Checks if account number already exists
        if (find(account.getAccountNumber()) != null) {
            errorMessage.append("Account number exists.");
            return false;
        }

        // Validates the client
        if (!_clientManager.checkIfClientIsValid(account.getClientId(), errorMessage)) {
            return false;
        }

        // Validates the employee
        if (!_employeeManager.checkIfEmployeeIsValid(account.getCreateUser(), errorMessage))
            return false;

        return true;
    }
}
