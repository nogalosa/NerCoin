package lt.nogalosa.nercoin.managers;

import lt.nogalosa.nercoin.entities.User;

import java.util.ArrayList;

public class UserManager {

    private static UserManager instance;

    private ArrayList<User> users = new ArrayList<>();

    public static UserManager i() {
        if(instance == null)
            instance = new UserManager();
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void generateUsers() {

    }
}
