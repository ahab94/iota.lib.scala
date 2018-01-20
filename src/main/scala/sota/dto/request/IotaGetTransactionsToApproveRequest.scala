package sota.dto.request

import jota.IotaAPICommands

/**
  * This class represents the core API request 'getTransactionsToApprove'.
  **/
case class IotaGetTransactionsToApproveRequest(depth: Integer)
  extends IotaCommandRequest(IotaAPICommands.GET_TRANSACTIONS_TO_APPROVE.command())