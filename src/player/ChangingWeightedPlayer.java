package player;

/**
 * Created by csuchanec on 1/15/14.
 */
public class ChangingWeightedPlayer extends WeightedPlayer {
    public ChangingWeightedPlayer(int minusTwoWeight, int minusOneWeight, int nWeight) {
        super(minusTwoWeight, minusOneWeight, nWeight);
    }

    @Override
    public void handleLoss(int opponentBid) {

        int indexToChange =  values.indexOf(lastBid);
        if(indexToChange != -1){
            values.set(indexToChange, opponentBid);
        }else{
            values.add(opponentBid);
        }
    }

    @Override
    public void handleDraw() {
    }

    @Override
    public void handleWin(int opponentBid) {
        values.add(lastBid);
    }

    @Override
    public String getStrategyName() {
        return "Changing Weighted {" + minusTwoWeight +", "+ minusOneWeight + ", " + nWeight + "}";
    }
}
