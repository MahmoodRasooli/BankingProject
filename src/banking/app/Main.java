package banking.app;

import banking.core.AccountManager;
import banking.core.FileManager;
import banking.model.Account;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        /*StringBuilder errorMessage = new StringBuilder();

        if(!FileManager.initiateFiles(errorMessage)) {
            System.out.println(errorMessage);
            return;
        }*/
        Login login = new Login();
    }
}