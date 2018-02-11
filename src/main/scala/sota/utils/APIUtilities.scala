package sota.utils

import com.softwaremill.sttp.{Request, Response}
import com.typesafe.scalalogging.LazyLogging
import sota.exceptions.ArgumentException

object APIUtilities extends LazyLogging {

  def exceptionHelper[T](request: Request[T, Nothing], response: Response[T], error: String): Throwable = {
    logger.error(s"Request: {} failed with Response: {} with following message: {}", request, response, error)
    val code = response.code
    val exception = code match {
      case 400 => new ArgumentException(error)
      case 401 => new IllegalAccessError("400 " + error)
      case 500 => new IllegalAccessError("500 " + error)
      case _ => new Exception(error)
    }
    exception
  }
}
