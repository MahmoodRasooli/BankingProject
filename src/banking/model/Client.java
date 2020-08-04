package banking.model;

public final class Client extends Person
{
    private String password;
    String clientCode;

    public String getClientCode() { return clientCode; }

    public void setClientCode(String clientCode) { this.clientCode = clientCode; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}