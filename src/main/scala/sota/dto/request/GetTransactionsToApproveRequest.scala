package sota.dto.request

/**
  * This class represents the core API request 'getTransactionsToApprove'.
  **/
case class GetTransactionsToApproveRequest(depth: Integer,
                                           command: String = APICommands.GET_TRANSACTIONS_TO_APPROVE)
