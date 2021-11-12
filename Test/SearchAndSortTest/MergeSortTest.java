package SearchAndSortTest;

import SearchAndSort.MergeSort;
import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {
    MergeSort mySort = new MergeSort();

    @Test
    public void basicTest() {
        int[] arr1 = { 12, 11, 13, 5, 6, 7 }; // even length
        int[] arr2 = { 2, 1, 0, 4, 6, 17, 20}; // odd length
        int[] arr3 = {35, 10, 67, 7};
        int[] sorted1 = { 5, 6, 7, 11, 12, 13 };
        int[] sorted2 = { 0, 1, 2, 4, 6, 17, 20};
        int[] sorted3 = { 7, 10, 35, 67 };
        mySort.mergeSort(arr1);
        mySort.mergeSort(arr2);
        mySort.mergeSort(arr3);
        Assert.assertArrayEquals(sorted1, arr1);
        Assert.assertArrayEquals(sorted2, arr2);
        Assert.assertArrayEquals(sorted3, arr3);
    }

    @Test
    public void emptyList() {
        int[] emptyArr = {};
        int[] arr1 = {};
        mySort.mergeSort(arr1);
        Assert.assertArrayEquals(emptyArr, arr1);
        mySort.mergeSort(null); // should not throw exception
    }

    @Test
    public void listWithOneElem() {
        int[] arr1 = {3};
        int[] sorted1 = {3};
        mySort.mergeSort(arr1);
        Assert.assertArrayEquals(sorted1, arr1);
    }

    @Test
    public void listWithDuplicates() {
        int[] arr1 = { 12, 0, 12, 5, 16, 7 }; // even length
        int[] arr2 = { -17, 0, -3, -3, 6, 7, 23 }; // odd length
        int[] sorted1 = { 0, 5, 7, 12, 12, 16 };
        int[] sorted2 = { -17, -3, -3, 0, 6, 7, 23};
        mySort.mergeSort(arr1);
        mySort.mergeSort(arr2);
        Assert.assertArrayEquals(sorted1, arr1);
        Assert.assertArrayEquals(sorted2, arr2);
    }

    @Test
    public void listWithNegatives() {
        int[] arr1 = { -12, 0, -21, 5, 16, 7 }; // even length
        int[] arr2 = { -17, 0, -3, -5, 6, 7, 23 }; // odd length
        int[] sorted1 = { -21, -12, 0, 5, 7, 16 };
        int[] sorted2 = { -17, -5, -3, 0, 6, 7, 23};
        mySort.mergeSort(arr1);
        mySort.mergeSort(arr2);
        Assert.assertArrayEquals(sorted1, arr1);
        Assert.assertArrayEquals(sorted2, arr2);
    }
}
