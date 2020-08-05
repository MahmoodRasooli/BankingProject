package banking.core;

import banking.model.Account;
import banking.model.Client;
import banking.model.Employee;
import banking.model.role;

import java.util.*;
import java.util.stream.Collectors;

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
    public ArrayList<Client> getAll() { return new ArrayList<Client>(_repository); }

    public ArrayList<Client> sortByFirstNameAndLastName() {

        ArrayList<Client> sortedRepository = new ArrayList<>(_repository);
        sortedRepository.sort(new Comparator<Client>() {
            @Override
            public int compare(final Client lhs, Client rhs) {
                if (lhs.getFirstName().compareTo(rhs.getFirstName()) == 0) {
                    return lhs.getLastName().compareTo(rhs.getLastName());
                } else {
                    return lhs.getFirstName().compareTo(rhs.getFirstName());
                }
            }
        });

        return sortedRepository;
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

    // Find a client by national code
    public Client findByNationalCode(String nationalCode) {

        for (Client item : _repository) {
            if (item.getNationalCode().equals(nationalCode)) {
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

    public boolean update(int Id, String firstName, String lastName, String gender, String phoneNumber, String address,
            String email, Date birthdate, String nationalCode, String password, StringBuilder errorMessage) {
        if (!checkIfClientIsValid(Id, errorMessage))
            return false;

        Client client = find(Id);

        client.setAddress(address);
        client.setBirthdate(birthdate);
        client.setCreateDate(new Date());
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setGender(gender);
        client.setIsDeleted(false);
        client.setLastName(lastName);
        client.setPassword(password);
        client.setPhoneNumber(phoneNumber);
        client.setId(getNewClientId());
        client.setNationalCode(nationalCode);

        if (!FileManager.writeToFile(_repository, EntityType.Client, errorMessage))
            return false;

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

    public Client login(String nationalCode, String password, StringBuilder errorMessage){
        Client client = findByNationalCode(nationalCode);

        if(client == null || !client.getPassword().equals(password) || client.getIsDeleted()) {
            errorMessage.append("Username or password is incorrect");
            return null;
        }
        
        return client;
    }

    public boolean deleteClient(role role, int Id, StringBuilder errorMessage) {
        if (role == banking.model.role.bankManager) {
            if (!checkIfClientIsValid(Id, errorMessage))
                return false;

            Client client = find(Id);
            client.setIsDeleted(true);

            if (!FileManager.writeToFile(_repository, EntityType.Client, errorMessage))
                return false;

            return true;
        }
        return false;
    }
}