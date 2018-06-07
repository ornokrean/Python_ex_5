package filesprocessing.Exceptions;

/**
 * this class extends exception.
 * this is a kind of exception that alerts of fatal errors in the program given values.
 */
public class TypeTwoException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param s-message to pass
	 */
	public TypeTwoException(String s){
		super(s);
	}

}


