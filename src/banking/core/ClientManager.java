package banking.core;

import java.util.ArrayList;
import java.util.List;
import banking.model.Client;

public class ClientManager {
    private static List<Client> _repository = new ArrayList<Client>();   

    public ClientManager() {
        super();
    }

    public static void fillRepository(List<Client> repository) {
        _repository = repository;
    }
}