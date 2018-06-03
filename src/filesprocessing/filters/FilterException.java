package filesprocessing.filters;

public class FilterException extends Exception {
	private static final long serialVersionUID = 1L;

	public FilterException() {
		super("Warning in line %d \n");
	}

	public FilterException(String s) {
		super(s);
	}

}
