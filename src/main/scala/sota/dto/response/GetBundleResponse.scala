package sota.dto.response

import jota.model.Transaction

/**
  * Response of api request 'getBundle.
  **/
case class GetBundleResponse(transactions: List[Transaction],
                             duration: Long)
