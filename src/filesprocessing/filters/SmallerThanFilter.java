package filesprocessing.filters;

import java.io.File;

public class SmallerThanFilter extends Filter{
	public boolean passFilter(File f, String[] args){
		return (f.length() < Long.parseLong(args[1]));
	}
}
