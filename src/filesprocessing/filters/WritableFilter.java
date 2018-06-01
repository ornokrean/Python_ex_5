package filesprocessing.filters;

import java.io.File;

public class WritableFilter {
	public boolean passFilter(File f, String[] args){
		return f.canWrite();
	}
}
