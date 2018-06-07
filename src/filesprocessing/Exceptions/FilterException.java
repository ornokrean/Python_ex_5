package filesprocessing.Exceptions;



/**
 *
 */
public class FilterException extends TypeOneException {
	/* */
	private static final long serialVersionUID = 1L;

	/**
	 * constructor-  get the line number that have a problem and print Exception
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
