package lt.nogalosa.nercoin.managers;

import lt.nogalosa.nercoin.entities.Transaction;
import lt.nogalosa.nercoin.entities.User;

import java.util.ArrayList;

public class TransactionManager {

    private ArrayList<Transaction> transactions;

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
    }
}
