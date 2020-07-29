package banking.model;

import java.util.Date;

public class Account
{
    private int balance;
    private String type;
    private String accountHolder;
    private int accountNumber;
    private Date createDate;
    private int createUser;
    private boolean isDeleted;
    private AccountStatus status;

    public Date getCreateDate() { return createDate; }

    public void setCreateDate(Date createDate) { this.createDate = createDate; }

    public int getCreateUser() { return createUser; }

    public void setCreateUser(int createUser) { this.createUser = createUser; }

    public boolean isDeleted() { return isDeleted; }

    public void setDeleted(boolean deleted) { isDeleted = deleted; }

    public AccountStatus getStatus() { return status; }

    public void setStatus(AccountStatus status) { this.status = status; }

    public int getAccountNumber() { return accountNumber; }

    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }

    public int getBalance() { return balance; }

    public void setBalance(int balance) { this.balance = balance; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getAccountHolder() { return accountHolder; }

    public void setAccountHolder(String accountHolder) { this.accountHolder = accountHolder; }
}
