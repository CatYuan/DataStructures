package HashTest;

import Hash.MyHashMap;
import Hash.SepChainHashMap;
import Hash.LinProbHashMap;
import Hash.QuadProbHashMap;
import Hash.DoubleHashHashMap;
import org.junit.Test;
import org.junit.Assert;

public class HashMapTest {
    MyHashMap map;

    @Test
    public void sepChainTest() {
        map = new SepChainHashMap(1);
        Assert.assertEquals(0, map.size());

        map.add(1, 1);
        map.add(2, 2);
        map.add(3, 3);
        map.add(4, 4);
        map.add(5, 5);
        Assert.assertEquals(5, map.size());
        Assert.assertEquals(1, map.find(1));
        Assert.assertEquals(2, map.find(2));
        Assert.assertEquals(3, map.find(3));
        Assert.assertEquals(4, map.find(4));
        Assert.assertEquals(5, map.find(5));

        map.remove(5);
        Assert.assertEquals(4, map.size());
        Assert.assertEquals(0, map.find(5));
        Assert.assertEquals(3, map.find(3));
    }

    @Test
    public void linProbTest() {
        map = new LinProbHashMap(5);
        Assert.assertEquals(0, map.size());

        map.add(1, 1);
        map.add(2, 2);
        map.add(3, 3);
        map.add(4, 4);
        map.add(5, 5);
        Assert.assertEquals(5, map.size());
        Assert.assertEquals(1, map.find(1));
        Assert.assertEquals(2, map.find(2));
        Assert.assertEquals(3, map.find(3));
        Assert.assertEquals(4, map.find(4));
        Assert.assertEquals(5, map.find(5));

        map.remove(5);
        Assert.assertEquals(4, map.size());
        Assert.assertEquals(0, map.find(5));
        Assert.assertEquals(3, map.find(3));
    }

    @Test
    public void quadProbTest() {
        map = new QuadProbHashMap(10);
        Assert.assertEquals(0, map.size());

        map.add(1, 1);
        map.add(2, 2);
        map.add(3, 3);
        map.add(4, 4);
        map.add(5, 5);
        Assert.assertEquals(5, map.size());
        Assert.assertEquals(1, map.find(1));
        Assert.assertEquals(2, map.find(2));
        Assert.assertEquals(3, map.find(3));
        Assert.assertEquals(4, map.find(4));
        Assert.assertEquals(5, map.find(5));

        map.remove(5);
        Assert.assertEquals(4, map.size());
        Assert.assertEquals(0, map.find(5));
        Assert.assertEquals(3, map.find(3));
    }

    @Test
    public void doubleHashTest() {
        map = new DoubleHashHashMap(3);
        Assert.assertEquals(0, map.size());

        map.add(1, 1);
        map.add(2, 2);
        map.add(3, 3);
        map.add(4, 4);
        map.add(5, 5);
        Assert.assertEquals(5, map.size());
        Assert.assertEquals(1, map.find(1));
        Assert.assertEquals(2, map.find(2));
        Assert.assertEquals(3, map.find(3));
        Assert.assertEquals(4, map.find(4));
        Assert.assertEquals(5, map.find(5));

        map.remove(5);
        Assert.assertEquals(4, map.size());
        Assert.assertEquals(0, map.find(5));
        Assert.assertEquals(3, map.find(3));
    }
}
