package filesprocessing.Orders;

import java.io.File;
import java.util.Comparator;

class TypeOrder extends Order {

    TypeOrder(boolean reverse) {
        super(reverse);
    }

    private String getType(File file){
        String path=file.getAbsolutePath();
        int i = path.lastIndexOf('.');
        return i>0 ?path.substring(i+1):"";
    }

    @Override
    public int compare(File file1, File file2) {
        int result;
        if (reverse){
            return compareFiles(file2, file1);
        }else {
            return compareFiles (file1, file2);
        }
    }

    private int compareFiles(File file1, File file2) {
        int result=getType(file2).compareTo(getType(file1));
        return result!=0 ? result: defaultCompare(file1, file2);
    }
}
