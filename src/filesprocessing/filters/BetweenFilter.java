package filesprocessing.filters;

import java.io.File;

public class BetweenFilter extends Filter {
	private static final int SIZE_FACTOR = 1024;

	public boolean passFilter(File f, String[] args) throws FilterException{
		long upper_bound = (long) Double.parseDouble(args[1].replace(" ",""));
		long lower_bound = (long) Double.parseDouble(args[2].replace(" ",""));
		System.out.println("srgs between :");
		for (String s : args){
			System.out.println(s);

		}
		System.out.println("done args");
		if (args.length != 3 || lower_bound < 0 || upper_bound < lower_bound) {
			throw new FilterException();
		}
		long size = f.length() / SIZE_FACTOR;
		return (lower_bound <= size && size <= upper_bound);
	}
}
