package sota.dto.request

/**
  * This class represents the core API request 'getTrytes'.
  **/
case class GetTrytesRequest(hashes: List[String],
                            command: String = APICommands.GET_TRYTES)
