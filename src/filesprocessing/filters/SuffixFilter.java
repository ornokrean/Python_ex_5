package filesprocessing.filters;

		import java.io.File;

public class SuffixFilter extends Filter{
	public boolean passFilter(File f, String[] args){
		return (f.getName().endsWith(args[1]));
	}
}