package sota

import com.softwaremill.sttp.{HttpURLConnectionBackend, Id, SttpBackend}
import sota.apis.{IotaAPICore, IotaClientConfig}

/**
  * SOTA endpoint
  *
  * @author ahab94
  */


class IotaClient(config: IotaClientConfig = IotaClientConfig(),
                 customApiBackend: SttpBackend[Id, Nothing] = HttpURLConnectionBackend())
  extends IotaAPICore(config, customApiBackend) {
  //WIP

}
