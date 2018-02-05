package sota.dto.response

/**
  * Response of {@link sota.dto.request.GetBalancesRequest}.
  **/
case class GetBalancesResponse(
                                balances: List[String],
                                milestone: String,
                                milestoneIndex: Int,
                                duration: Long)
