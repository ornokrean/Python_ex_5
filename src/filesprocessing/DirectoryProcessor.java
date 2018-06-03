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
//		String[] args1 = new String [2];
//		args1[0]= "/Users/or/Desktop/CS/Java/ex5/tester_files/files_to_filter/simple";
//		args1[1]= "/Users/or/Desktop/CS/Java/ex5/src/filesprocessing/testfile";
		FileParsing fileParse = new FileParsing(args[0],args[1]);
		ArrayList<String[]> sections = fileParse.parseFile();
		fileParse.filterAndOrder(sections);

	}

}