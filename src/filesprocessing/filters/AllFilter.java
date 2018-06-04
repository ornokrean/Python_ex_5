package filesprocessing.filters;

import java.io.File;

public class AllFilter  extends Filter {
	public boolean passFilter(File file, String[] args) {


		return (!file.isDirectory());
	}

	@Override
	public boolean checkCommand(String[] command) throws FilterException{
		if (command.length != 1) {
			throw new FilterException();
		}
		return true;
	}
}
