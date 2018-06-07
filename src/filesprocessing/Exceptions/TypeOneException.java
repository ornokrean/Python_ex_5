package filesprocessing.Exceptions;

public class TypeOneException extends Exception {
	static final String WARNING ="Warning in line %d\n";
	private static final long serialVersionUID = 1L;

	public TypeOneException(String s){
		super(s);
	}

}
