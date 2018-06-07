package filesprocessing.Exceptions;

/**
 * This Class extends Exception. this exception is kind of oneTypeException called when the problem is in
 * the Order line
 */
public class OrderException extends TypeOneException {

    /**
     * constructor- get the line number that have a problem and print Exception
     */
	public OrderException() {
		super(WARNING);
	}
	public OrderException(String s) {
		super(s);
	}


}
