package sota.dto.response

import sota.models.Transaction

/**
  * Response of {@link sota.dto.request.GetBalancesRequest}.
  **/
case class AnalyzeTransactionResponse(transactions: List[Transaction]
                                      , duration: Long)
