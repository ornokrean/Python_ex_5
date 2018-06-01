package filesprocessing.Orders;

import java.io.File;
import java.util.Comparator;

public abstract class Order implements Comparator<File> {

    public abstract int compare(File fileOne, File fileTwo);

    int defaultCompare(File o1, File o2) {
        return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
    }

}
