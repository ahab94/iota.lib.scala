package sota.dto.request

/**
  * This class represents the core API request 'getTransactionsToApprove'.
  **/
case class IotaGetTransactionsToApproveRequest(depth: Integer,
                                               command: String = IotaAPICommands.GET_TRANSACTIONS_TO_APPROVE)
