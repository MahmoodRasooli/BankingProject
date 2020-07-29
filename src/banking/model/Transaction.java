package banking.model;

public class Transaction
{
    Account account = new Account();

    public void deposit(int deposit)
    {
        account.setBalance(account.getBalance() + deposit);
    }

    public void withdraw(int withdraw)
    {
        if(withdraw > account.getBalance())
            System.out.println("Not enough inventory to perform tansaction");

        account.setBalance(account.getBalance() - withdraw);
    }

    public void transfer(int trasnfer, int accountNumber)
    {

    }
}
