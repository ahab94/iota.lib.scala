package sota

import com.softwaremill.sttp._
import com.softwaremill.sttp.json4s._
import sota.dto.response.GetNodeInfoResponse
import sota.utils.{Command, HTTPUtils}

/**
  * SOTA endpoint
  *
  * @author ahab94
  */
case class IotaClientConfig(protocol: String = "http", host: String = "localhost", port: Int = 14265) {
  val iriUrl: Uri = Uri(protocol, host, port)
}


class IotaClient(config: IotaClientConfig = IotaClientConfig(),
                 implicit val apiBackend: SttpBackend[Id, Nothing] = HttpURLConnectionBackend()) {
  val x = apiBackend.send(HTTPUtils.requestTemplate(config.iriUrl, Command("getNodeInfo")).response(asJson[GetNodeInfoResponse]))
  println(x.body)
}

object test extends App {
  val client = new IotaClient()

}