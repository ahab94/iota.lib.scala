package sota.dto.response

import jota.model.Neighbor

/**
  * Response of {@link jota.dto.request.IotaCommandRequest}.
  **/
case class GetNeighborsResponse(neighbors: List[Neighbor])
