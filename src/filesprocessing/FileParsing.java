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
	private static final String FILTER_HEADER = "FILTER";
	private static final String ORDER_HEADER = "FILTER";

	private static final String WORD_DIVIDER = "#";
	private FilterFactory filterFact = new FilterFactory();
	private OrderFactory orderFact = new OrderFactory();
	private int currentLine = 1;
	private File[] currentFiles;
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
			String[] section = new String[4];
			// read the first 3 line of the section
			for (int i = 0; i < 3; i++) {
				section[i] = commandLine;

				//checking errors type II.
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
				section[3] = commandLine;
				commandLine = buffer.readLine();
			}
			// add the section to the sections array
			sectionsArray.add(section);
		}
		return sectionsArray;
	}

	private boolean validateLine(String currentLine, int i) throws TypeTwoException {
		if (currentLine != null) {
			if (i == 0 && !currentLine.equals(FILTER_HEADER)) {
				throw new SubsectionException();
			} else if (i == 2 && !currentLine.equals(ORDER_HEADER)) {
				throw new SubsectionException();
			}
		} else if (i == 2) {
			throw new BadFormatException();
		}
		return true;
	}

	public void filterAndOrder(ArrayList<String[]> sections) {
		for (String[] section : sections) {
			for (int i = 0; i < 4; i++) {
				if (i == 1) {
					filterFiles(parseLine(section[i], FilterFactory.NOT_SUFFIX));
				}
				if (i == 3) {
					orderFiles(parseLine(section[i], OrderFactory.REVERSE_SUFFIX));
				}
				if (section[i] != null)
					currentLine++;
			}

			for (File file : currentFiles) {
				System.out.println(file.getName());
			}
		}
	}

	public String[] parseLine(String line, String notSuffix) {
		oppositeRule = false;
		if (line == null) {
			line = OrderFactory.DEFAULT_COMPARATOR_NAME;
		}
		if (line.contains(notSuffix)) {
			int indexToRemove = line.indexOf(notSuffix);
			line = line.substring(0, indexToRemove);
			oppositeRule = true;
		}
		String[] output = line.split(WORD_DIVIDER);

		return output;
	}

	public void orderFiles(String[] line) {
		String orderName = line[0];
		Comparator<File> comparator;
		try {
			comparator = orderFact.getOrderComparator(orderName, oppositeRule);
			Arrays.sort(currentFiles, comparator);

		} catch (OrderException e) {
			System.err.print(String.format(e.getMessage(), currentLine));
			orderFiles(parseLine(OrderFactory.DEFAULT_COMPARATOR_NAME, OrderFactory.REVERSE_SUFFIX));
		}
	}


	public void filterFiles(String[] line) {
		try {
			final Filter filter = filterFact.getFilter(line[0]);
			if (filter.checkCommand(line)) {
				readFiles(line, filter);
			}
		} catch (FilterException e) {
			System.err.print(String.format(e.getMessage(), currentLine));
			// call to default filter action:
			filterFiles(parseLine(FilterFactory.DEFAULT_FILTER_NAME, FilterFactory.NOT_SUFFIX));
		}
	}

	private void readFiles(String[] command, Filter filter) {
		currentFiles = new File(this.filesPath).listFiles(pathname -> (!pathname.isDirectory()) &&
				(filter.passFilter(pathname, command) != oppositeRule));
	}


}


