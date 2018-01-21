package sota.dto.response

import sota.model.Transaction

/**
  * Response of api request 'getBundle.
  **/
case class GetBundleResponse(transactions: List[Transaction],
                             duration: Long)
