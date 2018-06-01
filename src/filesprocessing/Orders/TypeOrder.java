package filesprocessing.Orders;

import java.io.File;

/**
 * Class extends Order, determines the hierarchy between two files by the type of the file. if two files
 * have the same type, the hierarchy will be determined by the default.
 */
class TypeOrder extends Order {


    private static final char DOT = '.';
    private static final String NO_TYPE = "";


    /*
     * Method that get a file and return the type of the file
     */
    private String getType(File file) {
        String path = file.getAbsolutePath();
        int i = path.lastIndexOf(DOT);
        return i > 0 ? path.substring(i + 1) : NO_TYPE;
    }

    /**
     * abstract method that determines the hierarchy between two files
     *
     * @param file1 - file one
     * @param file2 - file two
     * @return - zero if the files are equal , positive number if file one bigger than file two ,
     * negative number if file two bigger than file one
     */
    @Override
    public int compare(File file1, File file2) {
        int result = getType(file1).compareTo(getType(file2));
        return (result != EQUAL) ? result : defaultCompare(file1, file2);
    }

}
