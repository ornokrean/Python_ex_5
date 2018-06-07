package filesprocessing.filters;

/**
 * class that create an array with all the type of filters
 */
public class FilterFactory {


	/* ******************************** constants **************************************** */

	/* Constant for case of the opposite of the filter */
	public final static String NOT_SUFFIX = "#NOT";

	/* constant that represent the filters name */
	private final static String SMALLER_FILTER_NAME = "smaller_than";
	private final static String GREATER_FILTER_NAME = "greater_than";
	private final static String BETWEEN_FILTER_NAME = "between";
	private final static String FILE_FILTER_NAME = "file";
	private final static String CONTAINS_FILTER_NAME = "contains";
	private final static String PREFIX_FILTER_NAME = "prefix";
	private final static String SUFFIX_FILTER_NAME = "suffix";
	private final static String WRITABLE_FILTER_NAME = "writable";
	private final static String EXECUTABLE_FILTER_NAME = "executable";
	private final static String HIDDEN_FILTER_NAME = "hidden";
	private final static String ALL_FILTER_NAME = "all";
	public final static String DEFAULT_FILTER_NAME = ALL_FILTER_NAME;

	/* the place of each filter in the filters array*/
	private final static int SMALLER = 0;
	private final static int GREATER = 1;
	private final static int BETWEEN = 2;
	private final static int FILE = 3;
	private final static int CONTAINS = 4;
	private final static int PREFIX = 5;
	private final static int SUFFIX = 6;
	private final static int WRITABLE = 7;
	private final static int EXECUTABLE = 8;
	private final static int HIDDEN = 9;
	private final static int ALL = 10;


	static final int NUM_OF_FILTERS = 11;

	/* fields - array that contain all the filters of the class */
	private static Filter[] filters = new Filter[NUM_OF_FILTERS];
	private static FilterFactory factory = new FilterFactory();

	public static FilterFactory instance(){
		return factory;
	}
	/**
	 * constructor that initial all the filers in the array
	 */
	private FilterFactory() {
		filters[SMALLER] = new SmallerThanFilter();
		filters[GREATER] = new GreaterThanFilter();
		filters[BETWEEN] = new BetweenFilter();
		filters[FILE] = new FileNameFilter();
		filters[CONTAINS] = new ContainsFilter();
		filters[PREFIX] = new PrefixFilter();
		filters[SUFFIX] = new SuffixFilter();
		filters[WRITABLE] = new WritableFilter();
		filters[EXECUTABLE] = new ExecutableFilter();
		filters[HIDDEN] = new HiddenFilter();
		filters[ALL] = new AllFilter();
	}

	/**
	 * return the filter according to the given name
	 * @param filterName - the name of the filter
	 * @return the filter according to the given name
	 * @throws FilterException - if the filer name doesnt match to neither oof the filters
	 */
	public Filter getFilter(String filterName) throws FilterException {
		switch (filterName) {
			case ALL_FILTER_NAME:
				return filters[FilterFactory.ALL];
			case BETWEEN_FILTER_NAME:
				return filters[FilterFactory.BETWEEN];
			case HIDDEN_FILTER_NAME:
				return filters[FilterFactory.HIDDEN];
			case EXECUTABLE_FILTER_NAME:
				return filters[FilterFactory.EXECUTABLE];
			case WRITABLE_FILTER_NAME:
				return filters[FilterFactory.WRITABLE];
			case SUFFIX_FILTER_NAME:
				return filters[FilterFactory.SUFFIX];
			case PREFIX_FILTER_NAME:
				return filters[FilterFactory.PREFIX];
			case CONTAINS_FILTER_NAME:
				return filters[FilterFactory.CONTAINS];
			case FILE_FILTER_NAME:
				return filters[FilterFactory.FILE];
			case SMALLER_FILTER_NAME:
				return filters[FilterFactory.SMALLER];
			case GREATER_FILTER_NAME:
				return filters[FilterFactory.GREATER];
			default:
				throw new FilterException();
		}
	}


}
