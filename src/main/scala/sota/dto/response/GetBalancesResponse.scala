package sota.dto.response

/**
  * Response of {@link jota.dto.request.IotaGetBalancesRequest}.
  **/
case class GetBalancesResponse(
                                balances: List[String],
                                milestone: String,
                                milestoneIndex: Int,
                                duration: Long)
