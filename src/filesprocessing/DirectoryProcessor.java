package filesprocessing;
import java.io.IOException;
import java.util.ArrayList;

public class DirectoryProcessor {
	public static void main(String[] args) throws IOException {
		if (args.length !=2){
			System.err.print("ERROR: Wrong usage. Should receive 2 arguments\n");
			System.exit(0);
		}
		// get the command file and process it into sections.
		FileParsing fileParse = new FileParsing(args[1]);
		ArrayList<String[]> sections = fileParse.parseFile();
		fileParse.filterAndOrder(sections);

	}

}