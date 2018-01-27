package sota.apis

import com.softwaremill.sttp.{Id, Request, SttpBackend, Uri}
import jota.utils.Constants._
import jota.utils.{Checksum, InputValidator}
import sota.dto.request._
import sota.dto.response._
import sota.error.ArgumentException

/**
  * This class provides access to the Iota core API
  *
  * @author @ahab94
  */
case class IotaClientConfig(protocol: String = "http", host: String = "localhost", port: Int = 14265) {
  val iriUrl: Uri = Uri(protocol, host, port)
}

class IotaAPICore(config: IotaClientConfig,
                  implicit val apiBackend: SttpBackend[Id, Nothing]) {

  val X_IOTA_API_VERSION_HEADER: Map[String, String] = Map("X-IOTA-API-Version" -> "1")
  val uri: Uri = config.iriUrl
  val service: APIService = new APIService(uri)

  def getNodeInfo: GetNodeInfoResponse = {
    val getNodeInfoRequest = service.getNodeInfoRequest(IotaCommandRequest(IotaAPICommands.GET_NODE_INFO))
    executeRequest(getNodeInfoRequest)
  }

  def getNeighbors: GetNeighborsResponse = {
    val getNeighborsRequest = service.getNeighborsRequest(IotaCommandRequest(IotaAPICommands.GET_NEIGHBORS))
    executeRequest(getNeighborsRequest)
  }

  def addNeighbors(uris: List[String]): AddNeighborsResponse = {
    val addNeighborsRequest = service.addNeighborsRequest(IotaNeighborsRequest(uris, IotaAPICommands.ADD_NEIGHBORS))
    executeRequest(addNeighborsRequest)
  }

  def removeNeighbors(uris: List[String]): RemoveNeighborsResponse = {
    val removeNeighborsRequest = service.removeNeighborsRequest(IotaNeighborsRequest(uris,
      IotaAPICommands.REMOVE_NEIGHBORS))
    executeRequest(removeNeighborsRequest)
  }

  def getTips: GetTipsResponse = {
    val getTipsRequest = service.getTipsRequest(IotaCommandRequest(IotaAPICommands.GET_TIPS))
    val response = apiBackend.send(getTipsRequest)
    executeRequest(getTipsRequest)
  }

  def findTransactionsByAddresses(addresses: List[String]): FindTransactionResponse = {
    val addressesWithoutChecksum = addresses.map {
      address =>
        Checksum.removeChecksum(address)
    }
    findTransactions(addressesWithoutChecksum, null, null, null)
  }

  def findTransactionsByBundles(bundles: List[String]): FindTransactionResponse = {
    findTransactions(null, null, null, bundles)
  }

  def findTransactions(addresses: List[String], tags: List[String], approvees: List[String], bundles: List[String])
  : FindTransactionResponse = {
    val findTransactionsRequest = service.findTransactionsRequest(IotaFindTransactionsRequest(bundles, addresses
      , tags, approvees, IotaAPICommands.FIND_TRANSACTIONS))
    executeRequest(findTransactionsRequest)
  }

  def findTransactionsByApprovees(approvees: List[String]): FindTransactionResponse = {
    findTransactions(null, null, approvees, null)
  }

  def findTransactionsByDigests(digests: List[String]): FindTransactionResponse = {
    findTransactions(null, digests, null, null)
  }

  def getInclusionStates(transactions: List[String], tips: List[String]): GetInclusionStateResponse = {
    import jota.utils.InputValidator
    if (!InputValidator.isArrayOfHashes(transactions.toArray))
      throw new ArgumentException(INVALID_HASHES_INPUT_ERROR)
    if (!InputValidator.isArrayOfHashes(tips.toArray))
      throw new ArgumentException(INVALID_HASHES_INPUT_ERROR)
    val getInclusionStatesRequest = service.getInclusionStatesRequest(IotaGetInclusionStateRequest(transactions, tips
      , IotaAPICommands.GET_INCLUSIONS_STATES))
    executeRequest(getInclusionStatesRequest)
  }

  def getTrytes(hashes: List[String]): GetTrytesResponse = {
    if (!InputValidator.isArrayOfHashes(hashes.toArray))
      throw new ArgumentException(INVALID_HASHES_INPUT_ERROR)
    val getTrytesRequest = service.getTrytesRequest(IotaGetTrytesRequest(hashes, IotaAPICommands.GET_TRYTES))
    executeRequest(getTrytesRequest)
  }

  def getTransactionsToApprove(depth: Integer): GetTransactionsToApproveResponse = {
    val getTransactionsToApproveRequest = service
      .getTransactionsToApproveRequest(IotaGetTransactionsToApproveRequest(depth, IotaAPICommands.GET_TRANSACTIONS_TO_APPROVE))
    executeRequest(getTransactionsToApproveRequest)
  }

  def getBalances(threshold: Integer, addresses: List[String]): GetBalancesResponse = {
    val addressesWithoutChecksum = addresses.map {
      address =>
        Checksum.removeChecksum(address)
    }
    val getBalancesRequest = service.getBalancesRequest(IotaGetBalancesRequest(addressesWithoutChecksum, threshold
      , IotaAPICommands.GET_BALANCES))
    executeRequest(getBalancesRequest)
  }

  def executeRequest[T](request: Request[T, Nothing]): T = {
    val requestWithHeaders = request.headers(X_IOTA_API_VERSION_HEADER)
    val response = apiBackend.send(requestWithHeaders)
    response.body match {
      case Right(body) => body
      case Left(error) => throw exceptionHelper(error, response.code)
    }
  }

  def exceptionHelper(msg: String, code: Int): Throwable = {
    code match {
      case 400 => new ArgumentException(msg)
      case 401 => new IllegalAccessError("400 " + msg)
      case 500 => new IllegalAccessError("500 " + msg)
      case _ => new Exception(msg)
    }
  }

  def attachToTangle(trunkTransaction: String, branchTransaction: String, minWeightMagnitude: Integer, trytes: List[String])
  : GetAttachToTangleResponse = {
    //TODO:implement logic
    val getAttachToTangleRequest = service.attachToTangleRequest(IotaAttachToTangleRequest(trunkTransaction
      , branchTransaction, minWeightMagnitude, trytes, IotaAPICommands.ATTACH_TO_TANGLE))
    executeRequest(getAttachToTangleRequest)
  }

  def interruptAttachingToTangle: InterruptAttachingToTangleResponse = {
    val getInterruptAttachToTangleRequest = service
      .interruptAttachingToTangleRequest(IotaCommandRequest(IotaAPICommands.INTERRUPT_ATTACHING_TO_TANGLE))
    executeRequest(getInterruptAttachToTangleRequest)
  }

  def broadcastTransactions(trytes: List[String]): BroadcastTransactionsResponse = ???

  def storeTransactions(trytes: List[String]): StoreTransactionsResponse = ???

  def getProtocol: String = config.protocol

  def getHost: String = config.host

  def getPort: String = config.protocol

  def getURI: Uri = config.iriUrl

}
