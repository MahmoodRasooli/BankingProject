package banking.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import banking.model.Account;
import banking.model.Client;
import banking.model.Employee;
import banking.model.role;

public class EmployeeManager
{
    private static ArrayList<Employee> _repository = new ArrayList<>();
    private final ClientManager _clientManager;

    public static void fillRepository(ArrayList<Employee> repository) { _repository = repository; }

    public EmployeeManager() {
        super();
        _clientManager = new ClientManager();
    }

    public boolean createEmployee(String firstName, String lastName, String gender, String phoneNumber, String address,
                                  role role , long salary , String email, int createrUser, Date birthdate, String password, StringBuilder errorMessage)
    {
        Employee employee = new Employee();
        employee.setAddress(address);
        employee.setBirthdate(birthdate);
        employee.setCreateDate(new Date());
        employee.setCreaterUser(createrUser);
        employee.setEmail(email);
        employee.setFirstName(firstName);
        employee.setGender(gender);
        employee.setIsDeleted(false);
        employee.setLastName(lastName);
        employee.setPassword(password);
        employee.setPhoneNumber(phoneNumber);
        employee.setId(getNewEmployeeId());
        employee.setSalary(salary);
        employee.setEmployeeCode(UUID.randomUUID().toString().toLowerCase());
        employee.setRole(role);

        if (!validateEmployeeCreation(employee, errorMessage))
            return false;

        _repository.add(employee);

        if(!FileManager.writeToFile(_repository, EntityType.Employee, errorMessage)) {
            _repository.remove(employee);
            return false;
        }

        return true;
    }

    public boolean update(String firstName, String lastName, String gender, String phoneNumber, String address,
                          String email, Date birthdate, String nationalCode, String password, long salary) {
        return true;
    }

    public ArrayList<Employee> getAll() { return _repository; }

    // Find an employee by Id
    public Employee find(int employeeId) {

        for(Employee item : _repository) {
            if(item.getId() == employeeId){
                return item;
            }
        }

        return null;
    }

    // Checks if the given employeeId is valid
    public boolean checkIfEmployeeIsValid(int employeeId, StringBuilder errorMessage) {
        
        Employee employee = find(employeeId);
        if(employee == null || employee.getIsDeleted()) {
            errorMessage.append("Employee does not exist.");
            return false;
        }
        
        return true;
    }

    public boolean validateEmployeeCreation(Employee employee, StringBuilder errorMessage) {
        // Checks if account number already exists
        if (find(employee.getId()) != null) {
            errorMessage.append("Duplicate Id.");
            return false;
        }

        return true;
    }

    public static int getNewEmployeeId() {
        int maxEmployeeId = 0;

        for (Employee item : _repository) {
            if (item.getId() > maxEmployeeId)
                maxEmployeeId = item.getId();
        }

        return maxEmployeeId + 1;
    }

    public boolean deleteClient(role role, int Id, StringBuilder errorMessage) {
        if (role == banking.model.role.bankManager) {
            if (!_clientManager.checkIfClientIsValid(Id, errorMessage))
                return false;

            Client client = _clientManager.find(Id);
            client.setIsDeleted(true);

            if (!FileManager.writeToFile(_repository, EntityType.Client, errorMessage))
                return false;

            return true;
        }
        return false;
    }
}