package banking.app;

import banking.core.FileManager;

public class Main {

    public static void main(String[] args) {
        StringBuilder errorMessage = new StringBuilder();
        boolean initiateFilesResult = FileManager.initiateFiles(errorMessage);

        if(!initiateFilesResult) {
            System.out.println(errorMessage);
            return;
        }
    }
}