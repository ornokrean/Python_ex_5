package filesprocessing;

/**
 *
 */
class SubsectionException extends TypeTwoException{

	private static final long serialVersionUID = 1L;
	private static final String ERROR_SUBSECTION_NAME = "ERROR: Bad subsection name\n";

	/**
	 *
	 */
	SubsectionException() {
			super(ERROR_SUBSECTION_NAME);
		}
		public SubsectionException(String s){
			super(s);
		}

	}
