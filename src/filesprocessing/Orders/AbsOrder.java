package filesprocessing.Orders;

import java.io.File;
import java.util.Comparator;

class AbsOrder extends Order implements Comparator<File> {

    AbsOrder(boolean reverse){
        super(reverse);
    }

    @Override
    public int compare(File file1, File file2) {
        if (reverse){
            return defaultCompare(file2 , file1);
        }
        return defaultCompare(file1,file2);
    }

}
