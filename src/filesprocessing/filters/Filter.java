package filesprocessing.filters;

import java.io.File;

public abstract class Filter {
	public Filter(){

	}
	public abstract boolean checkCommand(String[] command) throws FilterException;
	public abstract boolean passFilter(File file, String[] args);

}
