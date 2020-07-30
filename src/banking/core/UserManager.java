package banking.core;

import java.util.ArrayList;

public class UserManager
{
    private static ArrayList<UserManager> _repository = new ArrayList<>();

    public static void fillRepository(ArrayList<UserManager> repository) { _repository = repository; }

    public UserManager() { super(); }
}
