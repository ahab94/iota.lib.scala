package sota.pow
import jota.pow.ICurl

class SCurl extends Curl {
  /**
    * Absorbs the specified trits.
    *
    * @param trits  The trits.
    * @param offset The offset to start from.
    * @param length The length.
    * @return The ICurl instance (used for method chaining).
    */
  override def absorb(trits: Array[Int], offset: Int, length: Int): ICurl = ???

  /**
    * Absorbs the specified trits.
    *
    * @param trits The trits.
    * @return The ICurl instance (used for method chaining).
    */
  override def absorb(trits: Array[Int]): ICurl = ???

  /**
    * Squeezes the specified trits.
    *
    * @param trits  The trits.
    * @param offset The offset to start from.
    * @param length The length.
    * @return The squeezed trits.
    */
  override def squeeze(trits: Array[Int], offset: Int, length: Int): Array[Int] = ???

  /**
    * Squeezes the specified trits.
    *
    * @param trits The trits.
    * @return The squeezed trits.
    */
  override def squeeze(trits: Array[Int]): Array[Int] = ???

  /**
    * Transforms this instance.
    *
    * @return The ICurl instance (used for method chaining).
    */
  override def transform: ICurl = ???

  /**
    * Resets this state.
    *
    * @return The ICurl instance (used for method chaining).
    */
  override def reset: ICurl = ???

  /**
    * Gets or sets the state.
    *
    * @return The stae.
    */
  override def getState: Array[Int] = ???

  /**
    * Sets or sets the state.
    *
    * @param state The state.
    */
  override def setState(state: Array[Int]): Unit = ???
}
