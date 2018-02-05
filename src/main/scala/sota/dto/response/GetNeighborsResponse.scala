package sota.dto.response

import sota.models.Neighbor

/**
  * Response of {@link jota.dto.request.CommandRequest}.
  **/
case class GetNeighborsResponse(neighbors: List[Neighbor],
                                duration: Long)
