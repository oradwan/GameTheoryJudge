package judge;

import player.IPlayer;
import player.SimplePlayer;

public class Judge {
    private boolean NOTIFY = true;

    private IPlayer playerOne = new PlayerWrapper(new SimplePlayer(), NOTIFY);
    private IPlayer playerTwo = new PlayerWrapper(new SimplePlayer(), NOTIFY);

    private static final int NUM_TRIALS = 10000;
    private static final int N = 100;

    private final IGameDetails details = new GameDetails(N, NOTIFY);

    private static final int WIN_VALUE = 1;
    private static final int LOSS_VALUE = -1;
    private static final int DRAW_VALUE = 0;

    private int playerOneScore = 0, playerTwoScore = 0;

    public static void main(String[] args){
        new Judge();
    }

    public Judge(){
        for(int i = 0; i < NUM_TRIALS; i++){
            conductTrial();
        }
        System.out.println("End of trials. Conducted " + NUM_TRIALS + " runs");
        System.out.println(playerOne.getStrategyName() + ": " + playerOneScore);
        System.out.println(playerTwo.getStrategyName() + ": " + playerTwoScore);
    }

    private void conductTrial() {
        int bidOne = playerOne.getBid(details);
        int bidTwo = playerTwo.getBid(details);
        //cheating
        if (bidOne < 1 || bidOne > N) {
            playerOneScore += LOSS_VALUE;
        }
        if (bidTwo < 1 || bidTwo > N) {
            playerTwoScore += LOSS_VALUE;
        }

        //game rules
        if (bidOne == bidTwo) {
            playerOneScore += DRAW_VALUE;
            playerOne.handleDraw();
            playerTwoScore += DRAW_VALUE;
            playerTwo.handleDraw();
        } else if (bidOne + 1 == bidTwo) {
            playerOneScore += WIN_VALUE;
            playerOne.handleWin(bidTwo);
            playerTwoScore += LOSS_VALUE;
            playerTwo.handleLoss(bidOne);
        } else if (bidTwo + 1 == bidOne) {
            playerOneScore += LOSS_VALUE;
            playerOne.handleLoss(bidTwo);
            playerTwoScore += WIN_VALUE;
            playerTwo.handleWin(bidOne);
        } else if (bidOne > bidTwo) {
            playerOneScore += WIN_VALUE;
            playerOne.handleWin(bidTwo);
            playerTwoScore += LOSS_VALUE;
            playerTwo.handleLoss(bidOne);
        } else {
            playerOneScore += LOSS_VALUE;
            playerOne.handleWin(bidTwo);
            playerTwoScore += WIN_VALUE;
            playerTwo.handleWin(bidOne);
        }

    }


}
