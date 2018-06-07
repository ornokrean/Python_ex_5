package filesprocessing.Exceptions;



/**
 * This Class extends Exception. this exception is kind of oneTypeException called when the problem is in
 * the FILTER line
 */
public class FilterException extends TypeOneException {
	/* */
	private static final long serialVersionUID = 1L;

	/**
	 * constructor
	 */
	public FilterException() {
		super(WARNING);
	}
	/**
	 *
	 * @param s
	 */
	public FilterException(String s) {
		super(s);
	}

}
