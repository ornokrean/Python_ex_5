package filesprocessing.Exceptions;


/**
 * This Class extends TypeOneException. this exception is kind of oneTypeException called when the problem
 * is in the Filter line
 */
public class FilterException extends TypeOneException {
	private static final long serialVersionUID = 1L;

	/**
	 * constructor
	 */
	public FilterException() {
		super(WARNING);
	}

	/**
	 * Constructor
	 *
	 * @param s - message to pass
	 */
	public FilterException(String s) {
		super(s);
	}

}
