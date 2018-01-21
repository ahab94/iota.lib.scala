package sota

import com.softwaremill.sttp._
import jota.IotaAPI
import jota.IotaAPI._
import sota.apis.{IotaAPICore, IotaClientConfig}

/**
  * SOTA endpoint
  *
  * @author ahab94
  */


class IotaClient(config: IotaClientConfig = IotaClientConfig(),
                 implicit val apiBackend: SttpBackend[Id, Nothing] = HttpURLConnectionBackend())
  extends IotaAPICore(config) {
  //WIP
}

object test extends App {
  val x = new IotaAPI

x.addRemainder()
}