package sota.dto.response

/**
  * Response of {@link sota.dto.request.CommandRequest}.
  **/
case class GetTipsResponse(hashes: List[String],
                           duration: Long)
