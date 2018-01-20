package sota.dto.request

/**
  * This class represents the core API request 'addNeighbors' and 'removeNeighbors'.
  **/

case class IotaNeighborsRequest(uris: List[String], cmd: String)
  extends IotaCommandRequest(cmd)
