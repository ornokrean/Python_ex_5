package filesprocessing.Orders;

import java.io.File;

/**
 * Class extends Order, determines the hierarchy between two files by the size of the file. if two files
 * have the same size, the hierarchy will be determined by the default.
 */
class SizeOrder extends Order {

    /**
     * abstract method that determines the hierarchy between two files by the size
     *
     * @param file1 - file one
     * @param file2 - file two
     * @return - zero if the files are equal , positive number if file one bigger than file two ,
     * negative number if file two bigger than file one
     */
    @Override
    public int compare(File file1, File file2) {
        long dif = file1.length() - file2.length();
        return (dif == EQUAL) ? defaultCompare(file1, file2) : (int) dif;
    }
}
