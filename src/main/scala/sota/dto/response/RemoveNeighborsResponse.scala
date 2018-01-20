package sota.dto.response

/**
  * Response of {@link sota.dto.request.IotaNeighborsRequest}.
  **/
case class RemoveNeighborsResponse(removedNeighbors: Int,
                                   duration: Long)
