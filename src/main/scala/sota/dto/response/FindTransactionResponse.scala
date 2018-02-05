package sota.dto.response

/**
  * Response of {@link sota.dto.request.IotaFindTransactionsRequest}.
  **/
case class FindTransactionResponse(hashes: List[String]
                                   , duration: Long)
