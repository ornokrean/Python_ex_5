package filesprocessing.filters;

import java.io.File;

/**
 * check if file size is between (inclusive) the given numbers (in k-bytes)
 */
public class BetweenFilter extends Filter {

    private double upper_bound;
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
        if (command.length != SPACIAL_NUM_OF_ARGS || lower_bound < 0 || upper_bound < lower_bound) {
            throw new FilterException();
        }
        return true;
    }


}
