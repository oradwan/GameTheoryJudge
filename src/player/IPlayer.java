package player;


import judge.IGameDetails;

public interface IPlayer {
    //Implement this. When you're asked, "What is your choice from 1 to N" - this is what you need to reply
    public int getBid(IGameDetails details);

    //these will be called by the judge after each trial
    public void handleLoss(int opponentBid);
    public void handleDraw();
    public void handleWin(int opponentBid);

    public String getStrategyName();
}
