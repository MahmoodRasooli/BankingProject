package banking.model;

public class Employee
{
    private int salary;
    private String password;
    private role role;
    private int employeeId;

    public int getEmployeeId() { return employeeId; }

    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public banking.model.role getRole() { return role; }

    public void setRole(banking.model.role role) { this.role = role; }

    public int getSalary() { return salary; }

    public void setSalary(int salary) { this.salary = salary; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
