package banking.model;

public final class Employee extends Person
{
    private int salary;
    private String password;
    private role role;
    private String employeeCode;

    public String getEmployeeId() { return employeeCode; }

    public void setEmployeeId(String employeeCode) { this.employeeCode = employeeCode; }

    public banking.model.role getRole() { return role; }

    public void setRole(banking.model.role role) { this.role = role; }

    public int getSalary() { return salary; }

    public void setSalary(int salary) { this.salary = salary; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
