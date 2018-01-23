package sota.pow

/**
  * Curl
  *
  *
  * author: ahab94
  **/

sealed trait Mode

case object CURLP81 extends Mode

case object CURLP27 extends Mode

case object KERL extends Mode

object SpongeFactory {

  def create(mode: Mode): Option[SCurl] = mode match {
    case CURLP81 => None //return Scurl
    case CURLP27 => None //return Scurl
    case KERL => None //return Scurl
    case _ => None
  }

}


sealed trait ModeOpt

case class ModeObject(mode: Mode) extends ModeOpt

case class ModeWithPair(pair: Boolean, mode: Mode) extends ModeOpt

class SCurl(modeOpt: ModeOpt) extends Curl {

  /**
    * The hash length.
    */
  val HASH_LENGTH = 243
  private val STATE_LENGTH = 3 * HASH_LENGTH

  val NUMBER_OF_ROUNDSP81 = 81
  val NUMBER_OF_ROUNDSP27 = 27
  private var numberOfRounds = 0

  private val TRUTH_TABLE = List(1, 0, -1, 2, 1, -1, 0, 2, -1, 1, 0)
  private var stateLow: List[Long] = List()
  private var stateHigh: List[Long] = List()
  private val scratchpad: List[Int] = List(STATE_LENGTH)
  private var state: List[Int] = List()


  modeOpt match {
    case ModeObject(mode) =>
      import java.util.NoSuchElementException
      mode match {
        case CURLP27 => numberOfRounds = NUMBER_OF_ROUNDSP27
        case CURLP81 => numberOfRounds = NUMBER_OF_ROUNDSP81
        case _ => throw new NoSuchElementException("Only Curl-P-27 and Curl-P-81 are supported.")
      }
      state = List(STATE_LENGTH)
      stateHigh = null

    case ModeWithPair(pair, mode) =>
      import java.util.NoSuchElementException
      mode match {
        case CURLP27 => numberOfRounds = NUMBER_OF_ROUNDSP27
        case CURLP81 => numberOfRounds = NUMBER_OF_ROUNDSP81
        case _ => throw new NoSuchElementException("Only Curl-P-27 and Curl-P-81 are supported.")
      }
      if (pair) {
        stateHigh = List(STATE_LENGTH)
        stateLow = List(STATE_LENGTH)
        state = null
        //set
      }
      else {
        state = List(STATE_LENGTH)
        stateHigh = null
        stateLow = null
      }
  }

  /**
    * Absorbs the specified trits.
    *
    * @param trits  The trits.
    * @param offset The offset to start from.
    * @param length The length.
    * @return The Curl instance (used for method chaining).
    */
  override def absorb(trits: List[Int], offset: Int, length: Int): SCurl = ???

  /**
    * Absorbs the specified trits.
    *
    * @param trits The trits.
    * @return The Curl instance (used for method chaining).
    */
  override def absorb(trits: List[Int]): SCurl = ???

  /**
    * Squeezes the specified trits.
    *
    * @param trits  The trits.
    * @param offset The offset to start from.
    * @param length The length.
    * @return The squeezed trits.
    */
  override def squeeze(trits: List[Int], offset: Int, length: Int): List[Int] = ???

  /**
    * Squeezes the specified trits.
    *
    * @param trits The trits.
    * @return The squeezed trits.
    */
  override def squeeze(trits: List[Int]): List[Int] = ???

  /**
    * Transforms this instance.
    *
    * @return The Curl instance (used for method chaining).
    */
  override def transform: SCurl = ???

  /**
    * Resets this state.
    *
    * @return The Curl instance (used for method chaining).
    */
  override def reset: SCurl = ???

  /**
    * Gets or sets the state.
    *
    * @return The stae.
    */
  override def getState: List[Int] = ???

  /**
    * Sets or sets the state.
    *
    * @param state The state.
    */
  override def setState(state: List[Int]): Unit = ???
}
