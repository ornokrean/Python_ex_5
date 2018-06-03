package filesprocessing.filters;

import java.io.File;


public class GreaterThanFilter extends Filter {
	private static final double SIZE_FACTOR = 1024.0;

	public boolean passFilter(File f, String[] args)  throws FilterException {
		double bound =  Double.parseDouble(args[1].replace(" ",""));

		if (args.length != 2 || bound < 0) {
			throw new FilterException();
		}
		double size = f.length() / SIZE_FACTOR;

		return (bound<size);
	}
}


