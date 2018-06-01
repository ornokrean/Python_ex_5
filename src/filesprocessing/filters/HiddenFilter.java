package filesprocessing.filters;

import java.io.File;

public class HiddenFilter extends Filter{
	public boolean passFilter(File f, String[] args){
		return f.isHidden();
	}
}
