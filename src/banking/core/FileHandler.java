package banking.core;

import javax.swing.text.html.parser.Entity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


// The main class to handle IO operations
public class FileHandler {
    private static final String _clientFileName = "Client.json";
    private static final String _employeeFileName = "Employee.json";
    private static final String _accountFileName = "Account.json";
    private static final String _transactionFileName = "Transaction.json";
    private static final String _accountRequstFileName = "AccountRequest.json";
    private static final String __transactionRequestFileName = "TransactionRequest.json";

    // Creates the necessary files if needed.
    public static boolean initiateFiles(StringBuilder errorMessage) {

        File clientFile = new File(_clientFileName);

        try {
            clientFile.createNewFile();
            return true;
        }
        catch (Exception ex){
            errorMessage.append("Error in initiating files.");
            return  false;
        }
    }

    public static void writeToFile(Object object, EntityType type) {
        try {
            FileWriter fileWriter = new FileWriter(getFileName(type));
            fileWriter.write(object.toString());
            fileWriter.close();
        }
        catch (IOException ex){
        }
    }

    public static void readFile(EntityType entityType){
        File file = new File(getFileName(entityType));

    }

    private static String getFileName(EntityType fileType){
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
