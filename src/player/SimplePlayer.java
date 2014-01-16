package player;

import judge.IGameDetails;

public class SimplePlayer implements IPlayer{
    @Override
    public int getBid(IGameDetails details) {
        return 1 + (int)(Math.random() * details.getN());
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
        return "SimplePlayer";
    }
}
