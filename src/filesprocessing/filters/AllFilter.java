package filesprocessing.filters;

import java.io.File;

public class AllFilter  extends Filter {
	public boolean passFilter(File f, String[] args) throws FilterException {
		if (args.length != 1) {
			throw new FilterException();
		}

		return (!f.isDirectory());
	}
}
