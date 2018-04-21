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
    case CURLP81 => None
    case CURLP27 => None
    case KERL => None
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

  private val TRUTH_TABLE = Array(1, 0, -1, 2, 1, -1, 0, 2, -1, 1, 0)
  private var stateLow: Array[Long] = Array()
  private var stateHigh: Array[Long] = Array()
  private val scratchpad: Array[Int] = Array(STATE_LENGTH)
  private var state: Array[Int] = Array()


  modeOpt match {
    case ModeObject(mode) =>
      import java.util.NoSuchElementException
      mode match {
        case CURLP27 => numberOfRounds = NUMBER_OF_ROUNDSP27
        case CURLP81 => numberOfRounds = NUMBER_OF_ROUNDSP81
        case _ => throw new NoSuchElementException("Only Curl-P-27 and Curl-P-81 are supported.")
      }
      state = Array(STATE_LENGTH)
      stateHigh = null

    case ModeWithPair(pair, mode) =>
      import java.util.NoSuchElementException
      mode match {
        case CURLP27 => numberOfRounds = NUMBER_OF_ROUNDSP27
        case CURLP81 => numberOfRounds = NUMBER_OF_ROUNDSP81
        case _ => throw new NoSuchElementException("Only Curl-P-27 and Curl-P-81 are supported.")
      }
      if (pair) {
        stateHigh = Array(STATE_LENGTH)
        stateLow = Array(STATE_LENGTH)
        state = null
        //set
      }
      else {
        state = Array(STATE_LENGTH)
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
  override def absorb(trits: Array[Int], offsetValue: Int, lengthValue: Int): SCurl = {
    var offset = offsetValue
    var length = lengthValue

    do {
      System.arraycopy(trits, offset, state, 0, if (length < HASH_LENGTH) length
      else HASH_LENGTH)
      transform
      offset += HASH_LENGTH
      length -= HASH_LENGTH
    } while (length > 0)
    this
  }

  /**
    * Absorbs the specified trits.
    *
    * @param trits The trits.
    * @return The Curl instance (used for method chaining).
    */
  override def absorb(trits: Array[Int]): SCurl = {
    absorb(trits, 0, trits.length)
  }

  /**
    * Squeezes the specified trits.
    *
    * @param trits  The trits.
    * @param offset The offset to start from.
    * @param length The length.
    * @return The squeezed trits.
    */
  override def squeeze(trits: Array[Int], offsetValue: Int, lengthValue: Int): Array[Int] = {
    var offset = offsetValue
    var length = lengthValue
    do {
      System.arraycopy(state, 0, trits, offset, if (length < HASH_LENGTH) length
      else HASH_LENGTH)
      transform
      offset += HASH_LENGTH
      length -= HASH_LENGTH
    } while (length > 0)
    state
  }

  /**
    * Squeezes the specified trits.
    *
    * @param trits The trits.
    * @return The squeezed trits.
    */
  override def squeeze(trits: Array[Int]): Array[Int] = {
    squeeze(trits, 0, trits.length)
  }

  /**
    * Transforms this instance.
    *
    * @return The Curl instance (used for method chaining).
    */
  override def transform: SCurl = {
    var scratchpadIndex = 0
    var prev_scratchpadIndex = 0
    var round = 0
    while (round < numberOfRounds) {
      System.arraycopy(state, 0, scratchpad, 0, STATE_LENGTH)
      var stateIndex = 0
      while (stateIndex < STATE_LENGTH) {
        prev_scratchpadIndex = scratchpadIndex
        if (scratchpadIndex < 365) scratchpadIndex += 364
        else scratchpadIndex += -365
        state(stateIndex) = TRUTH_TABLE(scratchpad(prev_scratchpadIndex) + (scratchpad(scratchpadIndex) << 2) + 5)
        stateIndex = stateIndex + 1
      }
      round = round + 1
    }
    this
  }

  /**
    * Resets this state.
    *
    * @return The Curl instance (used for method chaining).
    */
  override def reset: SCurl = {
    state = state.map(_ => 0)
    this
  }

  /**
    * Gets or sets the state.
    *
    * @return The stae.
    */
  override def getState: Array[Int] = state

  /**
    * Sets or sets the state.
    *
    * @param state The state.
    */
  override def setState(state: Array[Int]): Unit = {
    this.state = state
  }

  def reset(pair: Boolean): SCurl = {
    if (pair) true //set
    else reset
    this
  }

}
