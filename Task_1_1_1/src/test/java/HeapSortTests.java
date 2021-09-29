import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

public class HeapSortTests {

    @Test
    public void simpleTests() {
        int[] arr1 = {4, 5, 1, 0, -5};
        int[] sortedArr1 = arr1.clone();
        Arrays.sort(sortedArr1);
        HeapSort.heapSort(arr1);
        assertArrayEquals(sortedArr1, arr1);
        int[] arr2 = {99, 23, -38, -93, 0, 0, -67, 8, 39, -34};
        int[] sortedArr2 = arr2.clone();
        Arrays.sort(sortedArr2);
        HeapSort.heapSort(arr2);
        assertArrayEquals(sortedArr2, arr2);
    }

    @Test
    public void testEmptyArray() {
        int[] emptyArr = {};
        int[] emptyArrSorted = emptyArr.clone();
        Arrays.sort(emptyArrSorted);
        HeapSort.heapSort(emptyArr);
        assertArrayEquals(emptyArr, emptyArrSorted);
    }

    @Test
    public void testLimitsOfIntValues() {
        int[] arr = {3, 1, 2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        HeapSort.heapSort(arr);
        assertArrayEquals(arr, sortedArr);
    }
}
