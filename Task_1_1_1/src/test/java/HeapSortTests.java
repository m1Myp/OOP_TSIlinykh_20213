package ru.nsu.fit.oop.lab1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.Test;


import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class HeapSortTests {


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

    @ParameterizedTest
    @ValueSource(strings = {"4 5 1 0 -5", "99 23 -38 -93 0 0 -67 8 39 -34"})
    public void simpleTests(String str) {
        int[] arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        HeapSort.heapSort(arr);
        assertArrayEquals(sortedArr, arr);
    }

}
