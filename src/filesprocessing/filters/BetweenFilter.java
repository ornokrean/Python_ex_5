package filesprocessing.filters;

import java.io.File;

public class BetweenFilter extends Filter {
	private static final double SIZE_FACTOR = 1024.0;

	private double upper_bound;
	private double lower_bound;

	public boolean passFilter(File file, String[] args) {

		double size = file.length() / SIZE_FACTOR;

		return (this.lower_bound <= size && size <= this.upper_bound);
	}

	@Override
	public boolean checkCommand(String[] command) throws FilterException {
		// check for NumberFormatException
		try {
			this.upper_bound = Double.parseDouble(command[2].replace(" ", ""));
			this.lower_bound = Double.parseDouble(command[1].replace(" ", ""));
		} catch (NumberFormatException e) {
			throw new FilterException();
		}
		// check the arguments:
		if (command.length != 3 || lower_bound < 0 || upper_bound < lower_bound) {
			throw new FilterException();
		}


		return true;
	}
}
