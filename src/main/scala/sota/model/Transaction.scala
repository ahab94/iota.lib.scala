package sota.model

import java.util

import jota.pow.{ICurl, SpongeFactory}
import jota.utils.Converter

trait Trx


case class TrxModel(hash: String = null,
                    signatureFragments: String = null,
                    address: String = null,
                    value: Long = 0L,
                    obsoleteTag: String = null,
                    timestamp: Long = 0L,
                    currentIndex: Long = 0L,
                    lastIndex: Long = 0L,
                    bundle: String = null,
                    trunkTransaction: String = null,
                    branchTransaction: String = null,
                    nonce: String = null,
                    persistence: Boolean = false,
                    attachmentTimestamp: Long = 0L,
                    tag: String = null,
                    attachmentTimestampLowerBound: Long = 0L,
                    attachmentTimestampUpperBound: Long = 0L) extends Trx

case class TryteWrap(tryte: String) extends Trx

case class TryteWithCurl(tryte: String, iCurl: ICurl)

class Transaction(trxOpt: Option[Trx] = None) {

  var customCurl: Option[ICurl] = None

  val trx: Option[TrxModel] = trxOpt match {
    case Some(tryteWrap: TryteWrap) =>
      calculateTransaction(tryteWrap.tryte)
    case Some(tryteWithCurl: TryteWithCurl) =>
      customCurl = Some(tryteWithCurl.iCurl)
      calculateTransaction(tryteWithCurl.tryte)
    case any => None
  }

  def calculateTransaction(tryte: String): Option[TrxModel] = {
    tryte match {
      case tryte: String if tryte.nonEmpty =>
        if (validateTryte(tryte)) {
          val transactionTrits = Converter.trits(tryte)
          val hash: List[Int] = List[Int](243)
          val curl = SpongeFactory.create(SpongeFactory.Mode.CURLP81)
          curl.reset
          curl.absorb(transactionTrits, 0, transactionTrits.length)
          curl.squeeze(hash.toArray, 0, hash.length)
          val generatedHash = Converter.trytes(hash.toArray)
          val sigFragments = tryte.substring(0, 2187)
          val address = tryte.substring(2187, 2268)
          val value = Converter.longValue(util.Arrays.copyOfRange(transactionTrits, 6804, 6837))
          val obsoleteTag = tryte.substring(2295, 2322)
          val timestamp = Converter.longValue(util.Arrays.copyOfRange(transactionTrits, 6966, 6993))
          val currentIdx = Converter.longValue(util.Arrays.copyOfRange(transactionTrits, 6993, 7020))
          val lastIdx = Converter.longValue(util.Arrays.copyOfRange(transactionTrits, 7020, 7047))
          val bundle = tryte.substring(2349, 2430)
          val trunkTrx = tryte.substring(2430, 2511)
          val branchTrx = tryte.substring(2511, 2592)
          val nonce = tryte.substring(2646, 2673)
          val attachmentTs = Converter.longValue(util.Arrays.copyOfRange(transactionTrits, 7857, 7884))
          val attachmentTsLower = Converter.longValue(util.Arrays.copyOfRange(transactionTrits, 7884, 7911))
          val attachmentTsUpper = Converter.longValue(util.Arrays.copyOfRange(transactionTrits, 7911, 7938))
          val tag = tryte.substring(2592, 2619)
          Some(TrxModel(
            hash = generatedHash
            , signatureFragments = sigFragments
            , address = address
            , value = value
            , obsoleteTag = obsoleteTag
            , timestamp = timestamp
            , currentIndex = currentIdx
            , lastIndex = lastIdx
            , bundle = bundle
            , trunkTransaction = trunkTrx
            , branchTransaction = branchTrx
            , nonce = nonce
            , attachmentTimestamp = attachmentTs
            , tag = tag
            , attachmentTimestampLowerBound = attachmentTsLower
            , attachmentTimestampUpperBound = attachmentTsUpper))
        }
        else {
          None
        }
      case tryte: String if tryte.isEmpty => None
      case _ => None
    }
  }

  def validateTryte(tryte: String): Boolean = {
    val i = 2279
    val limit = 2295
    while (i < limit) {
      if (tryte.charAt(i) != '9') {
        //invalid
        return false
      }
    }
    true
  }
}
