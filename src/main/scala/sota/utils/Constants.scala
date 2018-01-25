package sota.utils

/**
  * This class defines the global constants.
  *
  * @author hamza
  */
object Constants {
  /**
    * This String contains all possible characters of the tryte alphabet
    */
  val TRYTE_ALPHABET = "9ABCDEFGHIJKLMNOPQRSTUVWXYZ"

  /**
    * The maximum seed length
    */
  val SEED_LENGTH_MAX = 81

  /**
    * The length of an address without checksum
    */
  var ADDRESS_LENGTH_WITHOUT_CHECKSUM = 81

  /**
    * The length of an address with checksum
    */
  var ADDRESS_LENGTH_WITH_CHECKSUM = 90

  /**
    * The length of an message
    */
  var MESSAGE_LENGTH = 2187

  /**
    * The length of an tag
    */
  var TAG_LENGTH = 27

  val INVALID_TRYTES_INPUT_ERROR = "Invalid trytes provided."
  val INVALID_HASHES_INPUT_ERROR = "Invalid hashes provided."
  val INVALID_TAIL_HASH_INPUT_ERROR = "Invalid tail hash provided."
  val INVALID_SEED_INPUT_ERROR = "Invalid seed provided."
  val INVALID_SECURITY_LEVEL_INPUT_ERROR = "Invalid security level provided."
  val INVALID_ATTACHED_TRYTES_INPUT_ERROR = "Invalid attached trytes provided."
  val INVALID_TRANSFERS_INPUT_ERROR = "Invalid transfers provided."
  val INVALID_ADDRESSES_INPUT_ERROR = "Invalid addresses provided."
  val INVALID_INPUT_ERROR = "Invalid input provided."

  val INVALID_BUNDLE_ERROR = "Invalid bundle."
  val INVALID_BUNDLE_SUM_ERROR = "Invalid bundle sum."
  val INVALID_BUNDLE_HASH_ERROR = "Invalid bundle hash."
  val INVALID_SIGNATURES_ERROR = "Invalid signatures."
  val INVALID_VALUE_TRANSFER_ERROR = "Invalid value transfer: the transfer does not require a signature."

  val NOT_ENOUGH_BALANCE_ERROR = "Not enough balance."
  val NO_REMAINDER_ADDRESS_ERROR = "No remainder address defined."

  val GET_TRYTES_RESPONSE_ERROR = "Get trytes response was null."
  val GET_BUNDLE_RESPONSE_ERROR = "Get bundle response was null."
  val GET_INCLUSION_STATE_RESPONSE_ERROR = "Get inclusion state response was null."

  val SENDING_TO_USED_ADDRESS_ERROR = "Sending to a used address."
  val PRIVATE_KEY_REUSE_ERROR = "Private key reuse detect!"
  val SEND_TO_INPUTS_ERROR = "Send to inputs!"
}
