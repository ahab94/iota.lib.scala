package sota.model

/**
  * This class represents a Bundle, a set of transactions.
  *
  * @author ahab94
  **/

case class Bundle(EMPTY_HASH: String = "999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                  transactions: Transaction,
                  length: Int)
