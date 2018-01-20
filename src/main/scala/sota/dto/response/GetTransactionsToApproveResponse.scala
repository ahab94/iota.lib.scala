package sota.dto.response

/**
  * Response of {@link jota.dto.request.IotaGetTransactionsToApproveRequest}.
  **/
case class GetTransactionsToApproveResponse(trunkTransaction: String,
                                            branchTransaction: String)
