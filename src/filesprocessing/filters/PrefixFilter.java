package filesprocessing.filters;

import filesprocessing.FileProcessingExceptions.FilterException;

import java.io.File;

/**
 * Filter that checks if the prefix of the file name is as the given value. Extends Filter class.
 */
public class PrefixFilter extends Filter {
	/**
	 * check if the file was filtered
	 *
	 * @param file - the File
	 * @param args - the values of the filter
	 * @return - true if the file filtered , else false
	 */
	public boolean passFilter(File file, String[] args) {
		return (file.getName().startsWith(args[FIRST_ARG_PLACE]));
	}

	/**
	 * @param command - the command that appear in the line
	 * @return -true if the command was legals , else false
	 * @throws FilterException - if the command was not legals
	 */
	@Override
	public boolean checkCommand(String[] command) throws FilterException {
		if (command.length != REGULAR_NUM_OF_ARGS) {
			throw new FilterException();
		}
		return true;
	}
}