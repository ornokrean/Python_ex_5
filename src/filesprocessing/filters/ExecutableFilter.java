package filesprocessing.filters;

import java.io.File;

public class ExecutableFilter extends Filter {
	public boolean passFilter(File f, String[] args){
		return f.canExecute();
	}
}
