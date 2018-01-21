package sota.apis

import com.softwaremill.sttp.Uri

/**
  * This class provides access to the Iota core API
  *
  * @author @ahab94
  */
case class IotaClientConfig(protocol: String = "http", host: String = "127.0.0.1", port: Int = 14265) {
  val iriUrl: Uri = Uri(protocol, host, port)
}

class IotaAPICore(config: IotaClientConfig) {

  val X_IOTA_API_VERSION_HEADER: Map[String, String] = Map("X-IOTA-API-Version" -> "1")
  val uri: Uri = config.iriUrl
  val service: APIService = new APIService(uri)

}
