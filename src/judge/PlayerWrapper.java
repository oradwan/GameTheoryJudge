package judge;

import player.IPlayer;

public class PlayerWrapper implements IPlayer {
    private final IPlayer innerPlayer;

    private final boolean notify;

    public PlayerWrapper(IPlayer innerPlayer, boolean notify) {
        this.innerPlayer = innerPlayer;
        this.notify = notify;
    }

    @Override
    public int getBid(IGameDetails details) {
        return innerPlayer.getBid(details);
    }

    @Override
    public void handleLoss(int opponentBid) {
        if (notify) {
            innerPlayer.handleLoss(opponentBid);
        }
    }

    @Override
    public void handleDraw() {
        if (notify) {
            innerPlayer.handleDraw();
        }
    }

    @Override
    public void handleWin(int opponentBid) {
        if (notify) {
            innerPlayer.handleWin(opponentBid);
        }
    }

    @Override
    public String getStrategyName() {
        return innerPlayer.getStrategyName();
    }
}
