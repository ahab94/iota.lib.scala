package sota.dto.response

/**
  * Response of {@link sota.dto.request.NeighborsRequest}.
  **/
case class RemoveNeighborsResponse(removedNeighbors: Int,
                                   duration: Long)
