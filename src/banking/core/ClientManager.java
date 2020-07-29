package banking.core;

<<<<<<< HEAD
public class ClientManager
{

}
=======
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
>>>>>>> 591f26a2cf66f22b0e3b1d6c7d1976b138e893db
