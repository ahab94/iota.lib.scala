package sota.dto.request

import jota.IotaAPICommands

/**
  * This class represents the core API request 'getInclusionStates'.
  **/
case class IotaGetInclusionStateRequest(transactions: Array[String],
                                        tips: Array[String])
  extends IotaCommandRequest(IotaAPICommands.GET_INCLUSIONS_STATES.command())
