package sota.dto.request

/**
  * This class represents the core API request 'getTrytes'.
  **/
case class IotaGetTrytesRequest(hashes: List[String],
                                command: String = IotaAPICommands.GET_TRYTES)
