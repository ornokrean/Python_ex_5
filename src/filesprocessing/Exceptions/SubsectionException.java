package filesprocessing.Exceptions;

/**
 * This Class extends TypeTwoException. this exception is kind of TypeTwoException called when the problem
 * is in subsection in the command file
 */
public class SubsectionException extends TypeTwoException {
	private static final long serialVersionUID = 1L;

	/* the message of exception */
	private static final String ERROR_SUBSECTION_NAME = "ERROR: Bad subsection name\n";


	public SubsectionException() {
		super(ERROR_SUBSECTION_NAME);
	}

	/**
	 * Constructor
	 *
	 * @param s - message to print
	 */
	public SubsectionException(String s) {
		super(s);
	}

}
