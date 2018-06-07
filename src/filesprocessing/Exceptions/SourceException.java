package filesprocessing.Exceptions;

public class SourceException extends TypeTwoException{
	private static final String MESSAGE = "ERROR: No files in sourcedir\n";
	public SourceException() {
		super(MESSAGE);
	}
	public SourceException(String s){
		super(s);
	}

}
