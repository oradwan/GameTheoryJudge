package judge;


public class GameDetails implements IGameDetails{
    private final int n;
    private final boolean notify;

    public GameDetails(int n, boolean notify) {
        this.n = n;
        this.notify = notify;
    }

    @Override
    public int getN() {
        return n;
    }

    @Override
    public boolean isNotifying() {
        return notify;
    }
}
