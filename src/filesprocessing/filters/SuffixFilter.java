package filesprocessing.filters;

		import java.io.File;

public class SuffixFilter extends Filter{
	public boolean passFilter(File file, String[] args) throws FilterException {
		if (args.length != 2) {
			throw new FilterException();
		}
		return (file.getName().endsWith(args[1]));
	}
}