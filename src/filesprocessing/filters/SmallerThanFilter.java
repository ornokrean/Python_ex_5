package filesprocessing.filters;

import java.io.File;

public class SmallerThanFilter extends Filter{
	private static final double SIZE_FACTOR = 1024.0;
	private double bound;
	public boolean passFilter(File file, String[] args) {


		double size = file.length()/SIZE_FACTOR;
		return (size < bound);
	}
	@Override
	public boolean checkCommand(String[] command) throws FilterException{
		try {
			bound = Double.parseDouble(command[1].replace(" ", ""));
		}catch (NumberFormatException e){
			throw new FilterException();
		}
		if (command.length != 2 || bound < 0) {
			throw new FilterException();
		}
		
		return true;
	}
}
