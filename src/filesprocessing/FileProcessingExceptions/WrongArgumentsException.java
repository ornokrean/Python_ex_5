
package filesprocessing.FileProcessingExceptions;


/**
 * This Class extends TypeTwoException. this exception is kind of TypeTwoException called when the problem
 * is in the number of arguments in the program
 */
public class WrongArgumentsException extends TypeTwoException {

	private static final long serialVersionUID = 1L;

	/* message of the exception*/
	private static final String MESSAGE = "ERROR: Wrong usage. Should receive 2 arguments\n";
	/**
	 * constructor
	 */
	public WrongArgumentsException() {
		super(MESSAGE);
	}

	/**
	 * Constructor
	 *
	 * @param s - message to print
	 */
	public WrongArgumentsException(String s) {
		super(s);
	}

}

