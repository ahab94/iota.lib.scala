package sota

import sota.dto.response.StoreTransactionsResponse
import sota.exceptions.ArgumentException
import sota.utils.Constants._
import sota.utils.InputValidator

import scala.util.control.NonFatal

/**
  * SOTA endpoint
  *
  * @author ahab94
  */


class IotaClient(config: IotaClientConfig = IotaClientConfig())
  extends IotaAPICore(config) {

  logger.info("SOTA client spawned for uri:{}", config.iriUrl)

  /**
    * Wrapper function that broadcasts and stores the specified trytes.
    *
    * @param trytes The trytes.
    * @return A StoreTransactionsResponse.
    */
  def broadcastAndStore(trytes: List[String]): StoreTransactionsResponse = {
    if (!InputValidator.isListOfAttachedTrytes(trytes))
      throw new ArgumentException(INVALID_TRYTES_INPUT_ERROR)
    try broadcastTransactions(trytes) catch {
      case NonFatal(ex) =>
        throw new ArgumentException(ex.getMessage)
    }
    storeTransactions(trytes)
  }

}
