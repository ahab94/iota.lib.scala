package sota.error


class BaseException(message: String, exception: Throwable) extends Exception(message, exception) {

  /**
    * Serial version UID
    * not in use
    */
  //private val serialVersionUID = 5617085097507773343L

  var msg: List[String] = null

  def this(message: String) = {
    this(message, null)
    if (msg == null) msg = Nil
    message :: msg
  }

  def this(messageList: List[String], exception: Throwable) = {
    this("", exception)
    msg = messageList
  }

//TODO need to take a look for this one
//  def this(messageList: List[String]) = {
//    msg= messageList
//  }

override def getMessage: String = msg.toString()

}