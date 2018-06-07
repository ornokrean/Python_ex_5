package filesprocessing;

import filesprocessing.FileProcessingExceptions.*;
import filesprocessing.Orders.OrderFactory;
import filesprocessing.filters.Filter;
import filesprocessing.filters.FilterFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * the file parsing class. the constructor will get two arguments: the filesDirectoryPath which is the
 * directory of the files to filter and order, and the commandFilePath which is the actual filter and order
 * values to act on. it will read the commands file, and will print for each section inside the matching
 * files. in event of wrong filter or order, the program will use the default as constructed in the order
 * and filter factories, and print a warning in the matching line. in event of fatal error as wrong file
 * address or format (etc.) the program will throw a TypeTwoException.
 * in order to run this class is it needed to create an instance with the proper values and to run the
 * parsefile function.
 */
public class FileParsing {

	/* ********************************* constants ************************************** */

	private static final int FILTER_HEADER_INDEX = 0;
	private static final int FILTER_ROW_INDEX = 1;
	private static final int ORDER_HEADER_INDEX = 2;
	private static final int ORDER_ROW_INDEX = 3;
	private static final int SECTION_LENGTH = 4;
	private static final int LINE_NAME_INDEX = 0;
	private static final String DEFAULT_FILTER_LINE = FilterFactory.DEFAULT_FILTER_NAME;
	private static final String DEFAULT_ORDER_LINE = OrderFactory.DEFAULT_ORDER_NAME;


	private static final String FILTER_HEADER = "FILTER";
	private static final String ORDER_HEADER = "ORDER";
	private static final int START_INDEX = 0;
	private static final String WORD_DIVIDER = "#";

	/* ************************************* fields *********************************** */
	/* the factory of the filters */
	private FilterFactory filterFact = FilterFactory.instance();
	/* the factory of the orders */
	private OrderFactory orderFact = OrderFactory.instance();
	/* the current line in the command file while running */
	private int currentLine = 1;
	/* the current filtered files to be printed */
	private File[] filteredFiles;
	/* the field of the opposite rule - used for the order and filter fields, updates according to not
	suffix in the line  */
	private boolean oppositeRule = false;
	/* the buffer reader */
	private BufferedReader buffer;
	/* the path to the files to read */
	private String filesDirectoryPath;

	/* *********************************** class Method ********************************** */

	/**
	 * Constructor
	 *
	 * @param filesDirectoryPath- the location of the files
	 * @param commandFilePath - the wanted command
	 * @throws TypeTwoException- alerts of fatal errors in the program given values.
	 */
	FileParsing(String filesDirectoryPath, String commandFilePath) throws TypeTwoException {
		this.filesDirectoryPath = filesDirectoryPath;
		try {
			buffer = new BufferedReader(new FileReader(commandFilePath));
		} catch (IOException e) {
			throw new SubsectionException();
		}
	}

	/**
	 * this method create arrays of sections to process
	 *
	 * @return - array of each section
	 * @throws TypeTwoException - alerts of fatal errors in the program given values.
	 * @throws IOException      - In out exception
	 */
	public void parseFile() throws TypeTwoException, IOException {
		// create array to hold all the small sectionsArray, we don't know how much we have, each oe is
		// section
		ArrayList<String[]> sectionsArray = new ArrayList<>();
		// open the command file
		// read the first line here, we don't want the while to read it every loop, maybe can be FIXED
		String commandLine = buffer.readLine();
		while (commandLine != null) {
			String[] section = new String[SECTION_LENGTH];
			// read the first 3 line of the section
			for (int i = 0; i < 3; i++) {
				//checking for type II errors.
				validateSectionsHeaders(commandLine, i);
				section[i] = commandLine;
				commandLine = buffer.readLine();
			}
			// if the 4'th line is not a start of a new section, add it ro the sectionsArray.
			if (commandLine != null && !commandLine.equals(FILTER_HEADER)) {
				section[ORDER_ROW_INDEX] = commandLine;
				commandLine = buffer.readLine();
			}
			// add the section to the sections array
			sectionsArray.add(section);
		}
		if (sectionsArray != null) {
			filterAndOrder(sectionsArray);
		}
	}

	/*
	 * make sure the line have no problem
	 *
	 * @param currentLine - the string in the line
	 * @param row         - the line we check
	 * @throws TypeTwoException - alerts of fatal errors in the program given values.
	 */
	private void validateSectionsHeaders(String currentLine, int row) throws TypeTwoException {
		if (currentLine != null) {
			if (row == FILTER_HEADER_INDEX && !currentLine.equals(FILTER_HEADER)) {
				throw new SubsectionException();
			} else if (row == ORDER_HEADER_INDEX && !currentLine.equals(ORDER_HEADER)) {
				throw new SubsectionException();
			}
		} else if (row == ORDER_HEADER_INDEX) {
			throw new BadFormatException();
		}
	}

	/*
	 * process each section with order and filter
	 *
	 * @param sections - the sections
	 * @throws SourceException- exception in the file we got
	 */
	void filterAndOrder(ArrayList<String[]> sections) throws SourceException {
		for (String[] section : sections) {

			for (int i = 0; i < SECTION_LENGTH; i++) {
				if (i == FILTER_ROW_INDEX) {
					filterFiles(parseLine(section[i], FilterFactory.NOT_SUFFIX));
				}
				if (i == ORDER_ROW_INDEX) {
					if (filteredFiles != null) {
						orderFiles(parseLine(section[i], OrderFactory.REVERSE_SUFFIX));
					} else {
						throw new SourceException();
					}
				}
				if (section[i] != null)
					currentLine++;
			}
			for (File file : filteredFiles) {
				System.out.println(file.getName());
			}
		}
	}

	/*
	 * process the given line to array of commands, and update the opposite rule
	 *
	 * @param line-      the given line
	 * @param notSuffix- suffix of not
	 * @return - strings array of commands
	 */
	private String[] parseLine(String line, String notSuffix) {
		oppositeRule = false;
		if (line == null) {
			line = OrderFactory.DEFAULT_ORDER_NAME;
		}
		if (line.contains(notSuffix)) {
			int indexToRemove = line.indexOf(notSuffix);
			line = line.substring(START_INDEX, indexToRemove);
			oppositeRule = true;
		}
		String[] output = line.split(WORD_DIVIDER);
		return output;
	}

	/* This method gets an order line and sorts the files accordingly */
	private void orderFiles(String[] line) {
		try {
			Comparator<File> comparator = orderFact.getOrderComparator(line[LINE_NAME_INDEX], oppositeRule);
			Arrays.sort(filteredFiles, comparator);
		} catch (OrderException e) {
			System.err.print(String.format(e.getMessage(), currentLine));
			orderFiles(parseLine(DEFAULT_ORDER_LINE, OrderFactory.REVERSE_SUFFIX));
		}
	}

	/* This method receives a filter line and filters the files accordingly */
	private void filterFiles(String[] command) {
		try {
			Filter filter = filterFact.getFilter(command[LINE_NAME_INDEX]);
			if (filter.checkCommand(command)) {
				readAndFilterFiles(command, filter);
			}
		} catch (FilterException e) {
			System.err.print(String.format(e.getMessage(), currentLine));
			// call to filterFiles with default filter:
			filterFiles(parseLine(DEFAULT_FILTER_LINE, FilterFactory.NOT_SUFFIX));
		}
	}

	/* this function reads all the files from the given path and filters them with the filter given */
	private void readAndFilterFiles(String[] command, Filter filter) {
		filteredFiles = new File(this.filesDirectoryPath).listFiles(pathname -> (pathname.isFile()) &&
				(filter.passFilter(pathname, command) != oppositeRule));
	}
}


