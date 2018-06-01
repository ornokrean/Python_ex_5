package filesprocessing.Orders;

import java.io.File;
/**
 * Class extends Order, determines the hierarchy between two files by the default.
 */
class AbsOrder extends Order {

    /**
     * method that determines the hierarchy between two files
     * @param file1 - file one
     * @param file2 - file two
     * @return - zero if the files are equal , positive number if file one bigger than file two ,
     * negative number if file two bigger than file one
     */
    @Override
    public int compare(File file1, File file2) {
        return defaultCompare(file1, file2);
    }

}
