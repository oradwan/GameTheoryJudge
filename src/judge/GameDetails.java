package judge;


public class GameDetails implements IGameDetails{
    private final int n;

    public GameDetails(int n) {
        this.n = n;
    }

    @Override
    public int getN() {
        return n;
    }
}
