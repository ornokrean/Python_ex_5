package filesprocessing.Exceptions;

/**
 * This Class extends Exception. this exception is oneTypeException called when the problem is in
 * the line but we can make the default order or filter
 */
public class TypeOneException extends Exception {

	/* the message we print */
	static final String WARNING ="Warning in line %d\n";

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param s-message to pass
	 */
	public TypeOneException(String s){
		super(s);
	}

}
