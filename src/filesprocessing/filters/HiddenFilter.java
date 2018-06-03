package filesprocessing.filters;

import java.io.File;

public class HiddenFilter extends Filter{
	public boolean passFilter(File f, String[] args) throws FilterException {
		if (args.length != 2 || (!args[1].equals("NO") && !args[1].equals("YES"))) {
			throw new FilterException();
		}
		if (args[1].equals("YES")){
			return f.isHidden();
		}
		return (!f.isHidden());
	}
}
