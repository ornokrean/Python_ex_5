package filesprocessing.filters;

import java.io.File;

public class NameFilter  extends Filter{
	public boolean passFilter(File file, String[] args) {

		return (file.getName().equals(args[1]));
	}
	@Override
	public boolean checkCommand(String[] command) throws FilterException{
		if (command.length != 2) {
			throw new FilterException();
		}
		return true;
	}
}
