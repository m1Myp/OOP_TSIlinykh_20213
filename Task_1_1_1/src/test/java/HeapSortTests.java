import static org.junit.Assert.*;

import org.junit.Test;

public class HeapSortTests {

    @Test
    public void simpleTests() {
        int[] arr1 = {4, 5, 1, 0, -5};
        int[] sortedArr1 = {-5, 0, 1, 4, 5};
        HeapSort.heapSort(arr1, arr1.length);
        assertArrayEquals(sortedArr1, arr1);
        int[] arr2 = {99, 23, -38, -93, 0, 0, -67, 8, 39, -34};
        int[] sortedArr2 = {-93, -67, -38, -34, 0, 0, 8, 23, 39, 99};
        HeapSort.heapSort(arr2, arr2.length);
        assertArrayEquals(sortedArr2, arr2);
    }

    @Test
    public void testEmptyArr() {
        int[] emptyArr = {};
        int[] emptyArrSorted = {};
        HeapSort.heapSort(emptyArr, 0);
        assertArrayEquals(emptyArr, emptyArrSorted);
    }

    @Test
    public void testLimIntVal() {
        int[] arr = {3, 1, 2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[] sortedArr = {Integer.MIN_VALUE, Integer.MIN_VALUE, 1, 2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE};
        HeapSort.heapSort(arr, arr.length);
        assertArrayEquals(arr, sortedArr);
    }
}