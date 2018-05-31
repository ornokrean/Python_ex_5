package filesprocessing.filters;
import java.io.File;

public abstract class Filter {
	public abstract boolean passFilter(File f);

	public boolean passReverse(File f){
		return !passFilter(f);
	}


}
