package filesprocessing.filters;

public class FilterFactory {
	final static int SMALLER = 0;
	final static int NAME = 1;
	final static int CONTAINS = 2;
	final static int PREFIX = 3;
	final static int SUFFIX = 4;
	final static int WRITABLE = 5;
	final static int EXECUTABLE = 6;
	final static int HIDDEN = 7;
	final static int ALL = 8;
	public Filter[] filters = new Filter[9];

	public Filter[] createFilters() {
		filters[SMALLER] = new SmallerThanFilter();
		filters[NAME] = new NameFilter();
		filters[CONTAINS] = new ContainsFilter();
		filters[PREFIX] = new PrefixFilter();
		filters[SUFFIX] = new SuffixFilter();
		filters[WRITABLE] = new WritableFilter();
		filters[EXECUTABLE] = new ExecutableFilter();
		filters[HIDDEN] = new HiddenFilter();
		filters[ALL] = new AllFilter();
		return filters;
	}
}
