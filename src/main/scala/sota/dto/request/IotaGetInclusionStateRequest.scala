package sota.dto.request

import jota.IotaAPICommands

/**
  * This class represents the core API request 'getInclusionStates'.
  **/
case class IotaGetInclusionStateRequest(transactions: List[String],
                                        tips: List[String],
                                        command: String = IotaAPICommands.GET_INCLUSIONS_STATES.command())
