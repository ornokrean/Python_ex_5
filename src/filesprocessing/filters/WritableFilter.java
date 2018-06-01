package filesprocessing.filters;

import java.io.File;

public class WritableFilter extends Filter{
	public boolean passFilter(File f, String[] args){
		return f.canWrite();
	}
}
