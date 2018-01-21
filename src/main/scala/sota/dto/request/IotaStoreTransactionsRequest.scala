package sota.dto.request

/**
  * This class represents the core API request 'getTransactionsToApprove'.
  *
  * It stores transactions into the local storage. The trytes to be used for this call are returned by attachToTangle.
  **/
case class IotaStoreTransactionsRequest(trytes: List[String],
                                        command: String = IotaAPICommands.STORE_TRANSACTIONS)
