package filesprocessing.filters;

import java.io.File;

public class WritableFilter extends Filter {
	public boolean passFilter(File file, String[] args) {

		if (args[1].equals("YES")){
			return file.canWrite();
		}
		return (!file.canWrite());
	}

	@Override
	public boolean checkCommand(String[] command) throws FilterException{
		if (command.length != 2 || (!command[1].equals("NO") && !command[1].equals("YES"))) {
			throw new FilterException();
		}
		return true;
	}
}
