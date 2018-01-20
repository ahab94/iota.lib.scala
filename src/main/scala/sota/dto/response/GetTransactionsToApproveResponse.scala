package sota.dto.response

/**
  * Response of {@link sota.dto.request.IotaGetTransactionsToApproveRequest}.
  **/
case class GetTransactionsToApproveResponse(trunkTransaction: String,
                                            branchTransaction: String,
                                            duration: Long)
