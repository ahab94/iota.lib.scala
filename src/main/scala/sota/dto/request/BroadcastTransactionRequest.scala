package sota.dto.request

/**
  * This class represents the core API request 'broadcastTransaction'.
  *
  * Broadcast a list of transactions to all neighbors. The input trytes for this call are provided by attachToTangle
  **/
case class BroadcastTransactionRequest(trytes: List[String],
                                       command: String = APICommands.BROADCAST_TRANSACTIONS)

