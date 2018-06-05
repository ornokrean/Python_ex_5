package filesprocessing;

public class SubsectionException extends TypeTwoException{

		private static final long serialVersionUID = 1L;

		public SubsectionException() {
			super("ERROR: Bad subsection name\n");
		}
		public SubsectionException(String s){
			super(s);
		}

	}
