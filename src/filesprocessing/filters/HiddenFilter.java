package filesprocessing.filters;

import filesprocessing.Exceptions.FilterException;

import java.io.File;

/**
 * Check if the file a hidden file
 */
public class HiddenFilter extends Filter{
	private String value;
	/**
	 * check if the file was filtered
	 * @param file - the File
	 * @param args - the values of the filter
	 * @return - true if the file filtered , else false
	 */
	public boolean passFilter(File file, String[] args) {

		return (file.isHidden() && this.value.equals(YES));

	}
	/**
	 *
	 * @param command - the command that appear in the line
	 * @return -true if the command was legals , else false
	 * @throws FilterException - if the command was not legals
	 */
	@Override
	public boolean checkCommand(String[] command) throws FilterException{
		this.value = command[FIRST_ARG_PLACE];
		if (command.length != REGULAR_NUM_OF_ARGS || ifArgInvalid(value)) {
			throw new FilterException();
		}
		return true;
	}
}
