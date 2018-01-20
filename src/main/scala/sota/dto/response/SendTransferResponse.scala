package sota.dto.response

import jota.model.Transaction

/**
  * Response of api request 'sendTransfer'.
  **/
case class SendTransferResponse(transactions: List[Transaction],
                                successfully: List[Boolean])