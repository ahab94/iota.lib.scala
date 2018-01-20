package sota.dto.request

import jota.IotaAPICommands

/**
  * This class represents the core API request 'getTrytes'.
  **/
case class IotaGetTrytesRequest(hashes: List[String])
  extends IotaCommandRequest(IotaAPICommands.GET_TRYTES.command())
