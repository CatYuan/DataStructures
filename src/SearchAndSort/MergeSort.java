package SearchAndSort;

public class MergeSort {
    /**
     * time complexity: O(n)
     * space complexity: O(n)
     * @param arr - array to be sorted
     * @param l - left index of segment
     * @param m - middle index s.t. first sub array is arr[l, m]
     * @param r - right index of segment. s.t. second sub array is arr[m+1, r]
     */
    private void merge(int[] arr, int l, int m, int r) {
        int length1 = m-l+1;
        int length2 = r-m;
        // copy sub-arrays into new arrays stored in memory
        int[] arr1 = new int[length1];
        int[] arr2 = new int[length2];
        for (int i = 0; i < length1; i++) {
            arr1[i] = arr[l+i];
        }
        for (int i = 0; i < length2; i++) {
            arr2[i] = arr[m+1+i];
        }
        // iterate and merge the two sub-arrays
        int ptr1 = 0, ptr2 = 0;
        while (ptr1<length1 && ptr2<length2) {
            if (arr1[ptr1] < arr2[ptr2]) {
                arr[l+ptr1+ptr2] = arr1[ptr1];
                ptr1++;
            } else {
                arr[l+ptr1+ptr2] = arr2[ptr2];
                ptr2++;
            }
        }
        while (ptr1 < length1) {
            arr[l+ptr1+ptr2] = arr1[ptr1];
            ptr1++;
        }
        while (ptr2 < length2) {
            arr[l+ptr1+ptr2] = arr2[ptr2];
            ptr2++;
        }
    }

    /**
     * time complexity: O(nlogn)
     * space complexity: O(n)
     * @param arr - array to be sorted
     */
    public void mergeSort(int[] arr) {
        if (arr == null) {
            return;
        }
        _mergeSort(arr, 0, arr.length-1);
    }

    public void _mergeSort(int[] arr, int l, int r) {
        if (r <= l) { return; }
        int m = l + (r-l)/2;
        _mergeSort(arr, l, m);
        _mergeSort(arr, m+1, r);
        merge(arr, l, m, r);
    }

    public static void main(String[] args) {

    }
}
