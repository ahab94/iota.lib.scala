package sota.utils

import org.apache.commons.lang3.math.NumberUtils
import sota.error.ArgumentException
import sota.utils.Constants._
/**
  * This class provides methods to validate the parameters of different iota API methods.
  *
  *  @author hamza
  **/

class InputValidator {

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
    for (address <- addresses) {
      if (!checkAddress(address)) return false
    }
    true
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
  def isArrayOfTrytes(trytes: List[String]): Boolean = {
    val checkBoolen = trytes.exists(!isTrytes(_, 2673))
    !checkBoolen
  }


}
