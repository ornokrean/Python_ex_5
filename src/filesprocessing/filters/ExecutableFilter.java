package filesprocessing.filters;

import java.io.File;

public class ExecutableFilter {
	public boolean passFilter(File f, String[] args){
		return f.canExecute();
	}
}
