package banking.app;
import banking.core.FileHandler;

public class Main {

    public static void main(String[] args) {
        StringBuilder errorMessage = new StringBuilder();
        boolean initiateFilesResult = FileHandler.initiateFiles(errorMessage);

        if(!initiateFilesResult) {
            System.out.println(errorMessage);
            return;
        }
    }
}