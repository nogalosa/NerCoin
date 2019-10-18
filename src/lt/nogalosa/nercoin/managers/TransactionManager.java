package lt.nogalosa.nercoin.managers;

import lt.nogalosa.nercoin.entities.Transaction;

import java.util.ArrayList;

public class TransactionManager {

    private static TransactionManager instance;
    private ArrayList<Transaction> transactions;

    public static TransactionManager i() {
        if(instance == null)
            instance = new TransactionManager();
        return instance;
    }

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
}
