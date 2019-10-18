package lt.nogalosa.nercoin;

import lt.nogalosa.nercoin.entities.Transaction;
import lt.nogalosa.nercoin.managers.TransactionManager;
import lt.nogalosa.nercoin.managers.UserManager;

import java.util.ArrayList;

public class Main {

    public Main() {

        UserManager.i().generateUsers();
        ArrayList<Transaction> randomTransactions = TransactionManager.generateRandomTransactions(UserManager.i().getUsers());


    }

    public static void main(String[] args) {
        new Main();
    }
}
