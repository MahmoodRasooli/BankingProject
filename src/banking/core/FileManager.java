package banking.core;

import org.json.simple.JSONObject;

import javax.swing.text.html.parser.Entity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


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
    public static boolean initiateClientFiles(StringBuilder errorMessage)
    {
        File clientFile = new File(_clientFileName);

        try
        {
            clientFile.createNewFile();
            return true;
        }
        catch (Exception ex)
        {
            errorMessage.append("Error in initiating client file.");
            return false;
        }
    }

    public static boolean initiateEmployeeFiles(StringBuilder errorMessage)
    {
        File employeeFile = new File(_employeeFileName);

        try
        {
            employeeFile.createNewFile();
            return true;
        }
        catch (Exception ex)
        {
            errorMessage.append("Error in initiating employee file.");
            return false;
        }
    }

    public static boolean initiateAccountFiles(StringBuilder errorMessage)
    {
        File accountFile = new File(_accountFileName);

        try
        {
            accountFile.createNewFile();
            return true;
        }
        catch (Exception ex)
        {
            errorMessage.append("Error in initiating account file.");
            return false;
        }
    }

    public static boolean initiateTransactionFiles(StringBuilder errorMessage)
    {
        File transactionFile = new File(_transactionFileName);

        try
        {
            transactionFile.createNewFile();
            return true;
        }
        catch (Exception ex)
        {
            errorMessage.append("Error in initiating transaction file.");
            return false;
        }
    }

    public static boolean initiateAccountRequestFiles(StringBuilder errorMessage)
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

    public static boolean initiateTransactionRequestFiles(StringBuilder errorMessage)
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

    public static void readFile(EntityType entityType)
    {
        File file = new File(getFileName(entityType));
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
