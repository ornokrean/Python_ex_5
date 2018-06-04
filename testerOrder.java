package filesprocessing.Orders;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class testerOrder {

    String[] absOrdered = {".file5.txt", ".file6.txt", ".file7.txt", ".file8.txt", "Same_a.txt", "file0.a",
            "file0.txt", "file1.a", "file1.txt",
            "file2.a", "file2.txt", "file3.txt", "file4.A", "file4.txt", "file5.b", "same_name_a.txt",
            "same_name_c.txt"};
    String[] typeOrder = {"file4.A", "file0.a", "file1.a", "file2.a", "file5.b", ".file5.txt",
            ".file6.txt", ".file7.txt", ".file8.txt", "Same_a.txt", "file0.txt",
            "file1.txt", "file2.txt", "file3.txt", "file4.txt", "same_name_a.txt",
            "same_name_c.txt"};
    String[] sizeOrder ={".file8.txt","Same_a.txt","file0.a","file1.a","file2.a","file4.A","file5.b","file3.txt",
            "file4.txt"," .file7.txt",".file5.txt",".file6.txt","file1.txt","file0.txt","same_name_a" +
            ".txt","file2.txt", "same_name_c.txt"};

    File c = new File("c.txt");
    File bh = new File("bh.docs");
    File bs = new File("bs.mp4");
    File k = new File("k.txt");
    File l = new File("l.txt");
    File re = new File("re.a");

    File[] notSorted = {c, bh, k, l, bs, re};
    File[] sortedByName = {bh, bs, c, k, l, re};

    String path = "C:\\testex5files\\advanced_source_directory";
    File f = new File(path);
    File[] notSortedFromFile = f.listFiles();
    Random rand = new Random();


    @Test
    public void testOrderAbs() {
        AbsOrder comp = new AbsOrder();
        Arrays.sort(notSorted, comp);
        for (int i = 0; i < notSorted.length; i++) {
            //Arrays.sort(notSortedFromFile, comp);
            System.out.println(notSorted[i]);
            System.out.println(sortedByName[i]);
        }
        Assert.assertEquals("not sorted well", notSorted, sortedByName);

        for (int i = 0; i < absOrdered.length; i++) {
            Arrays.sort(notSortedFromFile, comp);
            System.out.println(absOrdered[i]);
            System.out.println(notSortedFromFile[i]);
        }//for (int i = 0; i <absOrdered.length ; i++) {
        // Assert.assertEquals(notSortedFromFile[i].getName(),absOrdered[i]);
        //}
    }

    @Test
    public void testOrderType() {
        Comparator<File> comp = new TypeOrder();
        comp=comp.reversed();
        Arrays.sort(notSortedFromFile, comp);
        for (int i = 0; i < notSortedFromFile.length; i++) {
            System.out.println(typeOrder[i]);
            System.out.println(notSortedFromFile[i]);

        }
    }

    @Test
    public void orderSize(){
        Order comp = new SizeOrder();
        Arrays.sort(notSortedFromFile, comp);
        for (int i = 0; i < notSortedFromFile.length; i++) {
            System.out.println(sizeOrder[i]);
            System.out.println(notSortedFromFile[i]);

        }
    }
}




