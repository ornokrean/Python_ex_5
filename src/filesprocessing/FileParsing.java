package filesprocessing;

import filesprocessing.Orders.Order;
import filesprocessing.Orders.OrderFactory;
import filesprocessing.filters.Filter;
import filesprocessing.filters.FilterException;
import filesprocessing.filters.FilterFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class FileParsing {

	private FilterFactory filterFact = new FilterFactory();
	private Order[] orders = new OrderFactory().createFilters();
	private int currentLine = 1;
	private File[] allFiles;
	private File[] currentFiles;
	private boolean oppositeRule = false;
	private String filesPath;
	private BufferedReader buffer;

	public FileParsing(String file, String command) throws IOException {
		allFiles = new File(file).listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return !pathname.isDirectory();
			}
		});

		try {
			buffer = new BufferedReader(new FileReader(command));
		} catch (IOException e) {
			System.err.print("ERROR: Bad format of Commands File");
			System.exit(0);
		}

	}

	public ArrayList<String[]> parseFile() throws IOException {
		// open the file
		// read the first line here, we don't want the while to read it every loop, maybe can be FIXED
		String currentLine = buffer.readLine();
		// create sectionsArray of 4 cells
		// create array to hold all the small sectionsArray, we don't know how much we have
		ArrayList<String[]> sectionsArray = new ArrayList<>();

		while (currentLine != null) {
			String[] section = new String[4];
			// read the first 3 line of the section
			for (int i = 0; i < 3; i++) {
				section[i] = currentLine;

//				maybe good for checking errors type II.
				if (currentLine != null) {
					if (i == 0 && !currentLine.equals("FILTER")) {
						System.err.print("ERROR: Bad subsection name\n");
						System.exit(0);
					}
					if (i == 2 && !currentLine.equals("ORDER")) {
						System.err.print("ERROR: Bad subsection name\n");
						System.exit(0);
					}
				} else if (i == 2) {
					System.err.print("ERROR: Bad format of Commands File\n");
					System.exit(0);
				}
				currentLine = buffer.readLine();
			}
			// if the 4'th line is not a start of a new section, add it ro the sectionsArray.
			if (currentLine != null && !currentLine.equals("FILTER")) {
				section[3] = currentLine;
				currentLine = buffer.readLine();
			}
			// add the section to the sections array
			sectionsArray.add(section);
		}
		return sectionsArray;
	}

	public void filterAndOrder(ArrayList<String[]> sections) {
		for (String[] section : sections) {
			currentFiles = allFiles.clone();
			for (int i = 0; i < 4; i++) {
				if (i == 1) {
					String[] filter = parseLine(section[i], "#NOT");
					filterFiles(filter);

				}
				if (i == 3) {
					String[] order = parseLine(section[i], "#REVERSE");
					orderFiles(order);
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
			line = "abs";
		}
		if (line.contains(notSuffix)) {
			int indexToRemove = line.indexOf(notSuffix);
			line = line.substring(0, indexToRemove);
			oppositeRule = true;
		}
		String[] output = line.split("#");

		return output;
	}

	public void orderFiles(String[] line) {
		String name = line[0];
		Comparator<File> comparator;
		switch (name) {
			case "abs":
				comparator = orders[OrderFactory.ABS];
				break;
			case "type":
				comparator = orders[OrderFactory.TYPE];
				break;
			case "size":
				comparator = orders[OrderFactory.SIZE];
				break;
			default:
				comparator = orders[OrderFactory.ABS];
				System.err.print("Warning in line " + currentLine + "\n");
				break;
		}
		if (oppositeRule) {
			comparator = comparator.reversed();
		}

		Arrays.sort(currentFiles, comparator);
	}


	public void filterFiles(String[] line) {

		String name = line[0];
		ArrayList<File> filtered = new ArrayList<>();
		Filter filter;
		try {
			filter = filterFact.getFilter(name);
		} catch (FilterException e) {
			System.err.print("Warning in line " + currentLine + "\n");
			filter = filterFact.getDefaultFilter();

		}

		for (File file : currentFiles) {

			try {
				if (filter.passFilter(file, line) != oppositeRule) {
					filtered.add(file);
				}

			} catch (FilterException e) {
				System.err.print(String.format(e.getMessage(), currentLine));
				break;
			}
		}
		currentFiles = filtered.toArray(new File[filtered.size()]);

	}


}


