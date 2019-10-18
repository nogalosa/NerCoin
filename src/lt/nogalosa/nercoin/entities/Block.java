package lt.nogalosa.nercoin.entities;

import java.util.ArrayList;

public class Block {

    private String prevBlockHash;
    private long timestamp;
    private int version;
    private String merkelRootHash;
    private int nonce;
    private int difficulityTarget;
    private ArrayList<Transaction> transactions = new ArrayList<>();
}
