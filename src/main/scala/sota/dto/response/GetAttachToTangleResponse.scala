package sota.dto.response

/**
  * Response of {@link jota.dto.request.AttachToTangleRequest}.
  **/
case class GetAttachToTangleResponse(trytes: List[String],
                                     duration: Long)
