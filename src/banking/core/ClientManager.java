package banking.core;

import java.util.ArrayList;
import java.util.List;
import banking.model.Client;

public class ClientManager
{
    private static ArrayList<Client> _repository = new ArrayList<Client>();

    public ClientManager()
    {
        super();
    }

    public static void fillRepository(ArrayList<Client> repository)
    {
        _repository = repository;
    }

    public void updateClient()
    {

    }

    public void search()
    {

    }

    public ArrayList<Client> getAll()
    {
        return _repository;
    }

    public void query()
    {

    }
}
