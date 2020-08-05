package banking.app;

import banking.core.*;
import banking.model.Account;
import banking.model.AccountStatus;
import banking.model.Client;
import banking.model.Employee;
import banking.model.role;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static int _currentUserId = 0;
    private static role _currentUserRole;
    private static ClientManager _clientManager;
    private static EmployeeManager _employeeManager;
    private static AccountManager _accountManager;
    private static TransactionManager _transactionManager;
    private static TransactionRequestManager _transactionRequestManager;

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        if (!initiateApplication())
            return;

        boolean continueCommand = true;
        while (continueCommand) {
            continueCommand = login();
        }
    }// end of main

    private static boolean initiateApplication() {
        StringBuilder errorMessage = new StringBuilder();
        if (!FileManager.initiateFiles(errorMessage)) {
            System.out.println(errorMessage);
            System.out.println("Press any key to exit...");
            Scanner scanner = new Scanner(System.in);
            scanner.next();
            scanner.close();
            return false;
        }

        _clientManager = new ClientManager();
        _employeeManager = new EmployeeManager();
        _accountManager = new AccountManager();
        _transactionManager = new TransactionManager();
        _transactionRequestManager = new TransactionRequestManager();

        if (_employeeManager.find(1) == null) {
            if (!_employeeManager.createEmployee("admin", "admin", "10000000", "male", "0912", "Qom", role.bankManager,
                    0, "admin@bank.com", 1, new Date(), "123456", errorMessage)) {
                System.out.println(errorMessage);
                return true;
            }
        }

        return true;
    }

    private static boolean login() {
        StringBuilder errorMessage = new StringBuilder();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Farabi Bank");
        System.out.println("1. Employee Login");
        System.out.println("2. Client Login");
        System.out.println("3. Exit");
        String option = input.next();

        if (option.equals("3")) {
            input.close();
            return false;
        }

        clearScreen();
        System.out.println("National Code: ");
        String nationalCode = input.next();
        System.out.println("Password: ");
        String password = input.next();
        input.close();

        if (option.equals("1")) {
            Employee employee = _employeeManager.login(nationalCode, password, errorMessage);
            if (employee == null) {
                System.out.println(errorMessage);
                return true;
            } else {
                _currentUserId = employee.getId();
                _currentUserRole = employee.getRole();

                if (_currentUserRole == role.bankEmployee) {
                    employee_ShowActions();
                } else {
                    manager_ShowActions();
                }
            }
        } else if (option.equals("2")) {
            Client client = _clientManager.login(nationalCode, password, errorMessage);
            if (client == null) {
                System.out.println(errorMessage);
                return true;
            } else {
                _currentUserId = client.getId();
                _currentUserRole = role.bankClient;

                client_ShowActions();
            }
        }

        return true;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////// Employee Actions ///////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static void employee_ShowActions() {
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("Bank employee panel");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Find client");
        System.out.println("5. Show all clients");
        System.out.println("6. Find account");
        System.out.println("7. Show all accounts");

        String option = input.next();
        input.close();

        if (option.equals("1")) {
            employee_Deposit();
        }
        if (option.equals("2")) {
            employee_Withdraw();
        }
        if (option.equals("3")) {
            employee_Transfer();
        }
        if (option.equals("4")) {
            employee_FindClient();
        }
        if (option.equals("5")) {
            employee_ShowAllClients();
        }
        if (option.equals("6")) {
            employee_FindAccount();
        }
        if (option.equals("7")) {
            employee_ShowAllAccounts();
        }
    }

    private static void employee_Deposit() {
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("account number: ");
        int accountNumber = Integer.parseInt(input.next());
        System.out.println("client Id: ");
        int clientId = Integer.parseInt(input.next());
        System.out.println("employee Id: ");
        int employeeId = Integer.parseInt(input.next());
        System.out.println("");
    }

    private static void employee_Withdraw(){

    }

    private static void employee_Transfer(){

    }

    private static void employee_FindClient(){

    }

    private static void employee_ShowAllClients(){

    }

    private static void employee_FindAccount(){

    }

    private static void employee_ShowAllAccounts(){

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////// Manager Actions ///////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static void manager_ShowActions() {
        clearScreen();
        Scanner input = new Scanner(System.in);
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

        String option = input.next();
        input.close();

        if (option.equals("1")) {
            manager_AddEmployee();
        }
        if (option.equals("2")) {
            manager_AddClient();
        }
        if (option.equals("3")) {
            manager_AddAccount();
        }
        if (option.equals("4")) {
            manager_UpdateEmployee();
        }
        if (option.equals("5")) {
            manager_UpdateClient();
        }
        if (option.equals("6")) {
            manager_UpdateAccount();
        }
        if (option.equals("7")) {
            manager_DeleteEmployee();
        }
        if (option.equals("8")) {
            manager_DeleteClient();
        }
        if (option.equals("9")) {
            manager_DeleteAccount();
        }
        if (option.equals("10")) {
            manager_FindClient();
        }
        if (option.equals("11")) {
            manager_FindEmployee();
        }
        if (option.equals("12")) {
            manager_ShowAllClients();
        }
        if (option.equals("13")) {
            manager_ShowAllEmployees();
        }
        if (option.equals("14")) {
            manager_ShowAllTransactions();
        }
    }

    private static void manager_ShowAllTransactions() {

    }

    private static void manager_ShowAllClients() {

    }

    private static void manager_ShowAllEmployees() {
        ArrayList<Employee> employees = _employeeManager.getAll();

        int index = 1;
        for(Employee item: employees) {
            System.out.println(String.format("%d. %s", index, item.toString()));
            index++;
        }
    }

    private static void manager_FindEmployee() {
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("1. Find by national code");
        System.out.println("2. Find by Id");
        String option = input.next();

        if (option.equals("1")) {
            System.out.println("National code: ");
            String findEmployeeNationalCode = input.next();
            if (_employeeManager.findByNationalCode(findEmployeeNationalCode) != null) {
                System.out.println(_employeeManager.findByNationalCode(findEmployeeNationalCode).toString());
            } else {
                System.out.println("Cannot find the entered national code");
            }
        }
        if (option.equals("2")) {
            System.out.println("Id:");
            int findEmployeeId = Integer.parseInt(input.next());
            if (_employeeManager.find(findEmployeeId) != null) {
                System.out.println(_employeeManager.find(findEmployeeId).toString());
            } else {
                System.out.println("Cannot find the entered Id");
            }
        }

        input.close();
    }

    private static void manager_FindClient() {
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("1. Find by national code");
        System.out.println("2. Find by Id");
        String option = input.next();
        
        if (option.equals("1")) {
            System.out.println("National code: ");
            String findClientNationalCode = input.next();
            if (_clientManager.findByNationalCode(findClientNationalCode) != null) {
                System.out.println(_clientManager.findByNationalCode(findClientNationalCode).toString());
            } else {
                System.out.println("Cannot find the entered national code");
            }
        }
        if (option.equals("2")) {
            System.out.println("Id");
            int findClientId = Integer.parseInt(input.next());
            if (_clientManager.find(findClientId) != null) {
                System.out.println(_clientManager.find(findClientId).toString());
            } else {
                System.out.println("Cannot find the entered Id");
            }
        }
        
        input.close();
    }

    private static void manager_DeleteAccount() {
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("Account number: ");
        int accountNumber = Integer.parseInt(input.next());
        input.close();
        StringBuilder errorMessage = new StringBuilder();

        if (_accountManager.delete(accountNumber, errorMessage)) {
            System.out.println("Account successfully deleted");
            return;
        } else {
            System.out.println(errorMessage);
            return;
        }
    }

    private static void manager_DeleteClient() {
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("Id: ");
        int Id = Integer.parseInt(input.next());
        input.close();
        StringBuilder errorMessage = new StringBuilder();

        if (_clientManager.deleteClient(role.bankManager, Id, errorMessage)) {
            System.out.println("Client successfully deleted");
            return;
        } else {
            System.out.println(errorMessage);
            return;
        }
    }

    private static void manager_DeleteEmployee() {
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("Id: ");
        int Id = Integer.parseInt(input.next());
        StringBuilder errorMessage = new StringBuilder();
        input.close();

        if (_employeeManager.deleteEmployee(role.bankManager, Id, errorMessage)) {
            System.out.println("Employee successfully deleted");
            return;
        } else {
            System.out.println(errorMessage);
            return;
        }
    }

    private static void manager_UpdateAccount() {
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("Account number: ");
        int accountNumber = input.nextInt();
        System.out.println("Balance: ");
        long balance = input.nextByte();
        System.out.println("Type(Current / Deposit): ");
        String type = input.next();
        System.out.println("Account status(1. Active / 2. Closed / 3. Suspended): ");
        String accountStatus = input.next();
        StringBuilder errorMessage = new StringBuilder();
        input.close();

        AccountStatus accountStatusValue = accountStatus.equals("1") ? AccountStatus.Active
                : (accountStatus.equals("2") ? AccountStatus.Closed : AccountStatus.Suspended);

        if (_accountManager.update(accountNumber, balance, type, accountStatusValue, errorMessage)) {
            System.out.println("Account successfully updated!");
            return;
        } else {
            System.out.println(errorMessage);
            return;
        }
    }

    private static void manager_UpdateClient() {
        clearScreen();
        Scanner input = new Scanner(System.in);

        System.out.println("Id: ");
        int Id = input.nextInt();
        System.out.println("First name: ");
        String clientFirstName = input.next();
        System.out.println("Last Name: ");
        String clientLastName = input.next();
        System.out.println("Gender: ");
        String clientGender = input.next();
        System.out.println("Phone number: ");
        String clientPhoneNumber = input.next();
        System.out.println("Address: ");
        String clientAddress = input.next();
        System.out.println("Email: ");
        String clientEmail = input.next();
        System.out.println("National Code: ");
        String clientNationalCode = input.next();
        System.out.println("Password: ");
        String clientPassword = input.next();
        input.close();
        StringBuilder errorMessage = new StringBuilder();

        if (_clientManager.update(Id, clientFirstName, clientLastName, clientGender, clientPhoneNumber, clientAddress,
                clientEmail, new Date(), clientNationalCode, clientPassword, errorMessage)) {
            System.out.println("Client successfully updated");
            return;
        } else {
            System.out.println(errorMessage);
            return;
        }
    }

    private static void manager_UpdateEmployee() {
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("Id: ");
        int Id = input.nextInt();
        System.out.println("First name: ");
        String employeeFirstName = input.next();
        System.out.println("Last Name: ");
        String employeeLastName = input.next();
        System.out.println("National Code: ");
        String employeeNationalCode = input.next();
        System.out.println("Gender: ");
        String employeeGender = input.next();
        System.out.println("Phone number: ");
        String employeePhoneNumber = input.next();
        System.out.println("Address: ");
        String employeeAddress = input.next();
        System.out.println("Salary: ");
        long employeeSalary = input.nextByte();
        System.out.println("Email: ");
        String employeeEmail = input.next();
        System.out.println("Password: ");
        String employeePassword = input.next();
        input.close();
        StringBuilder errorMessage = new StringBuilder();

        if (_employeeManager.update(Id, employeeFirstName, employeeLastName, employeeGender, employeePhoneNumber,
                employeeAddress, employeeEmail, new Date(), employeeNationalCode, employeePassword, employeeSalary,
                errorMessage)) {
            System.out.println("Employee successfully updated!");
            return;
        } else {
            System.out.println(errorMessage);
            return;
        }
    }

    private static void manager_AddEmployee() {
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("First name: ");
        String employeeFirstName = input.next();
        System.out.println("Last Name: ");
        String employeeLastName = input.next();
        System.out.println("National Code: ");
        String employeeNationalCode = input.next();
        System.out.println("Gender: ");
        String employeeGender = input.next();
        System.out.println("Phone number: ");
        String employeePhoneNumber = input.next();
        System.out.println("Address: ");
        String employeeAddress = input.next();
        System.out.println("Salary: ");
        long employeeSalary = input.nextByte();
        System.out.println("Email: ");
        String employeeEmail = input.next();
        System.out.println("Password: ");
        String employeePassword = input.next();
        input.close();
        StringBuilder errorMessage = new StringBuilder();

        if (_employeeManager.createEmployee(employeeFirstName, employeeLastName, employeeNationalCode, employeeGender,
                employeePhoneNumber, employeeAddress, role.bankEmployee, employeeSalary, employeeEmail, 1, new Date(),
                employeePassword, errorMessage)) {
            System.out.println("Employee successfully created!");
        } else {
            System.out.println(errorMessage);
        }
    }

    private static void manager_AddClient() {
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("First name: ");
        String clientFirstName = input.next();
        System.out.println("Last Name: ");
        String clientLastName = input.next();
        System.out.println("Gender: ");
        String clientGender = input.next();
        System.out.println("Phone number: ");
        String clientPhoneNumber = input.next();
        System.out.println("Address: ");
        String clientAddress = input.next();
        System.out.println("Email: ");
        String clientEmail = input.next();
        System.out.println("National Code: ");
        String clientNationalCode = input.next();
        System.out.println("Password: ");
        String clientPassword = input.next();
        input.close();

        StringBuilder errorMessage = new StringBuilder();
        if (_clientManager.create(clientFirstName, clientLastName, clientGender, clientPhoneNumber, clientAddress,
                clientEmail, 1, new Date(), clientNationalCode, clientPassword, errorMessage)) {
            System.out.println("Client successfully created!");
        } else {
            System.out.println(errorMessage);
        }
    }

    private static void manager_AddAccount() {
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("Client Id: ");
        int clientId = input.nextInt();
        System.out.println("Initial amount: ");
        long initialAmount = input.nextByte();
        System.out.println("Type(Current / Deposit): ");
        String type = input.next();
        input.close();
        StringBuilder errorMessage = new StringBuilder();

        if (_accountManager.create(clientId, initialAmount, 1, type, errorMessage)) {
            System.out.println("Account successfully created!");
            return;
        } else {
            System.out.println(errorMessage);
            return;
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////// Client Actions /////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static void client_ShowActions() {
            clearScreen();
        Scanner input = new Scanner(System.in);

            System.out.println("Client panel");
            System.out.println("1. Create Account");
            System.out.println("2. Close account");
            System.out.println("3. Show account");
            System.out.println("4. Schedule");
            System.out.println("5. Transfer request");
            System.out.println("6. Show transactions of an account");
            String option1 = input.next();
            StringBuilder errorMessage = new StringBuilder();

            if(option1.equals("1")){
                clearScreen();
                System.out.println("Client Id: ");
                int clientId = input.nextInt();
                System.out.println("Initial amount: ");
                long initialAmount = input.nextByte();
                System.out.println("Type(Current / Deposit): ");
                String type = input.next();
                if(_accountManager.create(clientId, initialAmount, 1, type, errorMessage)){
                    System.out.println("Account successfully created!");
                    return;
                }
                else {
                    System.out.println(errorMessage);
                    return;
                }
            }
            if(option1.equals("2")){
                clearScreen();
                System.out.println("Account number: ");
                int accountNumber = Integer.parseInt(input.next());
                if(_accountManager.delete(accountNumber, errorMessage)){
                    System.out.println("Account successfully deleted");
                    return;
                }
                else {
                    System.out.println(errorMessage);
                    return;
                }
            }
            if(option1.equals("3")){
                clearScreen();
                System.out.println("Id: ");
                int Id = Integer.parseInt(input.next());
                for(Account item : _accountManager.getAll()){
                    if(item.getClientId() == Id){
                        System.out.println(item.toString());
                        return;
                    }
                    else {
                        System.out.println("Id not found");
                        return;
                    }
                }
            }
            if(option1.equals("4")){
                clearScreen();
                System.out.println("Enter your account Number: ");
                int sourceAccountNumber = Integer.parseInt(input.next());
                System.out.println("Enter your target account numbers: ");
                ArrayList<Integer> targetAccountNumbers = new ArrayList<>();
                targetAccountNumbers.add(Integer.parseInt(input.next()));
            }
            if(option1.equals("5")){
                clearScreen();
                if(_transactionRequestManager.createTransactionRequest()){
                    System.out.println("Request successfully submitted");
                    return;
                }
                else {
                    System.out.println("Request not registered");
                    return;
                }
            }
            if(option1.equals("6")){
                clearScreen();
                _transactionManager.getAll();
            }
    }
}// end of class