package HashTest;

import Hash.DoubleHashHashMap;
import Hash.MyHashSet;
import org.junit.Assert;
import org.junit.Test;

public class HashSetTest {
    MyHashSet map = new MyHashSet();

    @Test
    public void basicTest() {
        Assert.assertEquals(0, map.size());

        map.add(1);
        map.add(2);
        map.add(3);
        map.add(4);
        map.add(5);
        Assert.assertEquals(5, map.size());
        Assert.assertTrue(map.contains(1));
        Assert.assertTrue(map.contains(2));
        Assert.assertTrue(map.contains(3));
        Assert.assertTrue(map.contains(4));
        Assert.assertTrue(map.contains(5));

        map.remove(5);
        Assert.assertEquals(4, map.size());
        Assert.assertFalse(map.contains(5));
        Assert.assertTrue(map.contains(3));
    }
}
