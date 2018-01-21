package sota.dto.request

import jota.IotaAPICommands

/**
  * This class represents the core api request 'findTransactions'.
  **/
case class IotaFindTransactionsRequest(
                                        bundles: List[String],
                                        addresses: List[String],
                                        tags: List[String],
                                        approvees: List[String],
                                        command: String = IotaAPICommands.FIND_TRANSACTIONS.command())
