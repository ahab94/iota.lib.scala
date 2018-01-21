package sota.dto.response

import sota.model.Neighbor

/**
  * Response of {@link jota.dto.request.IotaCommandRequest}.
  **/
case class GetNeighborsResponse(neighbors: List[Neighbor],
                                duration: Long)
