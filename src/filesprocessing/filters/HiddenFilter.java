package filesprocessing.filters;

import java.io.File;

public class HiddenFilter extends Filter{
	public boolean passFilter(File file, String[] args) {

		if (args[1].equals("YES")){
			return file.isHidden();
		}
		return (!file.isHidden());
	}
	@Override
	public boolean checkCommand(String[] command) throws FilterException{
		if (command.length != 2 || (!command[1].equals("NO") && !command[1].equals("YES"))) {
			throw new FilterException();
		}
		return true;
	}
}
