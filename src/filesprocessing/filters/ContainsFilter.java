package filesprocessing.filters;

import java.io.File;

public class ContainsFilter extends Filter {

	public boolean passFilter(File f, String[] args) throws FilterException {
		if (args.length != 2) {
			throw new FilterException();
		}
		return (f.getName().contains(args[1]));
	}
}
