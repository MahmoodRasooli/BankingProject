package banking.core;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import banking.model.Account;
import banking.model.Transaction;

public class TransactionManager {
    private static ArrayList<Transaction> _repository = new ArrayList<Transaction>();
    private final AccountManager _accountManager;
    private final ClientManager _clientManager;
    private final EmployeeManager _employeeManager;
    private final long maxWithdrawRate = 1000000;
    private final long maxTransferRate = 30000000;

    public TransactionManager() {
        super();

        _accountManager = new AccountManager();
        _clientManager = new ClientManager();
        _employeeManager = new EmployeeManager();
    }

    public static void fillRepository(ArrayList<Transaction> repository) {
        _repository = repository;
    }

    public boolean deposit(int accountNumber, int clientId, int employeeId, long amount, StringBuilder errorMessage) {
        if (_accountManager.checkIfAccountIsValid(accountNumber, errorMessage)
                && _employeeManager.checkIfEmployeeIsValid(employeeId, errorMessage)
                && _clientManager.checkIfClientIsValid(clientId, errorMessage)) {

            Account account = _accountManager.find(accountNumber);
            long currentBalance = account.getBalance();
            currentBalance += amount;
            _accountManager.update(accountNumber, currentBalance, account.getType(), account.getStatus(), errorMessage);
            return true;
        }
        return false;
    }

    public boolean withdraw(int accountNumber, int clientId, int employeeId, long amount, StringBuilder errorMessage) {
        if (_accountManager.checkIfAccountIsValid(accountNumber, errorMessage)
                && _employeeManager.checkIfEmployeeIsValid(employeeId, errorMessage)
                && _clientManager.checkIfClientIsValid(clientId, errorMessage)) {

            Account account = _accountManager.find(accountNumber);
            long currentBalance = account.getBalance();

            if (currentBalance > amount || currentBalance == amount) {
                if (amount < maxWithdrawRate) {

                    currentBalance -= amount;
                    _accountManager.update(accountNumber, currentBalance, account.getType(), account.getStatus(),
                            errorMessage);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean transfer(int sourceAccountNumber, int targetAccountNumber, int clientId, int employeeId, long amount,
            StringBuilder errorMessage) {
        if (_accountManager.checkIfAccountIsValid(sourceAccountNumber, errorMessage)
                && _accountManager.checkIfAccountIsValid(targetAccountNumber, errorMessage)
                && _employeeManager.checkIfEmployeeIsValid(employeeId, errorMessage)
                && _clientManager.checkIfClientIsValid(clientId, errorMessage)) {

            Account sourceAccount = _accountManager.find(sourceAccountNumber);
            long sourceAccountCurrentBalance = sourceAccount.getBalance();

            Account targetAccount = _accountManager.find(targetAccountNumber);
            long targetAccountCurrentBalance = targetAccount.getBalance();

            if (sourceAccountCurrentBalance > amount || sourceAccountCurrentBalance == amount) {
                if (amount < maxTransferRate) {

                    sourceAccountCurrentBalance -= amount;
                    targetAccountCurrentBalance += amount;
                    _accountManager.update(sourceAccountNumber, sourceAccountCurrentBalance, sourceAccount.getType(),
                            sourceAccount.getStatus(), errorMessage);
                    _accountManager.update(targetAccountNumber, targetAccountCurrentBalance, targetAccount.getType(),
                            targetAccount.getStatus(), errorMessage);

                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean schedule(int sourceAccountNumber, ArrayList<Integer> targetAccountNumbers, int clientId,
            int employeeId, long amount, StringBuilder errorMessage) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
            }
        };
        timer.schedule(timerTask, 1000 * 60 * 60 * 24 * 30);
        for (int i = 0; i < targetAccountNumbers.size(); i++) {
            if (transfer(sourceAccountNumber, targetAccountNumbers.get(i), clientId, employeeId, amount, errorMessage))
                return true;
        }
        return false;
    }

    // Returns a list which contains all the transactions
    public ArrayList<Transaction> getAll() {
        return new ArrayList<Transaction>(_repository);
    }

    public ArrayList<Transaction> getClientTransactions(int clientId) {
        Predicate<Transaction> byClientId = transaction -> transaction.getClientId() == clientId;

        var result = new ArrayList<Transaction>(_repository.stream().filter(byClientId)
                .collect(Collectors.toList()));

        return result;
    }
}