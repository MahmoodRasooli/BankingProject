package banking.core;

import java.util.ArrayList;
import java.util.Date;

import banking.model.Client;
import banking.model.Employee;
import java.util.UUID;

public class ClientManager {
    private static ArrayList<Client> _repository = new ArrayList<Client>();
    private final EmployeeManager _employeeManager;

    public ClientManager() {
        super();

        _employeeManager = new EmployeeManager();
    }

    public static void fillRepository(ArrayList<Client> repository) {
        _repository = repository;
    }

    // Returns a list which contains all the clients
    public ArrayList<Client> getAll() {
        return new ArrayList<Client>(_repository);
    }

    // Find a client by Id
    public Client find(int id) {

        for (Client item : _repository) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    public Client findByNationalCode(String nationalCode) {

        for (Client item : _repository) {
            if (item.getNationalCode() == nationalCode) {
                return item;
            }
        }

        return null;
    }

    public boolean create(String firstName, String lastName, String gender, String phoneNumber, String address,
            String email, int createrUser, Date birthdate, String nationalCode, String password, StringBuilder errorMessage) {

        Client client = new Client();
        client.setAddress(address);
        client.setBirthdate(birthdate);
        client.setCreateDate(new Date());
        client.setCreaterUser(createrUser);
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setGender(gender);
        client.setIsDeleted(false);
        client.setLastName(lastName);
        client.setPassword(password);
        client.setPhoneNumber(phoneNumber);
        client.setId(getNewClientId());
        client.setNationalCode(nationalCode);
        client.setClientCode(UUID.randomUUID().toString().toLowerCase());

        if (!validateClientCreation(client, errorMessage))
            return false;

        _repository.add(client);

        if(!FileManager.writeToFile(_repository, EntityType.Client, errorMessage)) {
            _repository.remove(client);
            return false;
        }

        return true;
    }

    public boolean update(String firstName, String lastName, String gender, String phoneNumber, String address,
            String email, Date birthdate, String nationalCode, String password) {
        return true;
    }

    // Checks the validity of a client
    public boolean checkIfClientIsValid(int clientId, StringBuilder errorMessage) {
        Client client = find(clientId);

        if (client == null || client.getIsDeleted()) {
            errorMessage.append("Client does not exist.");
            return false;
        }

        return true;
    }

    public boolean validateClientCreation(Client client, StringBuilder errorMessage) {
        // Checks if account number already exists
        if (find(client.getId()) != null) {
            errorMessage.append("Duplicate Id.");
            return false;
        }

        if (findByNationalCode(client.getNationalCode()) != null) {
            errorMessage.append("A client with this national code already exists.");
            return false;
        }

        return true;
    }

    public static int getNewClientId() {
        int maxClientId = 0;

        for (Client item : _repository) {
            if (item.getId() > maxClientId)
                maxClientId = item.getId();
        }

        return maxClientId + 1;
    }
}