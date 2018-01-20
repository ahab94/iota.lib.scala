package sota.dto.response

/**
  * Response of {@link jota.dto.request.IotaNeighborsRequest}.
  **/
case class RemoveNeighborsResponse(removedNeighbors: Int,
                                   duration: Long)
