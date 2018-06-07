package filesprocessing.Exceptions;

/**
 * This Class extends Exception. this exception is kind of oneTypeException called when the problem is in
 * the Order line
 */
public class OrderException extends TypeOneException {

    /**
     * constructor
     */
	public OrderException() {
		super(WARNING);
	}

	/**
	 * Constructor
	 * @param s-message to pass
	 */
	public OrderException(String s) {
		super(s);
	}


}
