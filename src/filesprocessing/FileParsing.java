package filesprocessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileParsing {

	public ArrayList<String[]> parseFile(String path) throws IOException {
		// open the file
		BufferedReader f = new BufferedReader(new FileReader(path));
		// read the first line here, we don't want the while to read it every loop, maybe can be FIXED
		String currentLine = f.readLine();
		// create sectionsArray of 4 cells
		// create array to hold all the small sectionsArray, we don't know how much we have
		ArrayList<String[]> sectionsArray = new ArrayList<>();

		while (currentLine != null)
		{
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
						System.err.println("ERROR: Bad subsection name\n");
						System.exit(0);
					}
				}
				currentLine = f.readLine();
				// if the 4'th line is not a start of a new section, add it ro the sectionsArray.
				if (currentLine != null && !currentLine.equals("FILTER")) {
					section[3] = currentLine;
					currentLine = f.readLine();
				}
				// add the section to the sections array
				sectionsArray.add(section);
			}
		}
		return sectionsArray;
	}
}


