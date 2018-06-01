package filesprocessing;

import filesprocessing.Orders.Order;
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


public class FileParsing {

	Filter[] filters = new FilterFactory().createFilters();
	Order[] orders = new OrderFactory().createFilters();
	int line = 2;
	File[] files;
	File[] currFiles;
	boolean hadNot = false;
	String filesPath;
	BufferedReader f ;

	public FileParsing(String file, String command) throws IOException {
		files = new File(file).listFiles();
		f = new BufferedReader(new FileReader(command));

	}

	public ArrayList<String[]> parseFile() throws IOException {
		// open the file
		// read the first line here, we don't want the while to read it every loop, maybe can be FIXED
		String currentLine = f.readLine();
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
				currentLine = f.readLine();
			}
			// if the 4'th line is not a start of a new section, add it ro the sectionsArray.
			if (currentLine != null && !currentLine.equals("FILTER")) {
				section[3] = currentLine;
				currentLine = f.readLine();
			}
			// add the section to the sections array
			sectionsArray.add(section);
		}
		return sectionsArray;
	}

	public void filterAndOrder(ArrayList<String[]> sections) {
		for (String[] section : sections) {
			currFiles = files.clone();
			for (int i=1; i<4;i+=2){
				if (i==1){
					String[] filter = parseLine(section[i],"#NOT");
					filterFiles(filter);

				}else{
					String[] order = parseLine(section[i],"#REVERSE");
					orderFiles(order);
				}
				line+=2;
			}
			for (File file:currFiles){
				System.out.println(file.getName());
			}
		}
	}

	public String[] parseLine(String line, String notSuffix) {
		hadNot = false;
		if (line.contains(notSuffix)) {
			int indexToRemove = line.indexOf(notSuffix);
			line = line.substring(0, indexToRemove);
			hadNot = true;
		}
		String[] output = line.split("#");
		return output;
	}

	public void orderFiles(String[] line) {
		String name = line[0];
		Comparator comp;
		if (name == null)
			comp = orders[OrderFactory.ABS];
		else {
			switch (name) {
				case "abs":
					comp = orders[OrderFactory.ABS];
					break;
				case "type":
					comp = orders[OrderFactory.TYPE];
					break;
				case "size":
					comp = orders[OrderFactory.SIZE];
					break;
				default:
					System.err.print("Warning at line "+line);
					return;
			}
			if (hadNot){
				comp = comp.reversed();
			}
			Arrays.sort(currFiles,comp);
		}

	}


	public void filterFiles(String[] line) {
		String name = line[0];
		ArrayList<File> filtered = new ArrayList<>();
		Filter filt;
			switch (name) {
				case "all":
					filt = filters[FilterFactory.ALL];
					break;
				case "hidden":
					filt = filters[FilterFactory.HIDDEN];
					break;
				case "executable":
					filt = filters[FilterFactory.EXECUTABLE];
					break;
				case "writable":
					filt = filters[FilterFactory.WRITABLE];
					break;
				case "suffix":
					filt = filters[FilterFactory.SUFFIX];
					break;
				case "prefix":
					filt = filters[FilterFactory.PREFIX];
					break;
				case "contains":
					filt = filters[FilterFactory.CONTAINS];
					break;
				case "file":
					filt = filters[FilterFactory.NAME];
					break;
				case "smaller_than":
					filt = filters[FilterFactory.SMALLER];
					break;
				case "between":
					filt = filters[FilterFactory.EXECUTABLE];
					break;
				case "greater_than":
					filt = filters[FilterFactory.EXECUTABLE];
					break;
				default:
					System.err.print("Warning at line "+line);
					return;
			}
			for (File file : currFiles){
				boolean pass = false;
				if (!file.isDirectory()){
					if (hadNot){
						pass = filt.passReverse(file,line);
					}else{
						pass = filt.passFilter(file,line);
					}
				}
				if (pass){
					filtered.add(file);
				}
			}
			currFiles = filtered.toArray(new File[filtered.size()]);

	}


}


