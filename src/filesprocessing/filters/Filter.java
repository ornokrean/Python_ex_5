package filesprocessing.filters;

import java.io.File;

public abstract class Filter {
	public abstract boolean passFilter(File f, String[] args);

	public boolean passReverse(File f, String[] args) {
		return !passFilter(f, args);
	}


}
