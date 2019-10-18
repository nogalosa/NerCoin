package lt.nogalosa.nercoin.entities;

public class Miner extends Thread{

    Block block;

    public Miner(Block block) {
        this.block = block;
    }

    @Override
    public void run() {
        while(block.getHash().compareTo(block.getDifficulityTarget()) > 0) {
            block.incrementNonce();
            System.out.println(block.getHash() + " > " + block.getNonce());
        }
        System.out.println("Success!");
    }
}
