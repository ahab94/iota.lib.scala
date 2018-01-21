package sota.dto.response

import sota.model.Transaction

/**
  * Response of {@link sota.dto.request.IotaGetBalancesRequest}.
  **/
case class AnalyzeTransactionResponse(transactions: List[Transaction]
                                      , duration: Long)
