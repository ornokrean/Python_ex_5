package filesprocessing.filters;

import java.io.File;

public class GreaterThanFilter extends Filter {
	private static final int SIZE_FACTOR = 1024;

	public boolean passFilter(File f, String[] args)  throws FilterException {
		long bound = (long) Double.parseDouble(args[1].replace(" ",""));

		if (args.length != 2 || bound < 0) {
			throw new FilterException();
		}
		long size = f.length() / SIZE_FACTOR;
		return (bound <= size);
	}
}


