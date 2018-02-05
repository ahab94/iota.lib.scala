package sota.dto.response

/**
  * Response of {@link sota.dto.request.GetTransactionsToApproveRequest}.
  **/
case class GetTransactionsToApproveResponse(trunkTransaction: String,
                                            branchTransaction: String,
                                            duration: Long)
