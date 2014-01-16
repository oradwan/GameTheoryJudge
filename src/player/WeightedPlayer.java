package player;

import judge.IGameDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csuchanec on 1/14/14.
 */
public class WeightedPlayer extends SimplePlayer {
    private final int range = 2;
    private int totalCount;
    protected ArrayList<Integer> values;
    protected int minusTwoWeight;
    protected int minusOneWeight;
    protected int nWeight;
    protected int lastBid;

    public WeightedPlayer(int minusTwoWeight, int minusOneWeight, int nWeight) {
        this.minusTwoWeight = minusTwoWeight;
        this.minusOneWeight = minusOneWeight;
        this.nWeight = nWeight;
        totalCount = minusTwoWeight + minusOneWeight + nWeight;
        values = new ArrayList<Integer>(totalCount);
        int indexer = 0;
        for(int i =0; i < minusTwoWeight; i++){
            values.add(indexer++, 2);
        }

        for(int i =0; i < minusOneWeight; i++){
            values.add(indexer++, 1);
        }

        for(int i =0; i < nWeight; i++){
            values.add(indexer++, 0);
        }
    }

    @Override
    public int getBid(IGameDetails details) {

        int offset = values.get((int)(Math.random() * totalCount));
        int max = details.getN();
        lastBid = max - range + offset;
        return  lastBid;
    }

    @Override
    public String getStrategyName() {
        return "Weighted {" + minusTwoWeight +", "+ minusOneWeight + ", " + nWeight + "}";
    }
}
