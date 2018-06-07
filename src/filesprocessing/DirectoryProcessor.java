package filesprocessing;
import java.io.IOException;
import java.util.ArrayList;

public class DirectoryProcessor {
	public static void main(String[] args) throws IOException {
		if (args.length !=2){
			System.err.print("ERROR: Wrong usage. Should receive 2 arguments\n");
			return;
		}
		// get the command file and process it into sections.

		try {
			FileParsing fileParse = new FileParsing(args[0], args[1]);
			ArrayList<String[]> sections = fileParse.parseFile();
			if (sections == null){
				return;
			}
			fileParse.filterAndOrder(sections);

		}
		catch (TypeTwoException e){
			System.err.println(e.getMessage());
		}



	}

}