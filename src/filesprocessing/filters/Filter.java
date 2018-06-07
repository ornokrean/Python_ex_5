package filesprocessing.filters;

import filesprocessing.Exceptions.FilterException;

import java.io.File;

/**
 * Filters will return all files in Source Directory that match a certain criterion. Only files are
 * returned (not directories). Only files that are directly under the source directory are returned
 * (files that are in directories that are under the source directory should not be returned).
 */
public abstract class Filter {
    /* constant that represent a different sizes of args arrays */
    static final int BASIC_NUM_OF_ARGS = 1;
    static final int REGULAR_NUM_OF_ARGS = 2;
    static final int SPACIAL_NUM_OF_ARGS = 3;

    /* constant that represent places of args on the args array */
    static final int FIRST_ARG_PLACE = 1;
    static final int SEC_ARGS_PLACE = 2;

    /* size factor for calculation of files size */
    static final double SIZE_FACTOR = 1024.0;

    /* constant Strings of yes or no - for permission */
    static final String NO = "NO";
    static final String YES = "YES";

    static final String SPACE = " ";


    /**
     * constructor
     */
    public Filter() {
    }

    /**
     * @param command - the command that appear in the line
     * @return -true if the command was legals , else false
     * @throws FilterException - if the command was not legals
     */
    public abstract boolean checkCommand(String[] command) throws FilterException;

    /**
     * check if the file was filtered
     *
     * @param file - the File
     * @param args - the values of the filter
     * @return - true if the file filtered , else false
     */
    public abstract boolean passFilter(File file, String[] args);

    /* Method that get string represent number, and return the number */
    double getBound(String str) {
        return Double.parseDouble(str.replace(SPACE, ""));
    }

    /*Method that checks if the argument is valid */
    boolean ifArgInvalid(String command) {
        return !command.equals(NO) && !command.equals(YES);
    }

}
