package sota.dto.request

import jota.IotaAPICommands

/**
  * This class represents the core API request 'attachToTangle'.
  *
  * It is used to attach trytes to the tangle.
  **/
case class IotaAttachToTangleRequest(
                                      trunkTransaction: String,
                                      branchTransaction: String,
                                      minWeightMagnitude: Integer,
                                      trytes: List[String])
  extends IotaCommandRequest(IotaAPICommands.ATTACH_TO_TANGLE.command())
