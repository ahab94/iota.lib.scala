package sota.dto.response

/**
  * Response of {@link sota.dto.request.IotaGetInclusionStateRequest}.
  **/
case class GetInclusionStateResponse(states: List[Boolean],
                                     duration: Long)
