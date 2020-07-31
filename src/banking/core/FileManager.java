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
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
                Gson gson = new Gson();
                ArrayList<Client> data = gson.fromJson(readFile(EntityType.Client), new TypeToken<ArrayList<Client>>(){}.getType());

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
                Gson gson = new Gson();
                ArrayList<Employee> data = gson.fromJson(readFile(EntityType.Employee), new TypeToken<ArrayList<Employee>>(){}.getType());

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
                Gson gson = new Gson();
                ArrayList<Account> data = gson.fromJson(readFile(EntityType.Account), new TypeToken<ArrayList<Account>>(){}.getType());


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
                Gson gson = new Gson();
                ArrayList<Transaction> data = gson.fromJson(readFile(EntityType.Transaction), new TypeToken<ArrayList<Transaction>>(){}.getType());

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
                Gson gson = new Gson();
                ArrayList<AccountRequest> data = gson.fromJson(readFile(EntityType.AccountRequest), new TypeToken<ArrayList<AccountRequest>>(){}.getType());

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
                Gson gson = new Gson();
                ArrayList<TransactionRequest> data = gson.fromJson(readFile(EntityType.TransactionRequest), new TypeToken<ArrayList<TransactionRequest>>(){}.getType());

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
            FileWriter fileWriter = new FileWriter(getFileName(entityType));
            gson.toJson(collection, fileWriter);
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            errorMessage.append(String.format("Error in saving {0} file", entityType));
            return false;
        }
    }

    public static String readFile(EntityType entityType) {
        try {
            File file = new File(getFileName(entityType));
            Scanner fileScanner = new Scanner(file);
            StringBuilder result = new StringBuilder();
            
            while(fileScanner.hasNextLine()){
                result.append(fileScanner.nextLine());
            }

            return result.toString();
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