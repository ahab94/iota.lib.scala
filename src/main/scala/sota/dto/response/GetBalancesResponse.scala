package sota.dto.response

/**
  * Response of {@link sota.dto.request.IotaGetBalancesRequest}.
  **/
case class GetBalancesResponse(
                                balances: List[String],
                                milestone: String,
                                milestoneIndex: Int,
                                duration: Long)
