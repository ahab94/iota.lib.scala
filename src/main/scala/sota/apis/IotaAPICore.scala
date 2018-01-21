package sota.apis

import com.softwaremill.sttp.Uri

/**
  * This class provides access to the Iota core API
  *
  * @author @ahab94
  */
case class IotaClientConfig(protocol: String = "http", host: String = "localhost", port: Int = 14265) {
  val iriUrl: Uri = Uri(protocol, host, port)
}

class IotaAPICore(config: IotaClientConfig) extends IotaAPICoreRef {

  val X_IOTA_API_VERSION_HEADER: Map[String, String] = Map("X-IOTA-API-Version" -> "1")
  val uri: Uri = config.iriUrl
  val service: APIService = new APIService(uri)

  //WIP
  
  override def getTransactionsObjects(): Unit = ???

  override def findTransactionObjects(): Unit = ???

  override def getLatestInclusion(): Unit = ???

  override def broadcastAndStore(): Unit = ???

  override def getNewAddress(): Unit = ???

  override def getInputs(): Unit = ???

  override def prepareTransfers(): Unit = ???

  override def sendTrytes(): Unit = ???

  override def sendTransfer(): Unit = ???

  override def replayBundle(): Unit = ???

  override def getBundle(): Unit = ???

  override def getTransfers(): Unit = ???

  override def initiateTransfer(): Unit = ???

  override def getAccountData(): Unit = ???

  override def convertUnits(): Unit = ???

  override def addChecksum(): Unit = ???

  override def removeChecksum(): Unit = ???

  override def isValidChecksum(): Unit = ???

  override def checkAddress(): Unit = ???

  override def isAddress(): Unit = ???

  override def isArrayOfHashes(): Unit = ???

  override def isArrayOfTrytes(): Unit = ???

  override def inNinesTrytes(): Unit = ???

  override def isTransfersCollectionValid(): Unit = ???

  override def isTrytes(): Unit = ???

  override def isValidSeed(): Unit = ???

  override def isValidTransfer(): Unit = ???

  override def isValue(): Unit = ???

  override def toTrytes(): Unit = ???

  override def trytes(): Unit = ???

  override def trits(): Unit = ???

  override def validateSignatures(): Unit = ???

  override def getKey(): Unit = ???

  override def getDigest(): Unit = ???

  override def finalizeAddress(): Unit = ???

  override def validateAddress(): Unit = ???

  override def addSignature(): Unit = ???
}
