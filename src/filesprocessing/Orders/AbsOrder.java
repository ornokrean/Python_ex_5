package filesprocessing.Orders;
import java.io.File;

class AbsOrder extends Order  {

    @Override
    public int compare(File file1, File file2) {
        return defaultCompare(file1,file2);
    }

}
