package sota.dto.request

/**
  * This class represents the core API request 'getInclusionStates'.
  **/
case class GetInclusionStateRequest(transactions: List[String],
                                    tips: List[String],
                                    command: String = APICommands.GET_INCLUSIONS_STATES)
