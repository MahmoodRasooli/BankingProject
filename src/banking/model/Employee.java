package banking.model;

public final class Employee extends Person
{
    private long salary;
    private String password;
    private role role;
    private String employeeCode;

    public String getEmployeeCode() { return employeeCode; }

    public void setEmployeeCode(String employeeCode) { this.employeeCode = employeeCode; }

    public banking.model.role getRole() { return role; }

    public void setRole(banking.model.role role) { this.role = role; }

    public long getSalary() { return salary; }

    public void setSalary(long salary) { this.salary = salary; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
