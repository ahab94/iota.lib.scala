package sota.model

/**
  * This class represents an Neighbor.
  *
  * @author ahab94
  **/
case class Neighbor(address: String,
                    numberOfAllTransactions: Integer,
                    numberOfInvalidTransactions: Integer,
                    numberOfNewTransactions: Integer,
                    numberOfRandomTransactionRequests: Integer,
                    numberOfSentTransactions: Integer,
                    connectionType: String)
