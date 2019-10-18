package lt.nogalosa.nercoin;

import lt.nogalosa.nercoin.entities.Block;
import lt.nogalosa.nercoin.entities.Transaction;
import lt.nogalosa.nercoin.managers.TransactionManager;
import lt.nogalosa.nercoin.managers.UserManager;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private Random random = new Random();

    public Main() {

        UserManager.i().generateUsers();
        ArrayList<Transaction> randomTransactions = TransactionManager.generateRandomTransactions(UserManager.i().getUsers());

        Block block = new Block();
        for(int i = 0; i < 100; i++) {
            Transaction transaction = randomTransactions.get(random.nextInt(randomTransactions.size()));
            block.getTransactionManager().addTransaction(transaction);
        }

    }

    public static void main(String[] args) {
        System.out.println("0123456789".compareTo("Jonas"));
        new Main();
    }
}
