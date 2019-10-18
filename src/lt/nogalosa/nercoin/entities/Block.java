package lt.nogalosa.nercoin.entities;

import lt.nogalosa.nercoin.managers.TransactionManager;

import java.util.ArrayList;

public class Block {

    private String prevBlockHash;
    private long timestamp;
    private int version;
    private String merkelRootHash;
    private int nonce;
    private int difficulityTarget;
    private TransactionManager transactionManager;

    public Block() {
        transactionManager = new TransactionManager();
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

    public int getDifficulityTarget() {
        return difficulityTarget;
    }

    public void setDifficulityTarget(int difficulityTarget) {
        this.difficulityTarget = difficulityTarget;
    }

    public TransactionManager getTransactionManager() {
        return transactionManager;
    }
}
