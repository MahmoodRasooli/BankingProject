package banking.core;

import java.io.File;


// The main class to handle IO operations
public class FileHandler {

    // Creates the necessary files if needed.
    public static boolean initiateFiles(StringBuilder errorMessage) {

        try{

            // Account.json
            // Client.Json
            // ...
            //Json
        }
        catch (Exception ex){
            errorMessage.append("Error in initiating files.");
            return  false;
        }

        return true;
    }
}
