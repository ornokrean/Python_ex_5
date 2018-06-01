package filesprocessing.Orders;

import java.io.File;
import java.util.Comparator;

public abstract class Order implements Comparator <File>{

    boolean reverse;
    Comparator comparator;

    Order(boolean reverse){
        this.reverse=reverse;

    }

    public abstract int compare(File fileOne , File fileTwo);

    Comparator getComparator(){
        return comparator;
    }

    
    int defaultCompare(File o1, File o2) {
        return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
    }



    }
