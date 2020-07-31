package banking.core;

import java.util.ArrayList;
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

    public void search(int Id)
    {
        Client foundedClient = find(Id);

    }

    public ArrayList<Client> getAll()
    {
        return _repository;
    }

    // Find a client by Id
    public Client find(int id) {

        for(Client item : _repository) {
            if(item.getId() == id){
                return item;
            }
        }
        
        return null;
    }

    public boolean checkIfClientIsValid(int clientId, StringBuilder errorMessage) {
        Client client = find(clientId);
        
        if(client == null || client.getIsDeleted()) {
            errorMessage.append("Client does not exist.");
            return false;
        }
        
        return true;
    }
}