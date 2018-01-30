package sota.error


class BaseException(message: String, exception: Throwable) extends Exception(message, exception) {

  override def getMessage: String = message

}