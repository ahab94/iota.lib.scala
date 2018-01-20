package sota.utils

import com.softwaremill.sttp._
import com.softwaremill.sttp.json4s._


case class Command(command: String)


object HTTPUtils {

  private val headers: Map[String, String] = Map("Content-Type" -> "application/json",
    "User-Agent" -> "JOTA-API wrapper",
    "Content-Type" -> "application/json",
    "X-IOTA-API-Version" -> "1.4.1")

  def requestTemplate(uri: Uri, command: Command): RequestT[Id, String, Nothing] = {
    sttp.post(uri)
      .headers(headers)
      .body(command)
  }
}
