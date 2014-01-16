package player;

import judge.IGameDetails;

public class SimpleNotifiedPlayer implements IPlayer {
    private int totalEnemyBids = 0;
    private int totalEnemyNBids = 0;
    private int totalEnemyNMinusOneBids = 0;

    private int n;

    @Override
    public int getBid(IGameDetails details) {
        n = details.getN();
        if(totalEnemyBids == 0)
            return n;
        if ((totalEnemyNBids/totalEnemyBids) >= 0.5)
            return (n-1);
        else if((totalEnemyNMinusOneBids/totalEnemyBids) >= 0.5)
            return (n-2);
        return n;
    }

    private void handleBid(int opponentBid){
        totalEnemyBids++;
        if(opponentBid == n)
            totalEnemyNBids++;
        if(opponentBid == (n-1))
            totalEnemyNMinusOneBids++;

    }


    @Override
    public void handleLoss(int opponentBid) {
        handleBid(opponentBid);

    }

    @Override
    public void handleDraw(int opponentBid) {
        handleBid(opponentBid);
    }

    @Override
    public void handleWin(int opponentBid) {
        handleBid(opponentBid);
    }

    @Override
    public String getStrategyName() {
        return "SimpleNotifier";
    }
}
