package filesprocessing.Exceptions;

/**
 * This Class extends Exception. this exception is oneTypeException called when the problem is in
 * the line but we can make the default order or filter
 */
public class TypeOneException extends Exception {
	private static final long serialVersionUID = 1L;

	/* the message of exception */
	static final String WARNING ="Warning in line %d\n";

	/**
	 * Constructor
	 *
	 * @param s - message to print
	 */
	public TypeOneException(String s){
		super(s);
	}


}
