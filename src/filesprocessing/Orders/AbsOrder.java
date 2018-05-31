package filesprocessing.Orders;

import java.io.File;
import java.util.Comparator;

class AbsOrder extends Order implements Comparator<File> {

    AbsOrder(boolean reverse){
        super(reverse);
    }

    @Override
    Comparator createComperator() {
        comparator=Comparator.comparing(File::getAbsolutePath);
        if (reverse){
            comparator.reversed();
        }
        return comparator;
    }


    @Override
    public int compare(File o1, File o2) {
        return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
    }
}
