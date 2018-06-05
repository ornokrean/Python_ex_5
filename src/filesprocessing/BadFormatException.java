package filesprocessing;

public class BadFormatException extends TypeTwoException {


		private static final long serialVersionUID = 1L;

		public BadFormatException() {
			super("ERROR: Bad format of Commands File\n");
		}
		public BadFormatException(String s){
			super(s);
		}

	}

