package sota.dto.request

import jota.IotaAPICommands

/**
  * This class represents the core API request 'broadcastTransaction'.
  *
  * Broadcast a list of transactions to all neighbors. The input trytes for this call are provided by attachToTangle
  **/
case class IotaBroadcastTransactionRequest(trytes: List[String])
  extends IotaCommandRequest(IotaAPICommands.BROADCAST_TRANSACTIONS.command())
