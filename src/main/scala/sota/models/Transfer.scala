package sota.models

case class Transfer(
                     timestamp: String,
                     address: String,
                     hash: String,
                     persistence: Boolean,
                     value: Long,
                     message: String,
                     tag: String
                   )
