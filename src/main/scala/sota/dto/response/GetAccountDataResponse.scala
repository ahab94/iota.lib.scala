package sota.dto.response

import jota.model.{Bundle, Input}

/**
  * Response of api request 'getAccountData'.
  **/
class GetAccountDataResponse(addresses: List[String],
                             transferBundle: List[Bundle],
                             inputs: List[Input],
                             balance: Long)
