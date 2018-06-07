package filesprocessing.filters;

import filesprocessing.FileProcessingExceptions.FilterException;

import java.io.File;

/**
 * Filter that checks if file size is strictly greater than the given number of given k-bytes.  Extends
 * Filter class.
 */
public class GreaterThanFilter extends Filter {
	/* the upper bound of the filter*/
	private double bound;

	/**
	 * check if the file was filtered
	 *
	 * @param file - the File
	 * @param args - the values of the filter
	 * @return - true if the file filtered , else false
	 */
	public boolean passFilter(File file, String[] args) {
		//Ignore space in the number
		double size = file.length() / SIZE_FACTOR;
		return (this.bound < size);
	}

	/**
	 * @param command - the command that appear in the line
	 * @return -true if the command was legals , else false
	 * @throws FilterException - if the command was not legals
	 */
	@Override
	public boolean checkCommand(String[] command) throws FilterException {
		this.bound = getBound(command[FIRST_ARG_PLACE]);
		if (command.length != REGULAR_NUM_OF_ARGS || this.bound < 0) {
			throw new FilterException();
		}
		return true;
	}

}


