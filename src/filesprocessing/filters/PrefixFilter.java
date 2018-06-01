package filesprocessing.filters;

import java.io.File;

public class PrefixFilter extends Filter{
	public boolean passFilter(File f, String[] args){
		return (f.getName().startsWith(args[1]));
	}
}