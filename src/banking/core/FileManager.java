package banking.core;

import banking.model.Account;
import com.google.gson.stream.JsonReader;
import org.json.simple.JSONObject;
import banking.model.Transaction;
import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;


// The main class to handle IO operations
public class FileManager
{
    private static final String _clientFileName = "Client.json";
    private static final String _employeeFileName = "Employee.json";
    private static final String _accountFileName = "Account.json";
    private static final String _transactionFileName = "Transaction.json";
    private static final String _accountRequstFileName = "AccountRequest.json";
    private static final String __transactionRequestFileName = "TransactionRequest.json";

    // Creates the necessary files if needed.
    public static boolean initiateFiles(StringBuilder errorMessage)
    {
        if(!initiateClientFile(errorMessage))
            return false;

        if(!initiateEmployeeFile(errorMessage))
            return false;

        if(!initiateAccountFile(errorMessage))
            return false;

        if(!initiateTransactionFile(errorMessage))
            return false;

        if(!initiateAccountRequestFile(errorMessage))
            return false;

        if(!initiateTransactionRequestFile(errorMessage))
            return false;

        if(!initiateAccountFile(errorMessage))
            return false;

        return true;
    }

    public static boolean initiateClientFile(StringBuilder errorMessage)
    {
        File clientFile = new File(_clientFileName);

        try
        {
            if(!clientFile.createNewFile()) {
                ArrayList<Account> data = readFile(EntityType.Account);
                AccountManager.fillRepository(data);
            }
            else{
                TransactionManager.fillRepository(new ArrayList<Transaction>());
            }

            return true;
        }
        catch (Exception ex)
        {
            errorMessage.append("Error in initiating transaction file.");
            return false;
        }
    }

    public static boolean initiateEmployeeFile(StringBuilder errorMessage)
    {
        File employeeFile = new File(_employeeFileName);

        try
        {
            if(!employeeFile.createNewFile()) {
                ArrayList<Account> data = readFile(EntityType.Account);
                AccountManager.fillRepository(data);
            }
            else{
                TransactionManager.fillRepository(new ArrayList<Transaction>());
            }

            return true;
        }
        catch (Exception ex)
        {
            errorMessage.append("Error in initiating transaction file.");
            return false;
        }
    }

    public static boolean initiateAccountFile(StringBuilder errorMessage)
    {
        File accountFile = new File(_accountFileName);

        try
        {
            if(!accountFile.createNewFile()) {
                ArrayList<Account> data = readFile(EntityType.Account);
                AccountManager.fillRepository(data);
            }
            else{
                TransactionManager.fillRepository(new ArrayList<Transaction>());
            }

            return true;
        }
        catch (Exception ex)
        {
            errorMessage.append("Error in initiating transaction file.");
            return false;
        }
    }

    public static boolean initiateTransactionFile(StringBuilder errorMessage)
    {
        File transactionFile = new File(_transactionFileName);

        try
        {
            if(!transactionFile.createNewFile()) {
                ArrayList<Transaction> data = readFile(EntityType.Transaction);
                TransactionManager.fillRepository(data);
            }
            else{
                TransactionManager.fillRepository(new ArrayList<Transaction>());
            }

            return true;
        }
        catch (Exception ex)
        {
            errorMessage.append("Error in initiating transaction file.");
            return false;
        }
    }

    public static boolean initiateAccountRequestFile(StringBuilder errorMessage)
    {
        File accountRequestFile = new File(_accountRequstFileName);

        try
        {
            accountRequestFile.createNewFile();
            return true;
        }
        catch (Exception ex)
        {
            errorMessage.append("Error in initiating account request file.");
            return false;
        }
    }

    public static boolean initiateTransactionRequestFile(StringBuilder errorMessage)
    {
        File transactionRequestFile = new File(_transactionFileName);

        try
        {
            transactionRequestFile.createNewFile();
            return true;
        }
        catch (Exception ex)
        {
            errorMessage.append("Error in initiating transaction request file.");
            return  false;
        }
    }

    public static void writeToFile(JSONObject jsonObject, EntityType type)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(getFileName(type));
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static <E> ArrayList<E> readFile(EntityType entityType)
    {
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(getFileName(entityType)));
            ArrayList<E> data = gson.fromJson(reader, (new ArrayList<E>()).getClass());
            return data;
        }
        catch (Exception ex) {
            return  null;
        }
    }

    private static String getFileName(EntityType fileType)
    {
        switch (fileType){
            case Account:
                return _accountFileName;
            case AccountRequest:
                return  _accountRequstFileName;
            case Client:
                return _clientFileName;
            case Employee:
                return _employeeFileName;
            case Transaction:
                return _transactionFileName;
            case TransactionRequest:
                return  __transactionRequestFileName;
            default:
                return "";
        }
    }
}
