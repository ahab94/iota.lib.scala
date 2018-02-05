package sota.dto.response

import sota.models.Transaction

/**
  * Response of api request 'sendTransfer'.
  **/
case class SendTransferResponse(transactions: List[Transaction],
                                successfully: List[Boolean],
                                duration: Long)