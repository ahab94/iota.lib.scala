package sota

import com.softwaremill.sttp.{HttpURLConnectionBackend, Id, Request, SttpBackend, Uri}
//TODO:replace with sota
import jota.utils.Checksum
import sota.dto.request._
import sota.dto.response._
import sota.error.ArgumentException
import sota.utils.Constants._
import sota.utils.InputValidator

/**
  * This class provides access to the Iota core API
  *
  * @author @ahab94
  */
case class IotaClientConfig(protocol: String = "http", host: String = "localhost", port: Int = 14265) {
  val iriUrl: Uri = Uri(protocol, host, port)
}

class IotaAPICore(config: IotaClientConfig, customApiBackend: Option[SttpBackend[Id, Nothing]] = None) {

  private val apiBackend: SttpBackend[Id, Nothing] = customApiBackend.getOrElse(HttpURLConnectionBackend())
  private val X_IOTA_API_VERSION_HEADER: Map[String, String] = Map("X-IOTA-API-Version" -> "1")
  private val uri: Uri = config.iriUrl
  private val service: APIService = new APIService(uri)

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
    val removeNeighborsRequest = service.removeNeighborsRequest(IotaNeighborsRequest(uris
      , IotaAPICommands.REMOVE_NEIGHBORS))
    executeRequest(removeNeighborsRequest)
  }

  def getTips: GetTipsResponse = {
    val getTipsRequest = service.getTipsRequest(IotaCommandRequest(IotaAPICommands.GET_TIPS))
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

  def findTransactionsByApprovees(approvees: List[String]): FindTransactionResponse = {
    findTransactions(null, null, approvees, null)
  }

  def findTransactions(addresses: List[String], tags: List[String], approvees: List[String], bundles: List[String])
  : FindTransactionResponse = {
    val findTransactionsRequest = service.findTransactionsRequest(IotaFindTransactionsRequest(bundles, addresses
      , tags, approvees))
    executeRequest(findTransactionsRequest)
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

  def findTransactionsByDigests(digests: List[String]): FindTransactionResponse = {
    findTransactions(null, digests, null, null)
  }

  def getInclusionStates(transactions: List[String], tips: List[String]): GetInclusionStateResponse = {
    if (!InputValidator.isListOfHashes(transactions))
      throw new ArgumentException(INVALID_HASHES_INPUT_ERROR)
    if (!InputValidator.isListOfHashes(tips))
      throw new ArgumentException(INVALID_HASHES_INPUT_ERROR)
    val getInclusionStatesRequest = service.getInclusionStatesRequest(IotaGetInclusionStateRequest(transactions, tips))
    executeRequest(getInclusionStatesRequest)
  }

  def getTrytes(hashes: List[String]): GetTrytesResponse = {
    if (!InputValidator.isListOfHashes(hashes))
      throw new ArgumentException(INVALID_HASHES_INPUT_ERROR)
    val getTrytesRequest = service.getTrytesRequest(IotaGetTrytesRequest(hashes))
    executeRequest(getTrytesRequest)
  }

  def getTransactionsToApprove(depth: Integer): GetTransactionsToApproveResponse = {
    val getTransactionsToApproveRequest = service
      .getTransactionsToApproveRequest(IotaGetTransactionsToApproveRequest(depth))
    executeRequest(getTransactionsToApproveRequest)
  }

  def getBalances(threshold: Integer, addresses: List[String]): GetBalancesResponse = {
    val addressesWithoutChecksum = addresses.map {
      address =>
        Checksum.removeChecksum(address)
    }
    val getBalancesRequest = service.getBalancesRequest(IotaGetBalancesRequest(addressesWithoutChecksum, threshold))
    executeRequest(getBalancesRequest)
  }

  def attachToTangle(trunkTransaction: String, branchTransaction: String, minWeightMagnitude: Integer
                     , trytes: List[String])
  : GetAttachToTangleResponse = {
    //TODO:implement logic
    val getAttachToTangleRequest = service.attachToTangleRequest(IotaAttachToTangleRequest(trunkTransaction
      , branchTransaction, minWeightMagnitude, trytes))
    executeRequest(getAttachToTangleRequest)
  }

  def interruptAttachingToTangle: InterruptAttachingToTangleResponse = {
    val getInterruptAttachToTangleRequest = service
      .interruptAttachingToTangleRequest(IotaCommandRequest(IotaAPICommands.INTERRUPT_ATTACHING_TO_TANGLE))
    executeRequest(getInterruptAttachToTangleRequest)
  }

  def broadcastTransactions(trytes: List[String]): BroadcastTransactionsResponse = {
    if (!InputValidator.isListOfAttachedTrytes(trytes))
      throw new ArgumentException(INVALID_ATTACHED_TRYTES_INPUT_ERROR)
    val broadcastTransactionsRequest = service
      .broadcastTransactionsRequest(IotaBroadcastTransactionRequest(trytes))
    executeRequest(broadcastTransactionsRequest)
  }

  def storeTransactions(trytes: List[String]): StoreTransactionsResponse = {
    val storeTransactionsRequest = service
      .storeTransactionsRequest(IotaStoreTransactionsRequest(trytes))
    executeRequest(storeTransactionsRequest)
  }

  def getProtocol: String = config.protocol

  def getHost: String = config.host

  def getPort: String = config.protocol

  def getURI: Uri = config.iriUrl

  def close(): Unit = apiBackend.close()

}
