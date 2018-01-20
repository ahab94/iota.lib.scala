package sota.dto.request

import jota.IotaAPICommands

/**
  * This class represents the core API request 'getTransactionsToApprove'.
  *
  * It stores transactions into the local storage. The trytes to be used for this call are returned by attachToTangle.
  **/
case class IotaStoreTransactionsRequest(trytes: List[String])
  extends IotaCommandRequest(IotaAPICommands.STORE_TRANSACTIONS.command())
