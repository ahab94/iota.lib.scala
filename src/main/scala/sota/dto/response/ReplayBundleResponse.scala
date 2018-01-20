package sota.dto.response

/**
  * Response of api request 'replayBundle'.
  **/
case class ReplayBundleResponse(successfully: List[Boolean],
                                duration: Long)
