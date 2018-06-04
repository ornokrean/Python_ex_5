
package filesprocessing.filters;

import java.io.File;

public class BetweenFilter extends Filter {
	private static final double SIZE_FACTOR = 1024.0;

	public boolean passFilter(File file, String[] args) {

		double size = file.length() / SIZE_FACTOR;
		double upper_bound = Double.parseDouble(args[2].replace(" ", ""));
		double lower_bound = Double.parseDouble(args[1].replace(" ", ""));
		return (lower_bound <= size && size <= upper_bound);
	}
	@Override
	public boolean checkCommand(String[] command) throws FilterException{
		double upper_bound = Double.parseDouble(command[2].replace(" ", ""));
		double lower_bound = Double.parseDouble(command[1].replace(" ", ""));
		if (command.length != 3 || lower_bound < 0 || upper_bound < lower_bound) {
			throw new FilterException();
		}
		return true;
	}
}
