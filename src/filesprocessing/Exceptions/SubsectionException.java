package filesprocessing.Exceptions;

/**
 *
 */
public class SubsectionException extends TypeTwoException {

	private static final String ERROR_SUBSECTION_NAME = "ERROR: Bad subsection name\n";

	/**
	 *
	 */
	public SubsectionException() {
			super(ERROR_SUBSECTION_NAME);
		}
	public SubsectionException(String s){
		super(s);
	}

	}
