package filesprocessing.filters;

import java.io.File;

public class HiddenFilter {
	public boolean passFilter(File f, String[] args){
		return f.isHidden();
	}
}
