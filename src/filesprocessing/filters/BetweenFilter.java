package filesprocessing.filters;

import filesprocessing.FileProcessingExceptions.FilterException;

import java.io.File;

/**
 * Filter that checks if file size is between (inclusive) the given numbers (in k-bytes). Extends Filter
 * class.
 */
public class BetweenFilter extends Filter {

	/* the upper bound of the filter*/
	private double upper_bound;
	/* the lower bound of the filter*/
	private double lower_bound;

	/**
	 * check if the file was filtered
	 *
	 * @param file - the File
	 * @param args - the values of the filter
	 * @return - true if the file filtered , else false
	 */
	public boolean passFilter(File file, String[] args) {
		double size = file.length() / SIZE_FACTOR;
		return (this.lower_bound <= size && size <= this.upper_bound);
	}

	/**
	 * @param command - the command that appear in the line
	 * @return -true if the command was legals , else false
	 * @throws FilterException - if the command was not legals
	 */
	@Override
	public boolean checkCommand(String[] command) throws FilterException {
		// check for NumberFormatException
		try {
			this.upper_bound = getBound(command[SEC_ARGS_PLACE]);
			this.lower_bound = getBound(command[FIRST_ARG_PLACE]);
		} catch (NumberFormatException e) {
			throw new FilterException();
		}
		// check the arguments:
		if (command.length != SPACIAL_NUM_OF_ARGS || this.lower_bound < 0 ||
				this.upper_bound < this.lower_bound) {
			throw new FilterException();
		}
		return true;
	}


}
