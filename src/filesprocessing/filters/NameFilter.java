package filesprocessing.filters;

import java.io.File;

public class NameFilter  extends Filter{
	public boolean passFilter(File f, String[] args){
		return (f.getName().equals(args[1]));
	}
}
