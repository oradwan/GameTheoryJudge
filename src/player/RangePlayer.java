package player;


import judge.IGameDetails;

public class RangePlayer extends SimplePlayer {
    private final int range;

    public RangePlayer(int range) {
        this.range = range;
    }

    @Override
    public int getBid(IGameDetails details) {
        int offset = (int)(Math.random() * range);
        int max = details.getN();
        return max - range + offset;
    }

    @Override
    public String getStrategyName() {
        return "RangePlayer {" + range + "}";
    }
}
