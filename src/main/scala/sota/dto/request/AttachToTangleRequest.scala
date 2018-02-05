package sota.dto.request

/**
  * This class represents the core API request 'attachToTangle'.
  *
  * It is used to attach trytes to the tangle.
  **/
case class AttachToTangleRequest(
                                      trunkTransaction: String,
                                      branchTransaction: String,
                                      minWeightMagnitude: Integer,
                                      trytes: List[String],
                                      command: String = APICommands.ATTACH_TO_TANGLE
                                    )
