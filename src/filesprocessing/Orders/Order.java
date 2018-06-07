package filesprocessing.Orders;

import java.io.File;
import java.util.Comparator;

/**
 * This class implement Comparator, and allowed to compare files by a variety of criteria, each class
 * that extend Order have to implement the method compare , that determines the hierarchy between two
 * Files.
 */
public abstract class Order implements Comparator<File> {

	static final int EQUAL = 0;

	/**
	 * abstract method that determines the hierarchy between two files
	 *
	 * @param fileOne - file one
	 * @param fileTwo - file two
	 * @return - zero if the files are equal , positive number if file one bigger than file two ,
	 * negative number if file two bigger than file one
	 */
	public abstract int compare(File fileOne, File fileTwo);

	/**
	 * The defaultCompare compare between two files by the AbsolutePath
	 *
	 * @param file1 - file1
	 * @param file2 - file 2
	 * @return zero if the files are equal , positive number if file one bigger than file two ,
	 * negative number if file two bigger than file one
	 */
	int defaultCompare(File file1, File file2) {
		return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
	}

}
