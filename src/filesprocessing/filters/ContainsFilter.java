package filesprocessing.filters;

import java.io.File;

public class ContainsFilter extends Filter{
	public boolean passFilter(File f, String[] args){
		return (f.getName().contains(args[1]));
	}
}
