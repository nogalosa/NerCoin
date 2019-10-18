package lt.nogalosa.nercoin.managers;

import lt.nogalosa.nercoin.entities.User;
import lt.nogalosa.nercoin.utils.StringUtils;

import java.util.ArrayList;
import java.util.Random;

public class UserManager {

    private static UserManager instance;

    private Random random;
    private ArrayList<User> users;

    public UserManager() {
        random = new Random();
        users = new ArrayList<>();
    }

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
        for(int i = 0; i < 1000; i++) {
            User user = new User("User"+i, StringUtils.generateRandomHash(), random.nextInt(1000000 - 100) + 100);
            addUser(user);
        }
    }
}
