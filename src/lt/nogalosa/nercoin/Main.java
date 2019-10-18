package lt.nogalosa.nercoin;

import lt.nogalosa.nercoin.managers.UserManager;

public class Main {

    public Main() {

        UserManager.i().generateUsers();


    }

    public static void main(String[] args) {
        new Main();
    }
}
