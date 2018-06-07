package filesprocessing;

import filesprocessing.FileProcessingExceptions.TypeTwoException;
import filesprocessing.FileProcessingExceptions.WrongArgumentsException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The ain class , get the argument from the user ,check if there is exactly two arguments , and if so'
 * run the project.
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
			ArrayList<String[]> sections = fileParse.parseFile();
			if (sections != null) {
				fileParse.filterAndOrder(sections);
			}
		} catch (TypeTwoException e) {
			System.err.println(e.getMessage());
		}
	}
}