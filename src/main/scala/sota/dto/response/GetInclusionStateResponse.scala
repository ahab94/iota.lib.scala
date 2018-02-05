package sota.dto.response

/**
  * Response of {@link sota.dto.request.GetInclusionStateRequest}.
  **/
case class GetInclusionStateResponse(states: List[Boolean],
                                     duration: Long)
