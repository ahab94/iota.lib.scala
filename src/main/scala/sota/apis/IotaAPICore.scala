package sota.apis

import com.softwaremill.sttp.Uri
import sota.dto.response._

/**
  * This class provides access to the Iota core API
  *
  * @author @ahab94
  */
case class IotaClientConfig(protocol: String = "http", host: String = "localhost", port: Int = 14265) {
  val iriUrl: Uri = Uri(protocol, host, port)
}

class IotaAPICore(config: IotaClientConfig) {

  val X_IOTA_API_VERSION_HEADER: Map[String, String] = Map("X-IOTA-API-Version" -> "1")
  val uri: Uri = config.iriUrl
  val service: APIService = new APIService(uri)

  //TODO implement client api functions

  def getNodeInfo: GetNodeInfoResponse = ???

  def getNeighbors: GetNeighborsResponse = ???

  def addNeighbors(uris: String*): AddNeighborsResponse = ???

  def removeNeighbors(uris: String*): RemoveNeighborsResponse = ???

  def getTips: GetTipsResponse = ???

  def findTransactions(addresses: Array[String], tags: Array[String], approvees: Array[String], bundles: Array[String])
  : FindTransactionResponse = ???

  def findTransactionsByAddresses(addresses: String*): FindTransactionResponse = ???

  def findTransactionsByBundles(bundles: String*): FindTransactionResponse = ???

  def findTransactionsByApprovees(approvees: String*): FindTransactionResponse = ???

  def findTransactionsByDigests(digests: String*): FindTransactionResponse = ???

  def getInclusionStates(transactions: Array[String], tips: Array[String]): GetInclusionStateResponse = ???

  def getTrytes(hashes: String*): GetTrytesResponse = ???

  def getTransactionsToApprove(depth: Integer): GetTransactionsToApproveResponse = ???

  def getBalances(threshold: Integer, addresses: List[String]): GetBalancesResponse = ???

  def attachToTangle(trunkTransaction: String, branchTransaction: String, minWeightMagnitude: Integer, trytes: String*)
  : GetAttachToTangleResponse = ???

  def interruptAttachingToTangle: InterruptAttachingToTangleResponse = ???

  def broadcastTransactions(trytes: String*): BroadcastTransactionsResponse = ???

  def storeTransactions(trytes: String*): StoreTransactionsResponse = ???

  def getProtocol: String = config.protocol

  def getHost: String = config.host

  def getPort: String = config.protocol

  def getURI: Uri = config.iriUrl

}
