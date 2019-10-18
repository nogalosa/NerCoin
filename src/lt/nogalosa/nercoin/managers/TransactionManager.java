package lt.nogalosa.nercoin.managers;

import lt.nogalosa.nercoin.entities.Transaction;
import lt.nogalosa.nercoin.entities.User;

import java.util.ArrayList;
import java.util.Random;

public class TransactionManager {

    private ArrayList<Transaction> transactions;
    private static Random random = new Random();

    public TransactionManager() {
        transactions = new ArrayList<>();
    }


    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public static ArrayList<Transaction> generateRandomTransactions(ArrayList<User> users) {
        ArrayList<Transaction> randomTransactions = new ArrayList<>();

        for(int i = 0; i < 10000; i++){
            User from = users.get(random.nextInt(users.size()));
            User to = users.get(random.nextInt(users.size()));
            int amount = random.nextInt(1000);

            Transaction transaction = new Transaction(from,to,amount);
            randomTransactions.add(transaction);
        }

        return randomTransactions;
    }
}
