//package filesprocessing;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.ArrayList;
//
//public class FileParsing {
//
//	public String[] ;
//	// open the file
//	BufferedReader f = new BufferedReader(new FileReader(PATH));
//	// read the first line here, we don't want the while to read it every loop, maybe can be FIXED
//	String currentLine = f.readLine();
//	// create sectionsArray of 4 cells
//	// create array to hold all the small sectionsArray, we don't know how much we have
//	ArrayList<String[]> sectionsArray = new ArrayList<>();
//	int lineNum = 1;
//
//		while (currentLine != null) {
//		String[] section = new String[4];
//
//		// read the first 3 line of the section
//		for (int i = 0; i < 3; i++) {
//			section[i] = currentLine;
//			//maybe good for checking errors type II.
////				if (currentLine!=null) {
////					if (i == 0 && !currentLine.equals("FILTER")) {
////						System.out.println("Type II error, FILTER, line " + lineNum);
////					}
////					if (i == 2 && !currentLine.equals("ORDER")) {
////						System.out.println("Type II error, ORDER, line " + lineNum);
////					}
////				}
//			currentLine = f.readLine();
//			lineNum++;
//		}
//		// if the 4'th line is not a start of a new section, add it ro the sectionsArray.
//		if (currentLine != null && !currentLine.equals("FILTER")) {
//			section[3] = currentLine;
//			currentLine = f.readLine();
//			lineNum++;
//		}
//		// add the section to the sections array
//		sectionsArray.add(section);
//	}
//
//
//
//
//	// "read" the sections, can be moved to the read from file section
//	int line = 1;
//		for (String[] readSection : sectionsArray) {
//		int i = 0;
//		for (String readLine : readSection) {
//			if (i == 0 && !readLine.equals("FILTER")) {
//				// problem at FILTER title, throw type II error.
//				System.out.println("ERROR line " + line + ":" + readLine);
//			} else if (i == 2 && !readLine.equals("ORDER")) {
//				// problem at ORDER title, throw type II error.
//				System.out.println("ERROR line " + line + ": " + readLine);
//			} else {
//				// good to go.
//				System.out.println(readLine);
//			}
//			i++;
//			if (readLine != null) {
//				// if the line is not null we will count it.
//				line++;
//			}
//		}
//		System.out.println("\n");
//	}
//}
