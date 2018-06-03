package filesprocessing.filters;

import java.io.File;

public class BetweenFilter extends Filter {
	private static final double SIZE_FACTOR = 1024.0;

	public boolean passFilter(File f, String[] args) throws FilterException{
		long upper_bound = (long) Double.parseDouble(args[2].replace(" ",""));
		long lower_bound = (long) Double.parseDouble(args[1].replace(" ",""));
		if (args.length != 3 || lower_bound < 0 || upper_bound < lower_bound) {
			throw new FilterException();
		}
		double size = f.length() / SIZE_FACTOR;

		return (lower_bound <= size && size <= upper_bound);
	}
}
