package sota.model

import jota.pow.ICurl

case class Transaction(hash: String,
                       signatureFragments: String,
                       address: String,
                       value: Long,
                       obsoleteTag: String,
                       timestamp: Long,
                       currentIndex: Long,
                       lastIndex: Long,
                       bundle: String,
                       trunkTransaction: String,
                       branchTransaction: String,
                       nonce: String,
                       persistence: Boolean,
                       attachmentTimestamp: Long,
                       tag: String,
                       attachmentTimestampLowerBound: Long,
                       attachmentTimestampUpperBound: Long,
                       customCurl: ICurl = null) {
  //TODO::add logic
}
