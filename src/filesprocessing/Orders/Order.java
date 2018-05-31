package filesprocessing.Orders;

import java.io.File;
import java.util.Comparator;

public abstract class Order implements Comparator <File>{

    boolean reverse;
    Comparator comparator;

    Order(boolean reverse){
        this.reverse=reverse;

    }

    abstract Comparator createComperator();

    Comparator getComparator(){
        return comparator;
    }



    }
