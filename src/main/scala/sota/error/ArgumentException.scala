package sota.error

class ArgumentException(message: String, exception: Throwable) extends BaseException(message: String, exception: Throwable) {

  /**
    * Serial version UID
    */
 // private val serialVersionUID = -7850044681919575720L

  /**
    * Initializes a new instance of the ArgumentException.
    */
  def this() = {
    this ("Wrong arguments passed to function", null)
  }

  def this(msg: String) {
    this (msg, null)
  }
}
