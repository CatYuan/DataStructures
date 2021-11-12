package SearchAndSortTest;

import SearchAndSort.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
    BinarySearch binSearch = new BinarySearch();

    @Test
    public void basicTest() {
        int[] sortedArr = { 2, 3, 4, 10, 40 };
        Assert.assertEquals(0,binSearch.search(sortedArr, 2));
        Assert.assertEquals(4,binSearch.search(sortedArr, 40));
        Assert.assertEquals(1,binSearch.search(sortedArr, 3));
        Assert.assertEquals(-1,binSearch.search(sortedArr, 1));
        Assert.assertEquals(-1,binSearch.search(sortedArr, 5));
        Assert.assertEquals(-1,binSearch.search(sortedArr, 50));
    }

    @Test
    public void emptyList() {
        int[] sortedArr = {};
        Assert.assertEquals(-1, binSearch.search(sortedArr, 1));
        Assert.assertEquals(-1, binSearch.search(null, 1));
    }

    @Test
    public void listWithNegatives() {
        int[] sortedArr = {-10, -3, 0, 1, 6, 20};
        Assert.assertEquals(1,binSearch.search(sortedArr, -3));
        Assert.assertEquals(2,binSearch.search(sortedArr, 0));
        Assert.assertEquals(4,binSearch.search(sortedArr, 6));
        Assert.assertEquals(-1,binSearch.search(sortedArr, -6));
        Assert.assertEquals(-1,binSearch.search(sortedArr, 7));
    }

    @Test
    public void listWithDuplicates() {
        // better to use exponential binary search in this case
    }
}
