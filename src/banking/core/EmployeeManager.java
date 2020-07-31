package banking.core;

import java.util.ArrayList;
import banking.model.Employee;

public class EmployeeManager
{
    private static ArrayList<Employee> _repository = new ArrayList<>();

    public static void fillRepository(ArrayList<Employee> repository) { _repository = repository; }

    public EmployeeManager() { super(); }

    public void createEmployee()
    {

    }

    public void updateEmployee(int employeeId)
    {

    }

    public void search()
    {

    }

    public ArrayList<Employee> getAll()
    {
        return _repository;
    }

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
}