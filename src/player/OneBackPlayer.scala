package player

import judge.IGameDetails
import scala.collection.mutable

/**
 * Created by jaety on 1/15/14.
 *
 * P(OppBid_i | Bid_{i-1})
 */
class Counts() {
  private var lastBid = 3
  // Prior Bid, Opponent Bid -> Count
  private val counts = (0 to 3).map( _ => (0 to 3).map(_ => 4.0).toArray )
  private var total = counts.flatten.sum
  def mappedBid(bid: Int, N: Int) = (bid - N + 3).max(0)

  def recordRound(opponentBid: Int, N: Int) {
    counts(lastBid)(mappedBid(opponentBid, N)) += 1.0
    total += 1.0
  }

  def bidGivenOpponent(expOpponent: Int, N: Int) = expOpponent match {
    case 0 => N
    case 1 => N
    case 2 => N-2
    case 3 => N-1
  }

  def nextBid(N : Int) = {
    val predictedOpp = counts(lastBid).zipWithIndex.maxBy(_._1)._2
    val bid = bidGivenOpponent(predictedOpp, N)
    lastBid = mappedBid(bid,N)
    bid
  }



}

class OneBackPlayer extends IPlayer {
  val counts = new Counts()
  private var N : Int = -1

  def getBid(details: IGameDetails) = {
    if (N == -1) N = details.getN()
    counts.nextBid(N)
  }

  def handleLoss(opponentBid: Int) {
    counts.recordRound(opponentBid, N)
  }

  def handleDraw(opponentBid: Int) {
    counts.recordRound(opponentBid, N)
  }

  def handleWin(opponentBid: Int) {
    counts.recordRound(opponentBid, N)
  }

  def getStrategyName = this.getClass.getName
}
