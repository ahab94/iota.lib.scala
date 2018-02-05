package sota.dto.response

/**
  * Response of {@link sota.dto.request.GetTrytesRequest}.
  **/
case class GetTrytesResponse(trytes: List[String],
                             duration: Long)
