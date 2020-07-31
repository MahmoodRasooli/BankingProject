package banking.model;

public final class Client extends Person
{
    private String password;
    private String clientCode;

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getClientCode() { return clientCode; }

    public void setClientCode(String clientCode) { this.clientCode = clientCode; }

}