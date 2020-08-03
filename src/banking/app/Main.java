package banking.app;


import banking.core.AccountManager;
import java.text.DateFormat;
import java.util.Date;
import banking.core.ClientManager;
import banking.core.FileManager;
import banking.model.Account;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        StringBuilder errorMessage = new StringBuilder();

        if (!FileManager.initiateFiles(errorMessage)) {
            System.out.println(errorMessage);
            return;
        }

        ClientManager clientManager = new ClientManager();
        if (!clientManager.create("mahmood", "rasooli", "male", "09191981527", "tehran", "rasuli.ut@gmail.com", 1,
                new Date(1988, 4, 11), "0112418916", "123456", errorMessage)) {
            System.out.println(errorMessage);
            return;
        }
    }
}