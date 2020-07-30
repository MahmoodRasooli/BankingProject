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

    public void updateEmployee()
    {

    }

    public void search()
    {

    }

    public ArrayList<Employee> getAll()
    {
        return _repository;
    }

    public void query()
    {

    }
}
