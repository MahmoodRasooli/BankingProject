package banking.app;

import banking.core.*;
import banking.model.Account;
import banking.model.AccountStatus;
import banking.model.Client;
import banking.model.role;

import java.awt.EventQueue;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
    public static void clearScreen() {
        System. out. print("\033[H\033[2J");
        System. out. flush();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        StringBuilder errorMessage = new StringBuilder();

        /*if (!FileManager.initiateFiles(errorMessage)) {
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EmployeeManager employeeManager = new EmployeeManager();
        if(employeeManager.find(1) == null) {
            if(!employeeManager.createEmployee("admin", "admin", "10000000", "male", "0912", "Qom", role.bankManager, 0, "admin@bank.com", 1, new Date(), "123456", errorMessage)) {
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFrame window = new LoginFrame();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error in starting the application", "Error", JOptionPane.ERROR_MESSAGE);                    
                }
            }
        });*/

        if(!FileManager.initiateFiles(errorMessage)){
            System.out.print(errorMessage);
            return;
        }

        EmployeeManager employeeManager = new EmployeeManager();
        if (employeeManager.find(1) == null){
            if(employeeManager.createEmployee("admin", "admin", "10000000", "male", "0912", "Qom", role.bankManager, 0, "admin@bank.com", 1, new Date(), "123456", errorMessage)){
                System.out.print(errorMessage);
                return;
            }
        }

        System.out.println("Welcome to Farabi Bank");
        System.out.println("1.Employee login");
        System.out.println("2.Client login");
        String option = input.next();
        clearScreen();
        System.out.print("National Code: ");
        String nationalCode = input.next();
        System.out.print("Password: ");
        String password = input.next();

        if(option.equals("1")){
            if(employeeManager.login(nationalCode, password, errorMessage) == null){
                System.out.print(errorMessage);
                return;
            }
            else if(employeeManager.findByNationalCode(nationalCode).getRole() == role.bankManager){
                ClientManager clientManager = new ClientManager();
                AccountManager accountManager = new AccountManager();
                clearScreen();
                System.out.println("Bank manager panel");
                System.out.println("1. Add employee");
                System.out.println("2. Add client");
                System.out.println("3. Add account");
                System.out.println("4. Update employee");
                System.out.println("5. Update client");
                System.out.println("6. Update account");
                System.out.println("7. Delete employee");
                System.out.println("8. Delete client");
                System.out.println("9. Delete account");
                System.out.println("10. Find client");
                System.out.println("11. Find employee");
                System.out.println("12. Show all clients");
                System.out.println("13. Show all employees");
                System.out.println("14. Show all transactions of an account");

                String option1 = input.next();
                if(option1.equals("1")){
                    clearScreen();
                    System.out.print("First name: ");
                    String employeeFirstName = input.next();
                    System.out.print("Last Name: ");
                    String employeeLastName = input.next();
                    System.out.print("National Code: ");
                    String employeeNationalCode = input.next();
                    System.out.print("Gender: ");
                    String employeeGender = input.next();
                    System.out.print("Phone number: ");
                    String employeePhoneNumber = input.next();
                    System.out.print("Address: ");
                    String employeeAddress = input.next();
                    System.out.print("Salary: ");
                    long employeeSalary = input.nextByte();
                    System.out.print("Email: ");
                    String employeeEmail = input.next();
                    System.out.print("Password: ");
                    String employeePassword = input.next();
                    if(employeeManager.createEmployee(employeeFirstName, employeeLastName, employeeNationalCode, employeeGender, employeePhoneNumber,
                            employeeAddress, role.bankEmployee, employeeSalary, employeeEmail, 1, new Date(), employeePassword, errorMessage)){
                        System.out.println("Employee successfully created!");
                        return;
                    }
                    else {
                        System.out.println(errorMessage);
                        return;
                    }
                }
                if (option1.equals("2")){
                    clearScreen();
                    System.out.print("First name: ");
                    String clientFirstName = input.next();
                    System.out.print("Last Name: ");
                    String clientLastName = input.next();
                    System.out.print("Gender: ");
                    String clientGender = input.next();
                    System.out.print("Phone number: ");
                    String clientPhoneNumber = input.next();
                    System.out.print("Address: ");
                    String clientAddress = input.next();
                    System.out.print("Email: ");
                    String clientEmail = input.next();
                    System.out.print("National Code: ");
                    String clientNationalCode = input.next();
                    System.out.print("Password: ");
                    String clientPassword = input.next();
                    if(clientManager.create(clientFirstName, clientLastName, clientGender, clientPhoneNumber, clientAddress, clientEmail, 1, new Date(),
                            clientNationalCode, clientPassword, errorMessage)){
                        System.out.println("Client successfully created!");
                        return;
                    }
                    else {
                        System.out.println(errorMessage);
                        return;
                    }
                }
                if (option1.equals("3")){
                    clearScreen();
                    System.out.print("Client Id: ");
                    int clientId = input.nextInt();
                    System.out.print("Initial amount: ");
                    long initialAmount = input.nextByte();
                    System.out.print("Type(Current / Deposit): ");
                    String type = input.next();
                    if(accountManager.create(clientId, initialAmount, 1, type, errorMessage)){
                        System.out.println("Account successfully created!");
                        return;
                    }
                    else {
                        System.out.println(errorMessage);
                        return;
                    }
                }
                if (option1.equals("4")){
                    clearScreen();
                    System.out.print("Id: ");
                    int Id = input.nextInt();
                    System.out.print("First name: ");
                    String employeeFirstName = input.next();
                    System.out.print("Last Name: ");
                    String employeeLastName = input.next();
                    System.out.print("National Code: ");
                    String employeeNationalCode = input.next();
                    System.out.print("Gender: ");
                    String employeeGender = input.next();
                    System.out.print("Phone number: ");
                    String employeePhoneNumber = input.next();
                    System.out.print("Address: ");
                    String employeeAddress = input.next();
                    System.out.print("Salary: ");
                    long employeeSalary = input.nextByte();
                    System.out.print("Email: ");
                    String employeeEmail = input.next();
                    System.out.print("Password: ");
                    String employeePassword = input.next();
                    if (employeeManager.update(Id, employeeFirstName, employeeLastName, employeeGender, employeePhoneNumber, employeeAddress, employeeEmail,
                            new Date(), employeeNationalCode, employeePassword, employeeSalary, errorMessage)){
                        System.out.println("Employee successfully updated!");
                        return;
                    }
                    else {
                        System.out.println(errorMessage);
                        return;
                    }
                }
                if(option1.equals("5")) {
                    System.out.print("Id: ");
                    int Id = input.nextInt();
                    System.out.print("First name: ");
                    String clientFirstName = input.next();
                    System.out.print("Last Name: ");
                    String clientLastName = input.next();
                    System.out.print("Gender: ");
                    String clientGender = input.next();
                    System.out.print("Phone number: ");
                    String clientPhoneNumber = input.next();
                    System.out.print("Address: ");
                    String clientAddress = input.next();
                    System.out.print("Email: ");
                    String clientEmail = input.next();
                    System.out.print("National Code: ");
                    String clientNationalCode = input.next();
                    System.out.print("Password: ");
                    String clientPassword = input.next();
                    if (clientManager.update(Id, clientFirstName, clientLastName, clientGender, clientPhoneNumber, clientAddress,
                            clientEmail, new Date(), clientNationalCode, clientPassword, errorMessage)) {
                        System.out.println("Client successfully updated");
                        return;
                    } else {
                        System.out.println(errorMessage);
                        return;
                    }
                }
                if(option1.equals("6")){
                    clearScreen();
                    System.out.print("Account number: ");
                    int accountNumber = input.nextInt();
                    System.out.print("Balance: ");
                    long balance = input.nextByte();
                    System.out.print("Type(Current / Deposit): ");
                    String type = input.next();
                    System.out.print("Account status(1. Active / 2. Closed / 3. Suspended): ");
                    String accountStatus = input.next();
                    if(accountStatus.equals("1")){
                        if(accountManager.update(accountNumber, balance, type, AccountStatus.Active, errorMessage)){
                            System.out.println("Account successfully updated!");
                            return;
                        }
                        else {
                            System.out.println(errorMessage);
                            return;
                        }
                    }
                    if(accountStatus.equals("2")){
                        if(accountManager.update(accountNumber, balance, type, AccountStatus.Closed, errorMessage)){
                            System.out.println("Account successfully updated!");
                            return;
                        }
                        else {
                            System.out.println(errorMessage);
                            return;
                        }
                    }
                    if(accountStatus.equals("3")){
                        if(accountManager.update(accountNumber, balance, type, AccountStatus.Suspended, errorMessage)){
                            System.out.println("Account successfully updated!");
                            return;
                        }
                        else {
                            System.out.println(errorMessage);
                            return;
                        }
                    }
                }
                if(option1.equals("7")){
                    System.out.print("Id: ");
                    int Id = Integer.parseInt(input.next());
                    if(employeeManager.deleteEmployee(role.bankManager, Id, errorMessage)){
                        System.out.println("Employee successfully deleted");
                        return;
                    }
                    else {
                        System.out.println(errorMessage);
                        return;
                    }
                }
                if(option1.equals("8")){
                    System.out.print("Id: ");
                    int Id = Integer.parseInt(input.next());
                    if(clientManager.deleteClient(role.bankManager, Id, errorMessage)){
                        System.out.println("Client successfully deleted");
                        return;
                    }
                    else {
                        System.out.println(errorMessage);
                        return;
                    }
                }
                if(option1.equals("9")){
                    System.out.print("Account number: ");
                    int accountNumber = Integer.parseInt(input.next());
                    if(accountManager.delete(accountNumber, errorMessage)){
                        System.out.println("Account successfully deleted");
                        return;
                    }
                    else {
                        System.out.println(errorMessage);
                        return;
                    }
                }
                if(option1.equals("10")){
                    System.out.println("1. Find by national code");
                    System.out.println("2. Find by Id");
                    String option2 = input.next();
                    if(option2.equals("1")){
                        System.out.print("National code: ");
                        String findClientNationalCode = input.next();
                        if(clientManager.findByNationalCode(findClientNationalCode) != null) {
                            System.out.print(clientManager.findByNationalCode(findClientNationalCode).toString());
                            return;
                        }
                        else {
                            System.out.println("Cannot find the entered national code");
                            return;
                        }
                    }
                    if(option2.equals("2")){
                        System.out.print("Id");
                        int findClientId = Integer.parseInt(input.next());
                        if(clientManager.find(findClientId) != null){
                            System.out.print(clientManager.find(findClientId).toString());
                            return;
                        }
                        else {
                            System.out.println("Cannot find the entered Id");
                            return;
                        }
                    }
                }
                if(option1.equals("11")){
                    System.out.println("1. Find by national code");
                    System.out.println("2. Find by Id");
                    String option2 = input.next();
                    if(option2.equals("1")){
                        System.out.print("National code: ");
                        String findEmployeeNationalCode = input.next();
                        if(employeeManager.findByNationalCode(findEmployeeNationalCode) != null) {
                            System.out.print(employeeManager.findByNationalCode(findEmployeeNationalCode).toString());
                            return;
                        }
                        else {
                            System.out.println("Cannot find the entered national code");
                            return;
                        }
                    }
                    if(option2.equals("2")){
                        System.out.print("Id");
                        int findEmployeeId = Integer.parseInt(input.next());
                        if(employeeManager.find(findEmployeeId) != null){
                            System.out.print(employeeManager.find(findEmployeeId).toString());
                            return;
                        }
                        else {
                            System.out.println("Cannot find the entered Id");
                            return;
                        }
                    }
                }
                if(option1.equals("12")){
                    clientManager.sortByFirstNameAndLastName();
                }
                if (option1.equals("13")){
                    employeeManager.sortByFirstNameAndLastName();
                }
                if(option1.equals("14")){
                    TransactionManager transactionManager = new TransactionManager();
                    transactionManager.getAll();
                }
            }
            else if(employeeManager.findByNationalCode(nationalCode).getRole() == role.bankEmployee){
                ClientManager clientManager = new ClientManager();
                AccountManager accountManager = new AccountManager();
                TransactionManager transactionManager = new TransactionManager();
                System.out.println("Bank employee panel");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Transfer");
                System.out.println("4. Find clients");
                System.out.println("5. Show all clients");
                System.out.println("6. Find account");
                System.out.println("7. Show all accounts");

            }
        }
        else if(option.equals("2")){
            ClientManager clientManager = new ClientManager();
            AccountManager accountManager = new AccountManager();
            System.out.println("Client panel");
            System.out.println("1. Create Account");
            System.out.println("2. Close account");
            System.out.println("3. Show account");
        }
    }// end of main
}// end of class