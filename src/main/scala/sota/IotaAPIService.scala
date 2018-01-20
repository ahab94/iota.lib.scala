package sota

import com.softwaremill.sttp.ResponseAs

/**
  * IOTA API Proxy Service abstraction
  *
  * @author ahab94
  */

trait IotaAPIService {
  def getNodeInfo: ResponseAs[String, Nothing]

  def getNeighbors: ResponseAs[String, Nothing]

  def addNeighbors: ResponseAs[String, Nothing]

  def removeNeighbors: ResponseAs[String, Nothing]

  def getTips: ResponseAs[String, Nothing]

  def findTransactions: ResponseAs[String, Nothing]

  def getInclusionStates: ResponseAs[String, Nothing]

  def getTrytes: ResponseAs[String, Nothing]

  def getTransactionsToApprove: ResponseAs[String, Nothing]

  def getBalances: ResponseAs[String, Nothing]

  def attachToTangle: ResponseAs[String, Nothing]

  def interruptAttachingToTangle: ResponseAs[String, Nothing]

  def broadcastTransactions

  def storeTransactions
}