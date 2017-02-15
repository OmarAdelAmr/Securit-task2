package task;

/**
 * The class that contains the algorithm to break the Vigenere cipher should
 * implement this CipherBreaker interface.
 * 
 */
public interface CipherBreaker {

	/**
	 * Method to set the cipher text required to break
	 * 
	 * @param text
	 */
	public void setCipherText(String text);

	/**
	 * Method to compute the best key length
	 * 
	 * @return the best key length
	 */
	public int computeKeyLength();

	/**
	 * Method to compute the plain text and return it deciphered
	 * 
	 * @return the deciphered text
	 */
	public String getPlainText();

	/**
	 * Method to compute the key used in encrypting the text and return it
	 * 
	 * @return the key used in encryption
	 */
	public String getKey();

	/**
	 * Method to decipher the previously set cipher text
	 */
	public void decipherText();

}
