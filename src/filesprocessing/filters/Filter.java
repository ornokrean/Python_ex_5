package filesprocessing.filters;

import java.io.File;

public abstract class Filter {
	public Filter(){

	}
	public abstract boolean passFilter(File f, String[] args)  throws FilterException ;



}
