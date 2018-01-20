package sota.dto.response

import jota.model.Transaction

/**
  * Response of {@link jota.dto.request.IotaGetBalancesRequest}.
  **/
case class AnalyzeTransactionResponse(transactions: List[Transaction]
                                      , duration: Long)
