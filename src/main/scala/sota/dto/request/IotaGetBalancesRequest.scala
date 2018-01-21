package sota.dto.request

/**
  * This class represents the core api request 'getBalances'.
  **/
case class IotaGetBalancesRequest(addresses: List[String],
                                  threshold: Integer,
                                  command: String = IotaAPICommands.GET_BALANCES)