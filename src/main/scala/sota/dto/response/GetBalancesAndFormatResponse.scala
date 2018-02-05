package sota.dto.response

import jota.model.Input

/**
  * Response of {@link sota.dto.request.BroadcastTransactionRequest}.
  **/
case class GetBalancesAndFormatResponse(inputs: List[Input],
                                        totalBalance: Long,
                                        duration: Long)
