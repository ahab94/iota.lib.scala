package sota.dto.response

/**
  * Response of {@link sota.dto.request.IotaGetTrytesRequest}.
  **/
case class GetTrytesResponse(trytes: List[String],
                             duration: Long)
