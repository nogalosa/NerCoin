package lt.nogalosa.nercoin.entities;

import lt.nogalosa.nercoin.hash.NerHash;
import lt.nogalosa.nercoin.managers.TransactionManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Block {

    private String prevBlockHash;
    private long timestamp;
    private int version;
    private String merkelRootHash;
    private int nonce;
    private String difficulityTarget;
    private TransactionManager transactionManager;

    public Block() {
        transactionManager = new TransactionManager();
        timestamp = System.currentTimeMillis();
        version = 1;
        nonce = 0;
    }

    public String getPrevBlockHash() {
        return prevBlockHash;
    }

    public void setPrevBlockHash(String prevBlockHash) {
        this.prevBlockHash = prevBlockHash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getMerkelRootHash() {
        return merkelRootHash;
    }

    public void setMerkelRootHash(String merkelRootHash) {
        this.merkelRootHash = merkelRootHash;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public void incrementNonce() {
        this.nonce++;
    }

    public String getDifficulityTarget() {
        return difficulityTarget;
    }

    public void setDifficulityTarget(String difficulityTarget) {
        this.difficulityTarget = difficulityTarget;
    }

    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    public String getHash() {
        NerHash hash = new NerHash(prevBlockHash + timestamp + version + merkelRootHash + nonce + difficulityTarget);
        return hash.hash();
    }

    public String toString() {
        return getHash();
    }

    public String generateMerkelTreeHash() {
        ArrayList<Transaction> merkelTransactions = (ArrayList<Transaction>) getTransactionManager().getTransactions().clone();
        ArrayList<String> merkelHashes = new ArrayList<>();

        for(int i = 0; i < merkelTransactions.size() / 2; i++){
            Transaction t1 = merkelTransactions.get(i);
            Transaction t2 = merkelTransactions.get(i + 1);
            NerHash hash = new NerHash(t1.getHash() + t2.getHash());
            merkelHashes.add(hash.hash());
        }

        while(merkelHashes.size() > 1) {
            for(int i = 0; i < merkelHashes.size() / 2; i++) {
                String h1 = merkelHashes.get(i);
                String h2 = merkelHashes.get(i + 1);
                NerHash hash = new NerHash(h1 + h2);
                merkelHashes.set(i, hash.hash());
                merkelHashes.remove(i + 1);
            }
        }

        NerHash hash = new NerHash(merkelHashes.get(0));
        setMerkelRootHash(hash.hash());
        return getMerkelRootHash();
    }
}
