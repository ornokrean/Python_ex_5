package filesprocessing.Exceptions;


/**
 * This Class extends TypeTwoException. this exception is kind of TypeTwoException called when the problem
 * is in the file format
 */
public class BadFormatException extends TypeTwoException {


		private static final long serialVersionUID = 1L;
		private static final String MESSAGE = "ERROR: Bad format of Commands File\n";
	/**
	 * constructor
	 */
		public BadFormatException() {
			super(MESSAGE);
		}
		public BadFormatException(String s){
			super(s);
		}

	}

