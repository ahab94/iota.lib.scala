package sota.apis

trait IotaAPICoreRef {

  def getTransactionsObjects()

  def findTransactionObjects()

  def getLatestInclusion()

  def broadcastAndStore()

  def getNewAddress()

  def getInputs()

  def prepareTransfers()

  def sendTrytes()

  def sendTransfer()

  def replayBundle()

  def getBundle()

  def getTransfers()

  def initiateTransfer()

  def getAccountData()

  def convertUnits()

  def addChecksum()

  def removeChecksum()

  def isValidChecksum()

  def checkAddress()

  def isAddress()

  def isArrayOfHashes()

  def isArrayOfTrytes()

  def inNinesTrytes()

  def isTransfersCollectionValid()

  def isTrytes()

  def isValidSeed()

  def isValidTransfer()

  def isValue()

  def toTrytes()

  def trytes()

  def trits()

  def validateSignatures()

  def getKey()

  def getDigest()

  def finalizeAddress()

  def validateAddress()

  def addSignature()

}
