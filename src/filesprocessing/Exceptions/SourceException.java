package filesprocessing.Exceptions;

/**
 * This Class extends TypeTwoException. this exception is kind of TypeTwoException called when the problem
 * is in the source files
 */
public class SourceException extends TypeTwoException {
	private static final long serialVersionUID = 1L;

	/* message of the exception*/
	private static final String MESSAGE = "ERROR: No files in sourcedir\n";

	public SourceException() {
		super(MESSAGE);
	}

	/**
	 * Constructor
	 *
	 * @param s - message to print
	 */
	public SourceException(String s) {
		super(s);
	}

}
