package filesprocessing.filters;

import java.io.File;

public class WritableFilter extends Filter {
	public boolean passFilter(File f, String[] args) throws FilterException {
		if (args.length != 2 || (!args[1].equals("NO") && !args[1].equals("YES"))) {
			throw new FilterException();
		}
		return (f.canWrite() == args[1].equals("YES"));
	}
}
