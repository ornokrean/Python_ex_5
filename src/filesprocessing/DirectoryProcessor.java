package filesprocessing;
import java.io.IOException;
import java.util.ArrayList;

public class DirectoryProcessor {
	static String PATH = "/Users/or/Desktop/CS/Java/ex5/src/filesprocessing/testfile";
	public static void main(String[] args) throws IOException {
//		PATH = args[1];

		PATH = "/Users/or/Downloads/files-test/Ex5SuppliedFiles/basic_filters/filter038" +
				".flt";
		// get the command file and process it into sections.
		FileParsing fileParse = new FileParsing();
		ArrayList<String[]> sections = fileParse.parseFile(PATH);
		fileParse.filterAndOrder(sections);

	}

}