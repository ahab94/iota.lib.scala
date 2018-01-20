package sota.dto.request

import jota.IotaAPICommands

/**
  * This class represents the core api request 'getBalances'.
  **/
case class IotaGetBalancesRequest(addresses: List[String],
                                  threshold: Integer)
  extends IotaCommandRequest(IotaAPICommands.GET_BALANCES.command())