package banking.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


// The main class to handle IO operations
public class FileHandler {

    // Creates the necessary files if needed.
    public static boolean initiateFiles(StringBuilder errorMessage) {

        File file = new File("file.JSON");

        try{

            // Account.json
            // Client.Json
            // ...
            //Json
            if(file.createNewFile()) {
                System.out.println("File successfully created");
                return true;
            }
            else {
                System.out.println("File exists");
                return false;
            }
        }
        catch (Exception ex){
            errorMessage.append("Error in initiating files.");
            return  false;
        }

        //return false;
    }

    public static void writeToFiles(Object object) {
        try {
            FileWriter fileWriter = new FileWriter("file.JSON");
            fileWriter.write(object.toString());
            fileWriter.close();
        }
        catch (IOException ex){
        }
    }

    public static void writeToFileWithFile(File file) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file.getAbsolutePath());
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void readFile(){
        File file = new File("file.JSON");
        try {
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNext()){

            }
            fileReader.close();
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
