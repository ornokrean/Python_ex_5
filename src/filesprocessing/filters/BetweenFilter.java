package filesprocessing.filters;

import java.io.File;

public class BetweenFilter extends Filter {
	private static final int SIZE_FACTOR = 1024;

	public boolean passFilter(File f, String[] args) throws FilterException{
		if (args.length != 3) {
			throw new FilterException();
		}
		long upper_bound = (long) Double.parseDouble(args[1].replace(" ",""));
		long lower_bound = (long) Double.parseDouble(args[2].replace(" ",""));
		long size = f.length() / SIZE_FACTOR;

		return (lower_bound >= 0 && upper_bound >= lower_bound && lower_bound <= size && size <= upper_bound);
	}
}
