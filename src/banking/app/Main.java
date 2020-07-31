package banking.app;

import banking.core.FileManager;

public class Main {

    public static void main(String[] args) {
        StringBuilder errorMessage = new StringBuilder();

        if(!FileManager.initiateFiles(errorMessage)) {
            System.out.println(errorMessage);
            return;
        }
    }
}