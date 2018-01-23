package sota.pow

trait Curl {

  import jota.pow.ICurl

  /**
    * Absorbs the specified trits.
    *
    * @param trits  The trits.
    * @param offset The offset to start from.
    * @param length The length.
    * @return The ICurl instance (used for method chaining).
    */
  def absorb(trits: Array[Int], offset: Int, length: Int): ICurl

  /**
    * Absorbs the specified trits.
    *
    * @param trits The trits.
    * @return The ICurl instance (used for method chaining).
    */
  def absorb(trits: Array[Int]): ICurl

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
  def transform: ICurl

  /**
    * Resets this state.
    *
    * @return The ICurl instance (used for method chaining).
    */
  def reset: ICurl

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
