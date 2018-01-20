package sota

import com.softwaremill.sttp._

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
  //WIP
}
