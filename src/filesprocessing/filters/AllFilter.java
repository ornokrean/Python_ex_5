package filesprocessing.filters;

import java.io.File;

public class AllFilter  extends Filter{
	public boolean passFilter(File f, String[] args){
		return (!f.isDirectory());
	}
}
