package filesprocessing.FileProcessingExceptions;

/**
 * This Class extends TypeOneException. this exception is kind of oneTypeException called when the problem
 * is in the Order line
 */
public class OrderException extends TypeOneException {
	private static final long serialVersionUID = 1L;

    /**
     * constructor
     */
	public OrderException() {
		super(WARNING);
	}

	/**
	 * Constructor
	 * @param s - message to pass
	 */
	public OrderException(String s) {
		super(s);
	}


}
