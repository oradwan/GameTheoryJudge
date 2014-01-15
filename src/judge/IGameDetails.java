package judge;

public interface IGameDetails {
    //guarantees the game is being played from numbers 1 to N.
    public int getN();

    //Is the judge notifying you of your win/loss/draw?
    public boolean isNotifying();
}
