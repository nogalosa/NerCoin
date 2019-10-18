package lt.nogalosa.nercoin.entities;

public class User {
    private String name;
    private String publicKey;
    private int balance;

    public User(String name, String publicKey, int balance) {
        this.name = name;
        this.publicKey = publicKey;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
