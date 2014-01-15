package player;


import judge.IGameDetails;

public interface IPlayer {
    //Implement this. When you're asked, "What is your choice from 1 to N" - this is what you need to reply
    public int getBid(IGameDetails details);

    //These methods _MAY_ be called by the judge after each game.
    //but due to game settings, these things might not get called, so be robust to that.
    //the game details can explain whether you'll be notified or not (passed into getBid).
    public void handleLoss(int opponentBid);
    public void handleDraw();
    public void handleWin(int opponentBid);

     //name your strategy
    public String getStrategyName();
}
