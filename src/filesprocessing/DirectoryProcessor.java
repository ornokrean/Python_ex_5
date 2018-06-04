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
//		String args1= "/Users/or/Desktop/CS/Java/ex5/tester_files/files_to_filter/complex";
//		String args2= "/Users/or/Desktop/CS/Java/ex5/src/filesprocessing/testfile";
		FileParsing fileParse = new FileParsing(args[0],args[1]);

//		FileParsing fileParse = new FileParsing(args1,args2);

		ArrayList<String[]> sections = fileParse.parseFile();
		if (sections == null){
			return;
		}
		fileParse.filterAndOrder(sections);

	}

}