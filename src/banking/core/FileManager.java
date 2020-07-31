package banking.core;

import banking.model.Account;
import banking.model.AccountRequest;
import banking.model.Client;
import banking.model.Employee;

import com.google.gson.stream.JsonReader;
import banking.model.Transaction;
import banking.model.TransactionRequest;

import java.io.*;
import java.util.ArrayList;

import com.google.gson.Gson;

// The main class to handle IO operations
public class FileManager {
    private static final String _clientFileName = "repos-files/Client.json";
    private static final String _employeeFileName = "repos-files/Employee.json";
    private static final String _accountFileName = "repos-files/Account.json";
    private static final String _transactionFileName = "repos-files/Transaction.json";
    private static final String _accountRequstFileName = "repos-files/AccountRequest.json";
    private static final String _transactionRequestFileName = "repos-files/TransactionRequest.json";

    // Creates the necessary files if needed.
    public static boolean initiateFiles(StringBuilder errorMessage) {
        if (!initiateClientFile(errorMessage))
            return false;

        if (!initiateEmployeeFile(errorMessage))
            return false;

        if (!initiateAccountFile(errorMessage))
            return false;

        if (!initiateTransactionFile(errorMessage))
            return false;

        if (!initiateAccountRequestFile(errorMessage))
            return false;

        if (!initiateTransactionRequestFile(errorMessage))
            return false;

        if (!initiateAccountFile(errorMessage))
            return false;

        return true;
    }

    public static boolean initiateClientFile(StringBuilder errorMessage) {
        File clientFile = new File(_clientFileName);

        try {
            if (!clientFile.createNewFile()) {
                ArrayList<Client> data = readFile(EntityType.Client);

                if (data == null)
                    data = new ArrayList<Client>();

                ClientManager.fillRepository(data);
            } else {
                ClientManager.fillRepository(new ArrayList<Client>());
            }

            return true;
        } catch (Exception ex) {
            errorMessage.append("Error in initiating Client.json file.");
            return false;
        }
    }

    public static boolean initiateEmployeeFile(StringBuilder errorMessage) {
        File employeeFile = new File(_employeeFileName);

        try {
            if (!employeeFile.createNewFile()) {
                ArrayList<Employee> data = readFile(EntityType.Employee);

                if (data == null)
                    data = new ArrayList<Employee>();

                EmployeeManager.fillRepository(data);
            } else {
                EmployeeManager.fillRepository(new ArrayList<Employee>());
            }

            return true;
        } catch (Exception ex) {
            errorMessage.append("Error in initiating Employee.json file.");
            return false;
        }
    }

    public static boolean initiateAccountFile(StringBuilder errorMessage) {
        File accountFile = new File(_accountFileName);

        try {
            if (!accountFile.createNewFile()) {
                ArrayList<Account> data = readFile(EntityType.Account);

                if (data == null)
                    data = new ArrayList<Account>();

                AccountManager.fillRepository(data);
            } else {
                AccountManager.fillRepository(new ArrayList<Account>());
            }

            return true;
        } catch (Exception ex) {
            errorMessage.append("Error in initiating Account.json file.");
            return false;
        }
    }

    public static boolean initiateTransactionFile(StringBuilder errorMessage) {
        File transactionFile = new File(_transactionFileName);

        try {
            if (!transactionFile.createNewFile()) {
                ArrayList<Transaction> data = readFile(EntityType.Transaction);

                if (data == null)
                    data = new ArrayList<Transaction>();

                TransactionManager.fillRepository(data);
            } else {
                TransactionManager.fillRepository(new ArrayList<Transaction>());
            }

            return true;
        } catch (Exception ex) {
            errorMessage.append("Error in initiating Transaction.json file.");
            return false;
        }
    }

    public static boolean initiateAccountRequestFile(StringBuilder errorMessage) {
        File accountRequestFile = new File(_accountRequstFileName);

        try {
            if (!accountRequestFile.createNewFile()) {
                ArrayList<AccountRequest> data = readFile(EntityType.AccountRequest);

                if (data == null)
                    data = new ArrayList<AccountRequest>();

                AccountRequestManager.fillRepository(data);
            } else {
                AccountRequestManager.fillRepository(new ArrayList<AccountRequest>());
            }

            return true;
        } catch (Exception ex) {
            errorMessage.append("Error in initiating AccountRequest.json file.");
            return false;
        }
    }

    public static boolean initiateTransactionRequestFile(StringBuilder errorMessage) {
        File transactionRequestFile = new File(_transactionRequestFileName);

        try {
            if (!transactionRequestFile.createNewFile()) {
                ArrayList<TransactionRequest> data = readFile(EntityType.TransactionRequest);

                if (data == null)
                    data = new ArrayList<TransactionRequest>();

                TransactionRequestManager.fillRepository(data);
            } else {
                TransactionRequestManager.fillRepository(new ArrayList<TransactionRequest>());
            }

            return true;
        } catch (Exception ex) {
            errorMessage.append("Error in initiating TransactionRequest.json file.");
            return false;
        }
    }

    public static <T> boolean writeToFile(ArrayList<T> collection, EntityType entityType, StringBuilder errorMessage) {

        try {
            Gson gson = new Gson();
            gson.toJson(collection, new FileWriter(getFileName(entityType)));
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            errorMessage.append(String.format("Error in saving {0} file", entityType));
            return false;
        }
    }

    public static <E> ArrayList<E> readFile(EntityType entityType) {
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(getFileName(entityType)));
            ArrayList<E> data = gson.fromJson(reader, (new ArrayList<E>()).getClass());
            return data;
        } catch (Exception ex) {
            return null;
        }
    }

    private static String getFileName(EntityType fileType) {
        switch (fileType) {
            case Account:
                return _accountFileName;
            case AccountRequest:
                return _accountRequstFileName;
            case Client:
                return _clientFileName;
            case Employee:
                return _employeeFileName;
            case Transaction:
                return _transactionFileName;
            case TransactionRequest:
                return _transactionRequestFileName;
            default:
                return "";
        }
    }
}