package lt.nogalosa.nercoin.entities;

import lt.nogalosa.nercoin.hash.NerHash;

public class Transaction {
    private User fromUser;
    private User toUser;
    private int amount;
    private String hash;
    private long timestamp;

    public Transaction(User fromUser, User toUser, int amount) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
        NerHash nerHash = new NerHash(fromUser.getPublicKey()+toUser.getPublicKey()+amount+timestamp);
        this.hash = nerHash.hash();
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
