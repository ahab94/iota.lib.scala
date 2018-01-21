package sota.dto.request

object IotaAPICommands {
  val GET_NODE_INFO = "getNodeInfo"
  val GET_NEIGHBORS = "getNeighbors"
  val ADD_NEIGHBORS = "addNeighbors"
  val REMOVE_NEIGHBORS = "removeNeighbors"
  val GET_TIPS = "getTips"
  val FIND_TRANSACTIONS = "findTransactions"
  val GET_TRYTES = "getTrytes"
  val GET_INCLUSIONS_STATES = "getInclusionStates"
  val GET_BALANCES = "getBalances"
  val GET_TRANSACTIONS_TO_APPROVE = "getTransactionsToApprove"
  val ATTACH_TO_TANGLE = "attachToTangle"
  val INTERRUPT_ATTACHING_TO_TANGLE = "interruptAttachingToTangle"
  val BROADCAST_TRANSACTIONS = "broadcastTransactions"
  val STORE_TRANSACTIONS = "storeTransactions"
}
