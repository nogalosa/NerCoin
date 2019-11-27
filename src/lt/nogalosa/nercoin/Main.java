package lt.nogalosa.nercoin;

import lt.nogalosa.nercoin.entities.Block;
import lt.nogalosa.nercoin.entities.Miner;
import lt.nogalosa.nercoin.entities.Transaction;
import lt.nogalosa.nercoin.hash.NerHash;
import lt.nogalosa.nercoin.managers.TransactionManager;
import lt.nogalosa.nercoin.managers.UserManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {

    private Random random = new Random();

    public Main() {

        UserManager.i().generateUsers();
        ArrayList<Transaction> randomTransactions = TransactionManager.generateRandomTransactions(UserManager.i().getUsers());
        ArrayList<Block> blocks = new ArrayList<>();

        for (int x = 0; x < 5; x++) {
            Block block = new Block();
            for (int i = 0; i < 100; i++) {
                Transaction transaction = randomTransactions.get(random.nextInt(randomTransactions.size()));
                block.getTransactionManager().addTransaction(transaction);
            }

            Iterator<Transaction> transactionIterator = block.getTransactionManager().getTransactions().iterator();
            while (transactionIterator.hasNext()) {
                Transaction transaction = transactionIterator.next();
                if (transaction.getFromUser().getBalance() < transaction.getAmount()) {
                    block.getTransactionManager().removeTransaction(transaction);
                    System.out.println("Removing " + transaction.getHash() + " #1");
                }

                NerHash nerHash = new NerHash(transaction.getFromUser().getPublicKey() + transaction.getToUser().getPublicKey() + transaction.getAmount() + transaction.getTimestamp());
                if (!nerHash.hash().equals(transaction.getHash())) {
                    block.getTransactionManager().removeTransaction(transaction);
                    System.out.println("Removing " + transaction.getHash() + " #2");
                }
            }

            block.setDifficulityTarget("2");
            block.generateMerkelTreeHash();
            blocks.add(block);
        }
        System.out.println("Starting miner with "+blocks.size() + " blocks.");
        Miner blockMiner = new Miner(blocks);
        blockMiner.start();

    }

    public static void main(String[] args) {
        System.out.println("0123456789".compareTo("Jonas"));
        new Main();
    }
}
