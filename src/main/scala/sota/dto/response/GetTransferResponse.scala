package sota.dto.response

import jota.model.Bundle

/**
  * Response of api request 'getTransfer'.
  **/

case class GetTransferResponse(transferBundle: List[Bundle],
                               duration: Long)
