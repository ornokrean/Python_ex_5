package filesprocessing;

import filesprocessing.Orders.OrderException;
import filesprocessing.Orders.OrderFactory;
import filesprocessing.filters.Filter;
import filesprocessing.filters.FilterException;
import filesprocessing.filters.FilterFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class FileParsing {
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
	private FilterFactory filterFact = new FilterFactory();
	private OrderFactory orderFact = new OrderFactory();
	private int currentLine = 1;
	private File[] filteredFiles;
	private boolean oppositeRule = false;
	private BufferedReader buffer;
	private String filesPath;

	public FileParsing(String filesPath, String command) throws IOException {
		this.filesPath = filesPath;

		try {
			buffer = new BufferedReader(new FileReader(command));
		} catch (IOException e) {
			System.err.print("ERROR: Bad format of Commands File\n");
			return;
		}

	}

	public ArrayList<String[]> parseFile() throws IOException {
		// open the filesPath
		// read the first line here, we don't want the while to read it every loop, maybe can be FIXED
		String commandLine = buffer.readLine();
		// create sectionsArray of 4 cells
		// create array to hold all the small sectionsArray, we don't know how much we have
		ArrayList<String[]> sectionsArray = new ArrayList<>();


		while (commandLine != null) {
			String[] section = new String[SECTION_LENGTH];
			// read the first 3 line of the section
			for (int i = 0; i < 3; i++) {
				section[i] = commandLine;
				//checking for type II errors.
				try {
					validateLine(commandLine, i);
				} catch (TypeTwoException e) {
					System.err.println(e.getMessage());
					return null;
				}
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
		return sectionsArray;
	}

	private void validateLine(String currentLine, int row) throws TypeTwoException {
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

	public void filterAndOrder(ArrayList<String[]> sections) {
		for (String[] section : sections) {
			for (int i = 0; i < SECTION_LENGTH; i++) {
				if (i == FILTER_ROW_INDEX) {
					filterFiles(parseLine(section[i], FilterFactory.NOT_SUFFIX));
				}
				if (i == ORDER_ROW_INDEX) {
					orderFiles(parseLine(section[i], OrderFactory.REVERSE_SUFFIX));
				}
				if (section[i] != null)
					currentLine++;
			}
			for (File file : filteredFiles) {
				System.out.println(file.getName());
			}
		}
	}

	public String[] parseLine(String line, String notSuffix) {
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

	public void orderFiles(String[] line) {
		try {
			Comparator<File> comparator = orderFact.getOrderComparator(line[LINE_NAME_INDEX], oppositeRule);
			Arrays.sort(filteredFiles, comparator);
		} catch (OrderException e) {
			System.err.print(String.format(e.getMessage(), currentLine));
			orderFiles(parseLine(DEFAULT_ORDER_LINE, OrderFactory.REVERSE_SUFFIX));
		}
	}


	public void filterFiles(String[] command) {
		try {
			Filter filter = filterFact.getFilter(command[LINE_NAME_INDEX]);
			if (filter.checkCommand(command)) {
				readFiles(command, filter);
			}
		} catch (FilterException e) {
			System.err.print(String.format(e.getMessage(), currentLine));
			// call to filterFiles with default filter:
			filterFiles(parseLine(DEFAULT_FILTER_LINE, FilterFactory.NOT_SUFFIX));
		}
	}

	private void readFiles(String[] command, Filter filter) {
		filteredFiles = new File(this.filesPath).listFiles(pathname -> (!pathname.isDirectory()) &&
				(filter.passFilter(pathname, command) != oppositeRule));
	}


}


