package filesprocessing.filters;

import java.io.File;

public class GreaterThanFilter extends Filter {
	private static final int SIZE_FACTOR = 1024;

	public boolean passFilter(File f, String[] args) {
		long bound = Long.parseLong(args[1]);
		long size = f.length() / SIZE_FACTOR;
		return (bound >= 0 && bound <= size);
	}
}


