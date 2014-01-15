package player;

import judge.IGameDetails;

/**
 * Created by csuchanec on 1/14/14.
 */
public class WeightedPlayer extends SimplePlayer {
    private final int range = 2;
    private int totalCount;
    private int[] values;
    private int minusTwoWeight;
    private int minusOneWeight;
    private int nWeight;

    public WeightedPlayer(int minusTwoWeight, int minusOneWeight, int nWeight) {
        this.minusTwoWeight = minusTwoWeight;
        this.minusOneWeight = minusOneWeight;
        this.nWeight = nWeight;
        totalCount = minusTwoWeight + minusOneWeight + nWeight;
        values = new int[totalCount];
        int indexer = 0;
        for(int i =0; i < minusTwoWeight; i++){
            values[indexer++] = 2;
        }

        for(int i =0; i < minusOneWeight; i++){
            values[indexer++] = 1;
        }

        for(int i =0; i < nWeight; i++){
            values[indexer++] = 0;
        }
    }

    @Override
    public int getBid(IGameDetails details) {

        int offset = values[(int)(Math.random() * totalCount)];
        int max = details.getN();
        return max - range + offset;
    }

    @Override
    public String getStrategyName() {
        return "Weighted {" + minusTwoWeight +", "+ minusOneWeight + ", " + nWeight + "}";
    }
}
