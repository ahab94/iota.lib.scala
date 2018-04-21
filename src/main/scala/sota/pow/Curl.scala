package sota.pow

trait Curl {

  /**
    * Absorbs the specified trits.
    *
    * @param trits  The trits.
    * @param offset The offset to start from.
    * @param length The length.
    * @return The ICurl instance (used for method chaining).
    */
  def absorb(trits: Array[Int], offset: Int, length: Int): Curl

  /**
    * Absorbs the specified trits.
    *
    * @param trits The trits.
    * @return The ICurl instance (used for method chaining).
    */
  def absorb(trits: Array[Int]): Curl

  /**
    * Squeezes the specified trits.
    *
    * @param trits  The trits.
    * @param offset The offset to start from.
    * @param length The length.
    * @return The squeezed trits.
    */
  def squeeze(trits: Array[Int], offset: Int, length: Int): Array[Int]

  /**
    * Squeezes the specified trits.
    *
    * @param trits The trits.
    * @return The squeezed trits.
    */
  def squeeze(trits: Array[Int]): Array[Int]

  /**
    * Transforms this instance.
    *
    * @return The ICurl instance (used for method chaining).
    */
  def transform: Curl

  /**
    * Resets this state.
    *
    * @return The ICurl instance (used for method chaining).
    */
  def reset: Curl

  /**
    * Gets or sets the state.
    *
    * @return The stae.
    */
  def getState: Array[Int]

  /**
    * Sets or sets the state.
    *
    * @param state The state.
    */
  def setState(state: Array[Int]): Unit
}