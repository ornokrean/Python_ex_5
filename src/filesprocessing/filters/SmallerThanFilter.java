package filesprocessing.filters;

import java.io.File;

public class SmallerThanFilter extends Filter{
	private static final long SIZE_FACTOR = 1024;
	public boolean passFilter(File f, String[] args) throws FilterException {
		long bound =  (long) Double.parseDouble(args[1].replace(" ",""));

		if (args.length != 2 || bound < 0) {
			throw new FilterException();
		}
		long size = f.length()/SIZE_FACTOR;
		return (size < bound);
	}
}
