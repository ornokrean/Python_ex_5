package filesprocessing.filters;

public class FilterFactory {
	public final static int SMALLER = 0;
	public final static int GREATER = 1;
	public final static int BETWEEEN = 2;
	public final static int NAME = 3;
	public final static int CONTAINS = 4;
	public final static int PREFIX = 5;
	public final static int SUFFIX = 6;
	public final static int WRITABLE = 7;
	public final static int EXECUTABLE = 8;
	public final static int HIDDEN = 9;
	public final static int ALL = 10;
	public static Filter[] filters = new Filter[11];

	public FilterFactory() {
		filters[SMALLER] = new SmallerThanFilter();
		filters[GREATER] = new GreaterThanFilter();
		filters[BETWEEEN] = new BetweenFilter();
		filters[NAME] = new NameFilter();
		filters[CONTAINS] = new ContainsFilter();
		filters[PREFIX] = new PrefixFilter();
		filters[SUFFIX] = new SuffixFilter();
		filters[WRITABLE] = new WritableFilter();
		filters[EXECUTABLE] = new ExecutableFilter();
		filters[HIDDEN] = new HiddenFilter();
		filters[ALL] = new AllFilter();
	}

	public Filter getFilter(String filterName) throws FilterException {
		switch (filterName) {
			case "all":
				return filters[FilterFactory.ALL];
			case "between":
				return filters[FilterFactory.BETWEEEN];
			case "hidden":
				return filters[FilterFactory.HIDDEN];
			case "executable":
				return filters[FilterFactory.EXECUTABLE];
			case "writable":
				return filters[FilterFactory.WRITABLE];
			case "suffix":
				return filters[FilterFactory.SUFFIX];
			case "prefix":
				return filters[FilterFactory.PREFIX];
			case "contains":
				return filters[FilterFactory.CONTAINS];
			case "file":
				return filters[FilterFactory.NAME];
			case "smaller_than":
				return filters[FilterFactory.SMALLER];
			case "greater_than":
				return filters[FilterFactory.GREATER];
			default:
				throw new FilterException();
		}
	}

	public Filter getDefaultFilter(){
		return filters[FilterFactory.ALL];
	}
}
