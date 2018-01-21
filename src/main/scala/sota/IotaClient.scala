package sota

import com.softwaremill.sttp._
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
