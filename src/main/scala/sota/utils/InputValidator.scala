package sota.utils

import org.apache.commons.lang3.math.NumberUtils
import sota.error.ArgumentException
import sota.model.Transfer
import sota.utils.Constants._

/**
  * This class provides methods to validate the parameters of different iota API methods.
  *
  * @author hamza
  **/

object InputValidator {

  /**
    * Determines whether the specified string is an address.
    *
    * @param address The address to validate.
    * @return <code>true</code> if the specified string is an address; otherwise, <code>false</code>.
    **/
  def isAddress(address: String): Boolean = (address.length == ADDRESS_LENGTH_WITHOUT_CHECKSUM ||
    address.length == ADDRESS_LENGTH_WITH_CHECKSUM) && isTrytes(address, address.length)

  /**
    * Determines whether the specified string contains only characters from the trytes alphabet (see <see cref="Constants.TryteAlphabet"/>).
    *
    * @param trytes The trytes to validate.
    * @param length The length.
    * @return <code>true</code> if the specified trytes are trytes otherwise, <code>false</code>.
    **/
  def isTrytes(trytes: String, length: Int): Boolean = trytes.matches("^[A-Z9]{" + (if (length == 0) "0,"
  else length) + "}$")

  /**
    * Determines whether the specified addresses are valid.
    *
    * @param addresses The address list to validate.
    * @return <code>true</code> if the specified addresses are valid; otherwise, <code>false</code>.
    **/

  //TODO need to verify this function working

  @throws[ArgumentException]
  def isAddressesCollectionValid(addresses: List[String]): Boolean = {
    val addressStatus = addresses.exists(!checkAddress(_))
    !addressStatus
  }

  /**
    * Checks whether the specified address is an address and throws and exception if the address is invalid.
    *
    * @param address The address to validate.
    * @return <code>true</code> if the specified string is an address; otherwise, <code>false</code>.
    * @throws ArgumentException is thrown when the specified input is not valid.
    **/
  @throws[ArgumentException]
  def checkAddress(address: String): Boolean = {
    if (!isAddress(address)) throw new ArgumentException(INVALID_ADDRESSES_INPUT_ERROR)
    true
  }

  /**
    * Determines whether the specified string consist only of '9'.
    *
    * @param trytes The trytes to validate.
    * @param length The length.
    * @return <code>true</code> if the specified string consist only of '9'; otherwise, <code>false</code>.
    **/
  def isNinesTrytes(trytes: String, length: Int): Boolean = trytes.matches("^[9]{" + (if (length == 0) "0,"
  else length) + "}$")


  /**
    * Determines whether the specified string represents a signed integer.
    *
    * @param value The value to validate.
    * @return <code>true</code> the specified string represents an integer value; otherwise, <code>false</code>.
    **/
  def isValue(value: String): Boolean = NumberUtils.isCreatable(value)

  /**
    * Determines whether the specified string array contains only trytes.
    *
    * @param trytes The trytes array to validate.
    * @return <code>true</code> if the specified array contains only valid trytes otherwise, <code>false</code>.
    **/

  // TODO need to verify its working
  def isListOfTrytes(trytes: List[String]): Boolean = {
    val checkBoolen = trytes.exists(!isTrytes(_, 2673))
    !checkBoolen
  }

  /**
    * Determines whether the specified array contains only valid hashes.
    *
    * @param hashes The hashes array to validate.
    * @return <code>true</code> the specified array contains only valid hashes; otherwise, <code>false</code>.
    **/
  def isListOfHashes(hashes: List[String]): Boolean = {
    if (hashes.nonEmpty) {
      if (hashes.exists(hash => (hash.length == 90 && !isTrytes(hash, 90)) || (!isTrytes(hash, 81)))) false
      else true
    } else false
  }

  /**
    * Checks if the seed is valid. If not, an exception is thrown.
    *
    * @param seed The seed to validate.
    * @return <code>true</code> if the specified seed is valid; otherwise, <code>false</code>.
    **/
  def isValidSeed(seed: String): Boolean = isTrytes(seed, seed.length)

  /**
    * Checks if input is correct hashes.
    *
    * @param hashes The hashes list to validate.
    * @return <code>true</code> if the specified hashes are valid; otherwise, <code>false</code>.
    **/
  def isHashes(hashes: List[String]): Boolean = {
    if (hashes.exists(!isTrytes(_, 81))) false
    else true
  }

  /**
    * Determines whether the specified transfers are valid.
    *
    * @param transfers The transfers list to validate.
    * @return <code>true</code> if the specified transfers are valid; otherwise, <code>false</code>.
    **/
  @throws[ArgumentException]
  def isTransfersCollectionValid(transfers: List[Transfer]): Boolean = { // Input validation of transfers object
    if (transfers == null || transfers.isEmpty) throw new ArgumentException(INVALID_TRANSFERS_INPUT_ERROR)
    for (transfer <- transfers) {
      if (!isValidTransfer(transfer)) return false
    }
    true
  }

  /**
    * Determines whether the specified transfer is valid.
    *
    * @param transfer The transfer to validate.
    * @return <code>true</code> if the specified transfer is valid; otherwise, <code>false</code>>.
    **/
  def isValidTransfer(transfer: Transfer): Boolean = {
    if (transfer == null) false
    else if (!isAddress(transfer.address)) false
    // Check if message is correct trytes encoded of any length
    else if (transfer.message == null || !isTrytes(transfer.message, transfer.message.length)) false
    // Check if tag is correct trytes encoded and not longer than 27 trytes
    else if (transfer.tag == null || !isTrytes(transfer.tag, transfer.tag.length) || transfer.tag.length > Constants.TAG_LENGTH) false
    else true
  }

  /**
    * Checks if attached trytes if last 241 trytes are non-zero
    *
    * @param trytes The trytes.
    * @return <code>true</code> if the specified trytes are valid; otherwise, <code>false</code>.
    **/
  def isListOfAttachedTrytes(trytes: List[String]): Boolean = {
    for (tryteValue <- trytes) { // Check if correct 2673 trytes
      if (!isTrytes(tryteValue, 2673)) return false
      val lastTrytes = tryteValue.substring(2673 - (3 * 81))
      if (isNinesTrytes(lastTrytes, lastTrytes.length)) return false
    }
    true
  }

}
