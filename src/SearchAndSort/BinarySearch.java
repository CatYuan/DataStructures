package SearchAndSort;

public class BinarySearch {

    /**
     * time complexity: O(logn)
     * space complexity: O(1)
     * @param arr - a sorted array
     * @param elem - the element to look for
     * @return - index of elem or -1 if not found
     */
    public int search(int[] arr, int elem) {
        if (arr == null) { return -1; }
        return _search(arr, elem, 0, arr.length-1);
    }

    public int _search(int[] arr, int elem, int l, int r) {
        if (r < l) { return -1; }
        int m = l + (r-l)/2;
        if (elem == arr[m]) {
            return m;
        }
        if (elem > arr[m]) {
            return _search(arr, elem, m+1, r);
        } else { // elem < arr[m]
            return _search(arr, elem, l, m-1);
        }
    }

    public static void main(String[] args) {

    }
}
