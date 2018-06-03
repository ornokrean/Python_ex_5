package filesprocessing.filters;

import java.io.File;

public class ExecutableFilter extends Filter {
	public boolean passFilter(File file, String[] args) throws FilterException {
		if (args.length != 2 || (!args[1].equals("NO") && !args[1].equals("YES"))) {
			throw new FilterException();
		}
		if (args[1].equals("YES")){
			return file.canExecute();
		}
		return (!file.canExecute());
	}
}
