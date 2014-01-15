package player;

import judge.IGameDetails;

/**
 * Created by csuchanec on 1/14/14.
 */
public class StaticPlayer implements IPlayer{
    @Override
    public int getBid(IGameDetails details) {
        return  details.getN();
    }

    @Override
    public void handleLoss(int opponentBid) {
    }

    @Override
    public void handleDraw(int opponentBid) {
    }

    @Override
    public void handleWin(int opponentBid) {
    }

    @Override
    public String getStrategyName() {
        return "StaticPlayer";
    }
}
