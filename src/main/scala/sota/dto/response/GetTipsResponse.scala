package sota.dto.response

/**
  * Response of {@link sota.dto.request.IotaCommandRequest}.
  **/
case class GetTipsResponse(hashes: List[String],
                           duration: Long)
