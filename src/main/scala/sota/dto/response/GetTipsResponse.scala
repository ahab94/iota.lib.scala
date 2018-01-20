package sota.dto.response

/**
  * Response of {@link jota.dto.request.IotaCommandRequest}.
  **/
case class GetTipsResponse(hashes: List[String],
                           duration: Long)
