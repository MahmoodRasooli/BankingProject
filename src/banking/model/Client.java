package banking.model;

public final class Client extends Person
{
    private String password;
    String clientCode;

    public String getClientCode() { return clientCode; }

    public void setClientCode(String clientCode) { this.clientCode = clientCode; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Client{" +
                "Id=" + getId() +
                ", nationalCode='" + getNationalCode() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", birthdate=" + getBirthdate() +
                ", isDeleted=" + getIsDeleted() +
                '}';
    }
}