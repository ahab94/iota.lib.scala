package sota.pow

/**
  * Curl
  *
  *
  * author: ahab94
  **/
class SCurl extends Curl {


  /**
    * The hash length.
    */
  val HASH_LENGTH = 243
  private val STATE_LENGTH = 3 * HASH_LENGTH

  val NUMBER_OF_ROUNDSP81 = 81
  val NUMBER_OF_ROUNDSP27 = 27
  private val numberOfRounds = 0

  private val TRUTH_TABLE = List(1, 0, -1, 2, 1, -1, 0, 2, -1, 1, 0)
  private val stateLow: List[Long] = List()
  private val stateHigh: List[Long] = List()
  private val scratchpad: List[Int] = List(STATE_LENGTH)
  private val state: List[Int] = List()

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
