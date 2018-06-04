package filesprocessing.filters;

import java.io.File;


public class GreaterThanFilter extends Filter {
	private static final double SIZE_FACTOR = 1024.0;

	public boolean passFilter(File file, String[] args) {
		double bound =  Double.parseDouble(args[1].replace(" ",""));
		double size = file.length() / SIZE_FACTOR;

		return (bound<size);
	}
	@Override
	public boolean checkCommand(String[] command) throws FilterException{
		double bound =  Double.parseDouble(command[1].replace(" ",""));
		if (command.length != 2 || bound < 0) {
			throw new FilterException();
		}
		return true;
	}
}


