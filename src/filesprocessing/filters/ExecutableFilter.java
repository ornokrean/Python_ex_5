package filesprocessing.filters;

import filesprocessing.FileProcessingExceptions.FilterException;

import java.io.File;

/**
 * check if file have execution permission
 */
public class ExecutableFilter extends Filter {
	/**
	 * check if the file was filtered
	 *
	 * @param file - the File
	 * @param args - the values of the filter
	 * @return - true if the file filtered , else false
	 */
	public boolean passFilter(File file, String[] args) {
		if (args[FIRST_ARG_PLACE].equals(YES)) {
			return file.canExecute();
		}
		return (!file.canExecute());
	}

	/**
	 * @param command - the command that appear in the line
	 * @return -true if the command was legals , else false
	 * @throws FilterException - if the command was not legals
	 */
	@Override
	public boolean checkCommand(String[] command) throws FilterException {
		if (command.length != REGULAR_NUM_OF_ARGS || ifArgInvalid(command[FIRST_ARG_PLACE])) {
			throw new FilterException();
		}
		return true;
	}
}
