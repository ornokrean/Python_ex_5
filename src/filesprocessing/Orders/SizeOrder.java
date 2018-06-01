package filesprocessing.Orders;

import java.io.File;

class SizeOrder extends Order {


    @Override
    public int compare(File file1, File file2) {
        long dif = file1.length() - file2.length();
        return (dif == 0) ? defaultCompare(file1, file2) : (int) dif;
    }
}
