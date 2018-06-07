package filesprocessing;

import filesprocessing.FileProcessingExceptions.TypeTwoException;
import filesprocessing.FileProcessingExceptions.WrongArgumentsException;

import java.io.IOException;

/**
 * The Main class , get the argument from the user, checks if there is exactly two arguments , and if so will
 * run the project. otherwise it will print the error and stop
 */
public class DirectoryProcessor {


	/* the excepted number of arguments */
	private static final int NUM_OF_ARGS = 2;
	/* the first argument place */
	private static final int FILE_PATH = 0;
	/* the second arguments place */
	private static final int COMMAND = 1;

	/**
	 * Main method that run the project
	 *
	 * @param args-arguments from user
	 * @throws IOException - if there is a problem with the arguments
	 */
	public static void main(String[] args) throws IOException {
		try {
			if (args.length != NUM_OF_ARGS) {
				throw new WrongArgumentsException();
			}
			// get the command file and process it into sections.
			FileParsing fileParse = new FileParsing(args[FILE_PATH], args[COMMAND]);
			fileParse.parseFile();
		} catch (TypeTwoException e) {
			System.err.println(e.getMessage());
		}
	}
}