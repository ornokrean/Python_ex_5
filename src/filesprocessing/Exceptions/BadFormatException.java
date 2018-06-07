package filesprocessing.Exceptions;


/**
 * This Class extends TypeTwoException. this exception is kind of TypeTwoException called when the problem
 * is in the file format
 */
public class BadFormatException extends TypeTwoException {


	private static final long serialVersionUID = 1L;
	/* message of the exception*/
	private static final String MESSAGE = "ERROR: Bad format of Commands File\n";

	/**
	 * constructor
	 */
	public BadFormatException() {
		super(MESSAGE);
	}

	/**
	 * Constructor
	 *
	 * @param s - message to print
	 */
	public BadFormatException(String s) {
		super(s);
	}

}

