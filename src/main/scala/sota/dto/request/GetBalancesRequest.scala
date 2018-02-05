package sota.dto.request

/**
  * This class represents the core api request 'getBalances'.
  **/
case class GetBalancesRequest(addresses: List[String],
                              threshold: Integer,
                              command: String = APICommands.GET_BALANCES)