package lt.nogalosa.nercoin.entities;

import java.util.ArrayList;

public class Miner extends Thread{

    ArrayList<Block> blocks;

    ArrayList<Block> mined;

    public Miner(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public void run() {
        int currentTries = 1;
        int currentBlock = 0;
        long lastTimestamp = System.currentTimeMillis();

        while(blocks.size() > 0) {
            if(lastTimestamp + currentTries * 1000 < System.currentTimeMillis() || currentBlock >= blocks.size()){
                currentBlock++;
                if(currentBlock >= blocks.size()) {
                    currentBlock = 0;
                    currentTries++;
                }
                lastTimestamp = System.currentTimeMillis();
            }
            if(blocks.get(currentBlock).getHash().compareTo(blocks.get(currentBlock).getDifficulityTarget()) > 0){
                blocks.get(currentBlock).incrementNonce();
                System.out.println(currentBlock + " > " + blocks.get(currentBlock).getHash() + " > " + blocks.get(currentBlock).getNonce());
            } else {
                System.out.println("Mined: "+blocks.get(currentBlock).getHash());
                mined.add(blocks.get(currentBlock));
                blocks.remove(currentBlock);
            }
        }
        System.out.println("Success!");
    }
}
