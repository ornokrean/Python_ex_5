package filesprocessing.Orders;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

public class testerOrder {


    File c = new File("c.txt");
    File bh = new File("bh.docs");
    File bs = new File("bs.mp4");
    File k = new File("k.txt");
    File l = new File("l.txt");
    File re = new File("re.a");

    File[] notSorted = {c, bh, k, l, bs, re};
    File[] sortedByName = {bh, bs, c, k, l, re};

    String path ="C:\\testex5files\\advanced_source_directory";
    File f = new File(path);
    File[] notSortedFromFile = f.listFiles();
    File[] sortedByNameFromFiles=


    File[] sortedByType = {}


    @Test
    public void testOrderAbs() {

        AbsOrder comp = new AbsOrder(false);
        Arrays.sort(notSorted, comp);
        Assert.assertEquals("not sorted well", notSorted, sortedByName);
    }
}


