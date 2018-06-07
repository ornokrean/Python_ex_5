package filesprocessing.filters;



/**
 *
 */
public class FilterException extends Exception {
	/* */
	private static final long serialVersionUID = 1L;
	private static final String WARNING_LINE_MSG = "Warning in line %d\n";

	/**
	 * constructor-  get the line number that have a problem and print Exception
	 */
	public FilterException() {
		super(WARNING_LINE_MSG);
	}

	/**
	 *
	 * @param s
	 */
	public FilterException(String s) {
		super(s);
	}

}
