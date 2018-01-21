package sota

import com.softwaremill.sttp._
import com.softwaremill.sttp.json4s._
import sota.dto.request.IotaNeighborsRequest
import sota.dto.response.GetNeighborsResponse

/**
  * SOTA endpoint
  *
  * @author ahab94
  */
case class IotaClientConfig(protocol: String = "http", host: String = "127.0.0.1", port: Int = 14265) {
  val iriUrl: Uri = Uri(protocol, host, port)
}


class IotaClient(config: IotaClientConfig = IotaClientConfig(),
                 implicit val apiBackend: SttpBackend[Id, Nothing] = HttpURLConnectionBackend()) {

  private val headers: Map[String, String] = Map("Content-Type" -> "application/json",
    "User-Agent" -> "JOTA-API wrapper",
    "Content-Type" -> "application/json",
    "X-IOTA-API-Version" -> "1.4.1")

  val y = sttp.post(config.iriUrl)
    .headers(headers)
    .body(IotaNeighborsRequest(null, "getNeighbors"))
    .response(asJson[GetNeighborsResponse])

  val x = apiBackend.send(y)

  println(x.body)
}

object test extends App {
  val client = new IotaClient()

}